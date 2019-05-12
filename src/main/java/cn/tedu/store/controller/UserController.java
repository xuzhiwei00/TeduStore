package cn.tedu.store.controller;


import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UserNameAlreadyExsitException;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	//显示页面
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		System.out.println("888888888");
		return "register";
	}
	//验证用户名是否可用
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> CheckUsername(String username){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(userService.checkUsername(username)){
			rr.setState("0");
			rr.setMessage("用户名已存在");
		}else{
			rr.setState("1");
			rr.setMessage("用户名可以使用");
		}
		return rr;
	}
	//验证邮箱是否可用
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(userService.checkEmail(email)){
			rr.setState("0");
			rr.setMessage("邮箱已存在");
		}else{
			rr.setState("1");
			rr.setMessage("邮箱可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		if(userService.checkPhone(phone)){
			rr.setState("0");
			rr.setMessage("电话号码已存在");
		}else{
			rr.setState("1");
			rr.setMessage("电话号码可以使用");
		}
		return rr;
	}
	/**
	 * 用户注册
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @return
	 * 
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			//@RequestParam("uname")此处的uname是页面input框里面的name属性，因为
			//name属性定义的属性名和Bean包里User类的username不一致，所以用此注解
			@RequestParam("uname") String username,
			@RequestParam("upwd") String password,
			String email,String phone){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		try {
			userService.register(user);
		} catch (UserNameAlreadyExsitException e) {
			//当验证完成后，提交过程中，有好多人同时注册，会出现重名的情况
			rr.setState("0");
			rr.setMessage("用户名已存在");
		}
		return rr;
	}
	/**
	 * 显示登录页面
	 * @return login.jsp
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	/**
	 * 验证用户名密码
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> checkLogin(String username,String password,HttpSession session){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		try {
			User user=userService.login(username, password);
			session.setAttribute("user", user);
			rr.setState("1");
			rr.setMessage("登录成功");
			
		} catch (Exception e){
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	//用户点忘记密码操作，返回修改密码页面
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	//退出用户登录功能，退出后重定向到首页
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		//让session无条件失效
		session.invalidate();
		return "redirect:/main/showIndex.do";
	}
	@RequestMapping("/password.do")
	@ResponseBody
	public ResponseResult<Void> changePassword(HttpSession session,
												String oldPassword,String newPassword){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		try {
			User user=(User) session.getAttribute("user");
			Integer id=null;
			if(user!=null){
				id=user.getId();
			}
			userService.changePassword(id, oldPassword, newPassword);
			rr.setState("1");
			rr.setMessage("密码修改成功");
		} catch (Exception e) {
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo(){
		return "personInfo";
	}
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,String password,Integer gender,String email,String phone){
		ResponseResult<Void> rr=new ResponseResult<Void>();
		try {
			User user=(User) session.getAttribute("user");
			Integer id=null;
			if(user!=null){
				id=user.getId();
			}
			userService.updateUser(id, username, password, email, phone, gender);
			session.setAttribute("user", userService.getSelectById(id));
			rr.setState("1");
			rr.setMessage("修改成功");
		} catch (Exception e) {
			rr.setState("0");
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/doUpload.do")
	@ResponseBody
	public ResponseResult<Void> doUpdoad(@RequestParam("file") MultipartFile file,
			                            HttpSession session) throws IllegalStateException, IOException{
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user=(User) session.getAttribute("user");
		Integer id=null;
		if(user!=null){
			id=user.getId();
		}
		//上传tupian
		//获取服务器的真实路径
		String path = session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		//修改image字段的值
		userService.updateImageById("/upload/"+file.getOriginalFilename(),id);
		//更新session的user对象
		session.setAttribute("user", userService.getSelectById(id));
		rr.setState("1");
		rr.setMessage("上传图像成功");
		return rr;
		
	}
	
}
