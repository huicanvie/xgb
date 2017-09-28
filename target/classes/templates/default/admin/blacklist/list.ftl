<#include "../common/layout.ftl"/>
<@html page_title="黑名单管理" page_tab="admin">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../components/admin_left.ftl">
    <@admin_left page_tab="blacklist"/>
  </div>
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading">
        黑名单管理
        <span class="pull-right">个用户</span>
      </div>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
          	<th><input type="checkbox" title="全选"></th>
            <th>ID</th>
            <th>用户名</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
            
          </tbody>
        </table>
      </div>
      <div class="panel-body" style="padding: 0 15px;">
        <#include "../components/paginate.ftl"/>
      </div>
    </div>
  </div>
</div>
</@html>