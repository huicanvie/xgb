<#include "../common/layout.ftl"/>
<@html page_title="添加关键字" page_tab="admin">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../components/admin_left.ftl">
    <@admin_left page_tab="keywordfilter"/>
  </div>
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading">
        添加关键字
      </div>
      <div class="panel-body">
        <form method="post" action="/admin/keywordfilter/add">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <div class="form-group">
            <label for="name">关键字</label>
            <input type="text" class="form-control" id="keyword" name="keyword" value="" placeholder="关键字">
          </div>
          <button type="submit" class="btn btn-default btn-sm">提交</button>
        </form>
      </div>
    </div>
  </div>
</div>
</@html>