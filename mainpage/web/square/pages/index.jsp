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
        <c:forEach items="${requestScope.page.items}" var="item"><%-- CardItem 类型 --%>
          <div class="ui card" cardid="${item.cardId}">
            <c:if test="${not empty item.imgPath}">
              <div class="image">
                <img src="${item.imgPath}"/>
              </div>
            </c:if>
            <div class="content">
              <a class="header">${item.title}</a>
              <div class="meta">
                <span class="date">${item.date}</span>
                <span class="right floated">
                  <a userid="${item.userId}">
                    <i class="user icon"></i>
                    ${item.username}
                  </a>
                </span>
              </div>
              <div class="catag">
                <div class="ui label">${item.firstTag.name}</div>
                <c:forEach items="${item.otherTags}" var="otherTag">
                  <div class="ui tag label">${otherTag.name}</div>
                </c:forEach>
              </div>
              <div class="description">
                ${item.content}
              </div>
            </div>
            <div class="additional content">
              <span class="comments" onclick="commentsToggle();">
                <i class="comment icon"></i>
                ${item.commentNum} 评论
              </span>
              <span class="right floated likes">
                <i class="heart outline like icon"></i>
                ${item.likeNum} 喜欢
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
      <a class="ui primary basic fluid button" href="square/pages/createCard.jsp">创建新卡片</a>
    </div>
  </div>
</body>
</html>
