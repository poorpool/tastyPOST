<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/15
  Time: 下午3:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>广场管理</title>
  <%@ include file="/common/common.jsp"%>
  <script type="text/javascript">
    $(function () {
        $('.menu .item').tab();
    });
    function ajaxQueryAllTags() {
      $.ajax({
          url: "management/managementServlet",
          data: {action: "ajaxQueryAllTags"},
          type: "GET",
          success: function (msg) {
              $("#tagShow").html('');
              $.each(msg, function (index, obj) {
                  $("#tagShow").append('<div class="ui label" ' + 'tagid="' + obj['tagId'] + '">'
                      + obj['name']
                      + '<i class="delete icon" onclick="ajaxDeleteTag(this);"></i>'
                      + '</div>');
              });
          },
          dataType: "json"
      });
    }
    function ajaxAddTag() {
        $.ajax({
            url: "management/managementServlet",
            data: {action: "ajaxAddTag", tagName: $("input[name='tagName']").val()},
            type: "GET",
            success: function (msg) {
                if (msg['result'] == true) {
                    ajaxQueryAllTags();
                } else {
                    $("#tagModal").modal('show');
                }
                $("input[name='tagName']").val('');
            },
            dataType: "json"
        });
    }
    function ajaxDeleteTag(obj) {
        var $tagObj = $(obj).parent();
        if (!confirm('你确定要删除标签[' + $tagObj.text() + ']吗？')) {
            return ;
        }
        $.ajax({
            url: "management/managementServlet",
            data: {action: "ajaxDeleteTag", tagId: $tagObj.attr('tagid')},
            type: "GET",
            success: function (msg) {
                if (msg['result'] == true) {
                    ajaxQueryAllTags();
                } else {
                    $("#tagDelModal").modal('show');
                }
                $("input[name='tagName']").val('');
            },
            dataType: "json"
        });
    }
  </script>
  <style>
    .tab.segment {
      margin-top: 0;
    }
  </style>
</head>
<body>
  <%@ include file="/common/square_menu.jsp"%>

  <div class="ui container segment grid" style="margin-top: 60px;">
    <div class="four wide column">
      <div class="ui left attached vertical tabular menu">
        <a class="item" data-tab="tags" onclick="ajaxQueryAllTags();">标签管理</a>
        <a class="item" data-tab="second">第二</a>
        <a class="item" data-tab="third">第三</a>
      </div>
    </div>
    <div class="twelve wide column">
      <%@ include file="details/tags_data_tab.jsp"%>


      <div class="ui tab segment" data-tab="second">
        第二
      </div>
      <div class="ui tab segment" data-tab="third">
        第三
      </div>
    </div>
  </div>
</body>
</html>
