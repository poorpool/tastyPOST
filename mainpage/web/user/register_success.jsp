<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/13
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册成功</title>
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
      <h1 class="ui header">注册成功！</h1>
      <div class="ui text container stacked segments">
        <div class="ui segment"><p>你要去哪儿？</p></div>
        <a href="square/index.jsp"><div class="ui segment">广场</div></a>
        <a href="http://www.baidu.com"><div class="ui segment">论坛</div></a>
      </div>
    </div>
  </div>
</body>
</html>
