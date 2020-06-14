<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020-06-11
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
  <%@ include file="/common/common.jsp"%>
  <style>
    body > .grid {
      height: 100%;
    }
  </style>
  <script type="text/javascript" src="/static/script/sha512.js"></script>
  <script type="text/javascript">
    function encryptAndSubmit() {
      var $password = $("form > div:eq(1) > div > input");
      var encryptedData = sha512($password.val());
      $password.val(encryptedData);
      return true;
    }
  </script>
</head>
<body>

<div class="ui very padded middle aligned center aligned grid">
  <div class="column">
    <h1 class="ui header">登录</h1>
    <div class="ui container">
      <div class="ui placeholder segment">
        <form class="ui large form" action="/userServlet?action=login" method="post" onsubmit="return encryptAndSubmit();">
          <div class="field">
            <label>用户名</label>
            <div class="ui left icon input">
              <input type="text" name="username" placeholder="Username"/>
              <i class="user icon"></i>
            </div>
          </div>
          <div class="field">
            <label>密码</label>
            <div class="ui left icon input">
              <input type="password" name="password"/>
              <i class="lock icon"></i>
            </div>
          </div>
          <button type="submit" class="ui primary button">登录</button>
        </form>
        <c:if test="${not empty requestScope.errorMessage}">
          <div class="ui error message transition">
            <div class="header">
              ${requestScope.errorMessage}
            </div>
          </div>
        </c:if>
        <div class="ui horizontal divider">
          Or
        </div>
        <div class="middle aligned">
          <div class="ui button">
            <i class="signup icon"></i>
            注册
          </div>
          <div class="two ui buttons">
            <button class="ui button">回到广场</button>
            <button class="ui button">回到论坛</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
