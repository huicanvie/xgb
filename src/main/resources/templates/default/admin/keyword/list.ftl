<#include "../common/layout.ftl"/>
<@html page_title="关键字管理" page_tab="admin">
<div class="row">
  <div class="col-md-3 hidden-sm hidden-xs">
    <#include "../components/admin_left.ftl">
    <@admin_left page_tab="keywordfilter"/>
  </div>
  <div class="col-md-9">
    <div class="panel panel-default">
      <div class="panel-heading" style="height:50px">
        关键字管理
        <span class="pull-right"><a href="/admin/keywordfilter/new" class="btn btn-sm btn-primary">添加关键字</a></span>
      </div>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>ID</th>
            <th>关键字</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
            <#list page.getContent() as keyword>
                <tr>
                  <td>${keyword.id}</td>
                  <td>${keyword.keyword}</td>
                  <td>
                      <a href="/admin/keywordfilter/${keyword.id}/edit" class="btn btn-xs btn-warning">编辑</a>&nbsp;&nbsp;
                      <a href="javascript:if(confirm('确认将[${keyword.keyword}]移出关键字列表吗?')) location.href='/admin/keywordfilter/${keyword.id}/remove'" class="btn btn-xs btn-danger">移出</a>
                  </td>
                </tr>
              </#list>
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