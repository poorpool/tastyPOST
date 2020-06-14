<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/14
  Time: 下午1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui large top fixed borderless menu">
  <div class="ui container">
    <div class="item" style="font-weight: bold;">tastyPOST</div>
    <a class="active item" href="square/index.jsp">主页</a>
    <div class="right menu">
      <c:if test="${empty sessionScope.user}">
        <div class="item">
          <a class="ui button" onclick="window.location.href = 'user/login.jsp'">登录</a>
        </div>
        <div class="item">
          <a class="ui primary button" onclick="window.location.href = 'user/register.jsp'">注册</a>
        </div>
      </c:if>
      <c:if test="${not empty sessionScope.user}">
        <div class="item">
          <a href="#">${sessionScope.user.username}</a>
        </div>
        <div class="item">
          <a class="ui button" onclick="window.location.href = '/userServlet?action=logout'">登出</a>
        </div>
      </c:if>
    </div>
  </div>
</div>
