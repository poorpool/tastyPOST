<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/14
  Time: 上午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>错误！</title>
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
    <h1 class="ui header">错误-没有权限</h1>
    <div class="ui text container segment">
      <p>你没有访问该地址的权限</p>
      <p><a href="index.jsp">返回首页</a></p>
    </div>
  </div>
</div>
</body>
</html>
