package cn.tedu.store.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 创建一个切面组件，就是一个普通的JavaBean
 */
@Component
@Aspect
public class DemoAspect {
	//声明test方法将在UserService的全部方法之前运行
	@Before(value="execution(* cn.tedu.store.service.CartService.addCart(..))")
	public void test(){
		System.out.println("橘子好甜");
	}
	
	
}
