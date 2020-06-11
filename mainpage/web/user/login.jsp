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
</head>
<body>

<div class="ui very padded middle aligned center aligned grid">
  <div class="column">
    <h1 class="ui header">登录 | 注册</h1>
    <div class="ui placeholder segment">
      <div class="ui large form">
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
        <div class="ui blue submit button">登录</div>
      </div>
      <div class="ui horizontal divider">
        Or
      </div>
      <div class="middle aligned">
        <div class="ui big button">
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
</body>
</html>
