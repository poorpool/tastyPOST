<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/13
  Time: 下午5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>注册</title>
  <%@ include file="/common/common.jsp"%>
  <style>
    body > .grid {
      height: 100%;
    }
  </style>
  <script type="text/javascript" src="/static/script/sha512.js"></script>
  <script>
    function encryptAndSubmit() {
        var $password = $("form > div:eq(1) > input");
        var encryptedData = sha512($password.val());
        $password.val(encryptedData);
    }

    $(function () {
      $('.ui.form')
        .form({
          fields: {
            username: {
              identifier: 'username',
              rules: [
                {
                  type: 'regExp',
                  value: '/^[a-zA-Z0-9_-]{2,40}$/',
                  prompt: '用户名长为 2 到 40 位，只能包含字母、数字、下划线或减号'
                }
              ]
            },
            password: {
              identifier: 'password',
              rules: [
                {
                  type: 'regExp',
                  value: '/^[0-9A-Za-z^%&\',;=?$]{6,40}$/',
                  prompt: '密码长为 6 到 40位，只能包含数字、字母或^%&\',;=?$中的特殊符号'
                }
              ]
            },
            email: {
                identifier: 'email',
                rules: [
                  {
                    type: 'email',
                    prompt: '请输入合法邮箱'
                  }
                ]
            },
          },onSuccess: function(){
              encryptAndSubmit();
              $.post("/userServlet", "action=registerUser&" + $(this).serialize(), function (data) {
                  alert(data);
              }, "json");
          }
      });
    });
  </script>
</head>
<body>

  <div class="ui very padded middle aligned center aligned grid">
    <div class="column">
      <h1 class="ui header">注册</h1>
      <div class="ui container">
        <div class="ui placeholder segment">
          <form class="ui form" action="/userServlet?action=registerUser" method="post">
            <div class="field">
              <label>用户名</label>
              <input type="text" name="username" placeholder="username"/>
            </div>
            <div class="field">
              <label>密码</label>
              <input type="password" name="password" placeholder="password"/>
            </div>
            <div class="field">
              <label>邮箱</label>
              <input type="email" name="email" placeholder="email"/>
            </div>
            <button type="submit" class="ui primary button">注册</button>

            <!--显示校验信息-->
            <div class="ui error message"></div>
          </form>
          <div class="ui horizontal divider">
            Or
          </div>
          <div class="middle aligned">
            <div class="ui button">
              <i class="sign-in icon"></i>
              登录
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
