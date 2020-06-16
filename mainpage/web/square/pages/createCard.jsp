<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/16
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>创建卡片</title>
  <%@ include file="/common/common.jsp"%>
  <style>
    body > .grid {
      height: 100%;
    }
  </style>
  <script type="text/javascript">
    $(function () {
        $.ajax({
            url: "pageServlet",
            data: {action: "ajaxQueryAllTags"},
            type: "GET",
            success: function (msg) {
                $("#tagShow").html('');
                $.each(msg, function (index, obj) {
                    $(".ui.dropdown select").append('<option value="' + obj['tagId'] + '">'
                        + obj['name']
                        + '</option>');
                });
            },
            dataType: "json"
        });
        $(".ui.dropdown").dropdown();
    });
    function addSelect() {
        $("input[name='firstTagId']").val($(".ui.dropdown:first").dropdown("get value"));
        $("input[name='otherTags']").val($(".ui.dropdown:eq(1)").dropdown("get values"));
    }
  </script>
</head>
<body>
  <div class="ui very padded middle aligned center aligned grid">
  <div class="column">
    <h1 class="ui header">创建新卡片</h1>
    <div class="ui container">
      <div class="ui placeholder segment">
        <form class="ui form" action="square/client/createCardServlet" enctype="multipart/form-data" method="post" onsubmit="addSelect();" onclick='$(".ui.negative.message").hide()'>
          <div class="required field">
            <label>标题</label>
            <input type="text" name="title" placeholder="title" value="${requestScope.title}"/>
          </div>
          <div class="field">
            <label>图片</label>
            <input type="file" name="image"/>
          </div>
          <div class="required field">
            <label>第一标签</label>
            <select class="ui search dropdown">
              <input type="hidden" name="firstTagId"/>
            </select>
          </div>
          <div class="field">
            <label>其他标签</label>
            <select multiple="multiple" class="ui search dropdown">
              <input type="hidden" name="otherTags"/>
            </select>
          </div>
          <div class="field">
            <label>正文内容</label>
            <textarea rows="5" name="content">${requestScope.content}</textarea>
          </div>
          <button type="submit" class="ui primary button">提交</button>
          <!--显示回传的错误信息 -->
          <c:if test="${not empty requestScope.errorMessage}">
            <div class="ui negative message transition">
              <div class="header">
                  ${requestScope.errorMessage}
              </div>
            </div>
          </c:if>
        </form>
        <div class="ui horizontal divider">
          Or
        </div>
        <div class="middle aligned">
          <div class="two ui buttons">
            <button class="ui button" onclick="window.location.href='square/index.jsp'">回到广场</button>
            <button class="ui button">回到论坛</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
