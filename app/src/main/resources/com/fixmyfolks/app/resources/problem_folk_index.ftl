<#include "/layout.ftl">
<#macro page_body>

<a href="/problems/new">Create new problem</a>

<#list problems as problem>
	${problem.description}
</#list>

</#macro>
<@display_page/>