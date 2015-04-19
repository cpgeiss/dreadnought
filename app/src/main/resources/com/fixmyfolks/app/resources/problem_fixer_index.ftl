<#include "/layout.ftl">
<#macro page_body>

<h1 style="margin-bottom:40px;">Here are your past and present fixes:</h1>
<#list problems as problem>
	<div class="panel panel-<#if problem.donationReceived>success<#else>danger</#if>">
		<div class="panel-heading"><strong><#if problem.donationReceived>COMPLETED:<#else>NOT FINALIZED!</#if></strong>&nbsp;&nbsp; ${problem.tag} <#if !problem.donationReceived><a href="/giving/charities?problemId=${problem.id}" class="donate"><img src="/assets/images/donate.png" height="25px" alt="Donate Now!" border="0" /> Finalize Donation</a></#if></div>
		<div class="panel-body">
			<strong>Description of Problem:</strong><br />
			${problem.description}
			<hr />
			<p><strong><#if problem.donationReceived>$${problem.price} Donated to ${problem.charityName}<#else><a href="/giving/charities?problemId=${problem.id}" class="donate">Please donate $${problem.price}</a></#if></strong></p>
		</div>
	</div>
</div>
</#list>

</#macro>
<@display_page/>