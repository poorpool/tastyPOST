<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020-06-11
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 本文件应当被添加进 head 标签中 --%>

<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + request.getContextPath();
%>

<base href="<%=basePath%>"/>
<link type="text/css" rel="stylesheet" href="static/css/Semantic-UI/semantic.min.css"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css"/>
<script type="text/javascript" src="static/script/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="static/css/Semantic-UI/semantic.min.js"></script>