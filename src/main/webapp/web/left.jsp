<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt >我的订单
            
                <img src="${pageContext.request.contextPath}/images/myOrder/myOrder2.png">
            </dt>
            <dd class="first_dd"><a href="orders.html">全部订单</a></dd>
            <dd>
                <a href="#">
                    待付款
                    <span><!--待付款数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待收货
                    <span><!--待收货数量-->1</span>
                </a>
            </dd>
            <dd>
                <a href="#">
                    待评价<span><!--待评价数量--></span>
                </a>
            </dd>
            <dd>
                <a href="#">退货退款</a>
            </dd>
        </dl>

        <dl class="footMark">
            <dt >我的优惠卷<img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png"></dt>
        </dl>
        <dl class="address">
                <dt>收货地址<img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png"></dt>
				<dd><a href="${pageContext.request.contextPath}/address/showAddress.do">地址管理</a></dd>
        </dl>
        <dl class="count_managment">
                <dt >帐号管理<img src="${pageContext.request.contextPath}/images/myOrder/myOrder1.png"></dt>
                <dd class="first_dd"><a href="${pageContext.request.contextPath}/user/showPersonInfo.do">我的信息</a></dd>
                <dd><a href="${pageContext.request.contextPath}/user/showPassword.do">安全管理</a></dd>
         </dl>
    </div>
</body>
</html>