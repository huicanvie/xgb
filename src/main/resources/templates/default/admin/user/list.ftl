<#include "../common/layout.ftl"/>
<@html page_title="用户管理" page_tab="admin">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../components/admin_left.ftl">
    <@admin_left page_tab="user"/>
  </div>
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading">
        用户管理
        <span class="pull-right">${page.getTotalElements()}个用户</span>
      </div>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
          	<th><input type="checkbox" title="全选"></th>
            <th>ID</th>
            <th>用户名</th>
            <th>邮箱</th>
            <th>个人主页</th>
            <th>积分</th>
            <th>空间</th>
            <th>状态</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
            <#list page.getContent() as user>
            <tr>
              <td><input type="checkbox"></td>
              <td>${user.id}</td>
              <td><a href="/user/${user.username}" target="_blank">${user.username}</a></td>
              <td><a href="mailto:${user.email!}" target="_blank">${user.email!}</a></td>
              <td><a href="${user.url!}" target="_blank">${user.url!}</a></td>
              <td>${user.score!0}</td>
              <td>${user.spaceSize!0}MB</td>
              <td>
                <#if user.block == true>
                  <span class="text-danger">禁用</span>
                <#else>
                  <span class="text-success">正常</span>
                </#if>
              </td>
              <td>
                <#if sec.allGranted("user:role")>
                  <a href="/admin/user/${user.id}/role" class="btn btn-xs btn-warning">配置角色</a>
                </#if>
                <#if user.block == true>
                  <#if sec.allGranted("user:unblock")>
                    <a href="javascript:if(confirm('确认解禁吗?')) location.href='/admin/user/${user.id}/unblock'"
                       class="btn btn-xs btn-danger">解禁</a>
                  </#if>
                <#else>
                  <#if sec.allGranted("user:block")>
                    <a href="javascript:if(confirm('确认禁用吗?')) location.href='/admin/user/${user.id}/block'"
                       class="btn btn-xs btn-danger">禁用</a>
                  </#if>
                </#if>
              </td>
            </tr>
            </#list>
          </tbody>
        </table>
      </div>
      <div class="panel-body" style="padding: 0 15px;">
        <#include "../components/paginate.ftl"/>
        <@paginate currentPage=(page.getNumber() + 1) totalPage=page.getTotalPages() actionUrl="/admin/user/list" urlParas="" showdivide="no"/>
      </div>
    </div>
  </div>
</div>
</@html>