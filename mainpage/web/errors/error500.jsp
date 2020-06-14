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
    <h1 class="ui header">错误-500</h1>
    <div class="ui text container segment">
      <p>你访问的网站出现了内部错误。如有需要，请将下面的内容报告给管理员：</p>
      <p>${sessionScope.error500Message}</p>
    </div>
  </div>
</div>
</body>
</html>
