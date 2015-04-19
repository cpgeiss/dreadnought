<#include "/layout.ftl">
<#macro page_body>

<#list problems as problem>
	<div>${problem.description} <a href="/problems/start?id=${problem.id}">Fix Problem</a></div>
</#list>

</#macro>
<@display_page/>