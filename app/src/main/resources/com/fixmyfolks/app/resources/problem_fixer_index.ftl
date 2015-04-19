<#include "/layout.ftl">
<#macro page_body>

<h1 style="margin-bottom:40px;">Problems abound!</h1>
<#list problems as problem>
<div class="panel panel-danger">
	<div class="panel-heading"><strong>PROBLEM!</strong>&nbsp;&nbsp; ${problem.tag} <a href="/problems/start?id=${problem.id}" class="fix"><img src="/assets/images/fix-problem.png" alt="Fix Problem" height="25px" border="0" /> Fix Problem</a></div>
	<div class="panel-body">
		<strong>Description of Problem:</strong><br />
		${problem.description}
		<hr />
		<p><strong>Donation Amount: $${problem.price}</strong></p>
	</div>
</div>
</#list>

</#macro>
<@display_page/>