<%--
  Created by IntelliJ IDEA.
  User: poorpool
  Date: 2020/6/15
  Time: 下午7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui tab segment" data-tab="tags" id="tagMain">
  <h2 class="ui header">全部标签</h2>
  <div id="tagShow">

  </div>
  <h2 class="ui header">添加标签</h2>
  <form class="ui form" action="">
    <div class="inline field">
      <label>标签名</label>
      <input type="text" name="tagName" placeholder="不能重名，不超过 25 个汉字"/>
    </div>
    <%-- 一定要是 button 的 type，不然提交表单和 ajax 就冲突了 --%>
    <button type="button" class="ui primary button" style="margin-left: 20px;" onclick="ajaxAddTag()">添加</button>
  </form>
  <%-- 模态框-添加失败 --%>
  <div class="ui basic modal" id="tagModal">
    <i class="close icon"></i>
    <div class="header">
      添加错误
    </div>
    <div class="content">
      <p>标签添加不成功，可能是标签已经存在。</p>
    </div>
    <div class="actions">
      <div class="ui positive right labeled icon button">
        知道了
        <i class="checkmark icon"></i>
      </div>
    </div>
  </div>
  <%-- 模态框-删除失败 --%>
  <div class="ui basic modal" id="tagDelModal">
    <i class="close icon"></i>
    <div class="header">
      删除失败
    </div>
    <div class="content">
      <p>标签删除不成功，可能是已经有卡片使用了该标签。</p>
    </div>
    <div class="actions">
      <div class="ui positive right labeled icon button">
        知道了
        <i class="checkmark icon"></i>
      </div>
    </div>
  </div>
</div>
