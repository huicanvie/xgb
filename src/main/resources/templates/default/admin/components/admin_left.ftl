<#macro admin_left page_tab>
<div class="panel panel-default">
  <div class="list-group">
    <#if sec.allGranted("admin:index")>
      <a href="/admin/index" class="list-group-item <#if page_tab == "index">active</#if>">仪表盘</a>
    </#if>
    <#if sec.allGranted("section:list")>
      <a href="/admin/section/list" class="list-group-item <#if page_tab == "section">active</#if>">版块管理</a>
    </#if>
    <#if sec.allGranted("topic:list")>
      <a href="/admin/topic/list" class="list-group-item <#if page_tab == "topic">active</#if>">话题管理</a>
    </#if>
    <#if sec.allGranted("label:list")>
      <a href="/admin/label/list" class="list-group-item <#if page_tab == "label">active</#if>">标签管理</a>
    </#if>
    <#if sec.allGranted("reply:list")>
      <a href="/admin/reply/list" class="list-group-item <#if page_tab == "reply">active</#if>">回复管理</a>
    </#if>
    <#if sec.allGranted("user:list")>
      <a href="/admin/user/list" class="list-group-item <#if page_tab == "user">active</#if>">用户管理</a>
    </#if>
    <#if sec.allGranted("role:list")>
      <a href="/admin/role/list" class="list-group-item <#if page_tab == "role">active</#if>">角色管理</a>
    </#if>
    <#if sec.allGranted("permission:list")>
      <a href="/admin/permission/list" class="list-group-item <#if page_tab == "permission">active</#if>">权限管理</a>
    </#if>
    <#if sec.allGranted("index:all") || sec.allGranted("index:deleteAll")>
      <a href="/admin/indexed" class="list-group-item <#if page_tab == "indexed">active</#if>">索引管理</a>
    </#if>
    <#if sec.allGranted("blacklist:list")>
      <a href="/admin/blacklist/list" class="list-group-item <#if page_tab == "blacklist">active</#if>">黑名单管理</a>
    </#if>
    <#if sec.allGranted("keywordfilter:list")>
      <a href="/admin/keywordfilter/list" class="list-group-item <#if page_tab == "keywordfilter">active</#if>">关键字过滤</a>
    </#if>
  </div>
</div>
</#macro>