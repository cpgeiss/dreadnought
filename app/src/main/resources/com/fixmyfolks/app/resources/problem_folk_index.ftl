<#include "/layout.ftl">
<#macro page_body>

<h1 style="margin-bottom:40px;">Here are your past and present problems:</h1>
<#list problems as problem>
<div class="panel panel-<#if problem.fixed>success<#else>danger</#if>">
	<div class="panel-heading"><strong><#if problem.fixed>FIXED:<#else>NOT FIXED!</#if></strong>&nbsp;&nbsp; ${problem.tag} <#if !problem.fixed><a href="/problems/delete?id=${problem.id}" class="cancel"><img src="/assets/images/cancel.png" alt="Cancel Problem" border="0" /> Cancel Problem</a></#if></div>
	<div class="panel-body">
		<strong>Description of Problem:</strong><br />
		${problem.description}
		<hr />
		<p><strong><#if problem.donationReceived>$${problem.price} Donated to ${problem.charity.name}<#else></#if>Donation set to $${problem.price}</strong></p>
	</div>
</div>
</#list>

</#macro>
<@display_page/>