<#include "../common/layout.ftl"/>
<@html page_title="${username}个人主页" page_tab="user">
<div class="row">
  <div class="col-md-9">

  <#--user info-->
    <@current_user_tag username=username>
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="media">
            <div class="media-left">
              <img src="${currentUser.avatar}" class="avatar-lg" alt=""/>
            </div>
            <div class="media-body">
              <h3 style="margin-top: 0">${currentUser.username!}</h3>
              <p>积分：<a href="/top100">${currentUser.score!0}</a></p>
              <#if currentUser.signature??>
                <p><i class="gray">${currentUser.signature!}</i></p>
              </#if>
              <div>收藏话题: <a href="/user/${currentUser.username}/collects">${collectCount!0}</a></div>
              <#if currentUser.url??>
                <div>主页: <a href="${currentUser.url!}" target="_blank">${currentUser.url!}</a></div>
              </#if>
              <div>入驻时间: ${model.formatDate(currentUser.inTime)}</div>
            </div>
          </div>
        </div>
      </div>
    </@current_user_tag>

  <#--user topics-->
    <#include "../components/user_topics.ftl"/>
    <@user_topics username=username p=1 limit=7 isFooter=true/>

  <#--user replies-->
    <#include "../components/user_replies.ftl"/>
    <@user_replies username=username p=1 limit=7 isFooter=true/>

  </div>

  <div class="col-md-3 hidden-sm hidden-xs">
  </div>

</div>
</@html>