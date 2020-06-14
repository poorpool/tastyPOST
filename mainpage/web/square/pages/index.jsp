<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/14
  Time: 下午12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%-- 本页面应该为 Servlet 转发得到的 --%>
  <title>广场</title>
  <%@ include file="/common/common.jsp"%>
  <script type="text/javascript">
    function commentsToggle() {
      $(".ui.comments").toggle();
    }
  </script>
</head>
<body>
  <%@ include file="/common/square_menu.jsp"%>

  <!-- 页面内容 -->
  <div class="ui container segment grid" style="margin-top: 60px; padding-top: 0;">
    <div class="eleven wide column">
      <div class="ui two stackable cards">
        <c:forEach begin="1" end="20">
          <div class="ui card">
            <div class="image">
              <img src="images/9/2020/1.jpeg"/>
            </div>
            <div class="content">
              <a class="header">美丽猫猫</a>
              <div class="meta">
                <span class="date">2020-06-13</span>
                <span class="right floated">
                  <i class="user icon"></i>
                  poorpool
                </span>
              </div>
              <div class="catag">
                <div class="ui label">东四食堂二楼</div>
                <div class="ui tag label">小猫</div>
                <div class="ui tag label">喵喵</div>
                <div class="ui tag label">喵喵</div>
                <div class="ui tag label">喵喵</div>
                <div class="ui tag label">喵喵</div>
                <div class="ui tag label">喵喵</div>
              </div>
              <div class="description">
                猫猫是一只猫猫，器狼覺得你們一天,了喔現場:想了什麼啊啊興趣跟我今晚,什麼很少。四十提醒能量其實如果:單四時候?的對在你自然啦啦,的開會生,時候幾句。
              </div>
            </div>
            <div class="additional content">
              <span class="comments" onclick="commentsToggle();">
                <i class="comment icon"></i>
                3 comments
              </span>
              <span class="right floated likes">
                <i class="heart outline like icon"></i>
                17 likes
              </span>
            </div>
            <div class="ui comments" style="margin: 10px; display: none;">
              <div class="comment">
                <a class="avatar">
                </a>
                <div class="content">
                  <a class="author">Matt</a>
                  <div class="metadata">
                    <span class="date">Today at 5:42PM</span>
                  </div>
                  <div class="text">
                    How artistic!
                  </div>
                  <div class="actions">
                    <a class="reply">Reply</a>
                  </div>
                </div>
              </div>
              <form class="ui reply form">
                <div class="field">
                  <textarea></textarea>
                </div>
                <div class="ui blue labeled submit icon button">
                  <i class="icon edit"></i> Add Reply
                </div>
              </form>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    <div class="right floated five wide column">
      d
    </div>
  </div>
</body>
</html>
