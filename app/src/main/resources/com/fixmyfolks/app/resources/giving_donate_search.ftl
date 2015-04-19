<#include "/layout.ftl">
<#macro page_body>

	<h1>Thank you for participating with FixMyFolks, please choose a charity to donate to.</h1>
	<input type="text" id="searchCharities" class="search" placeholder="Search for a Charity..." /><button id="searchButton" type="button" class="btn btn-lg btn-primary" style="margin-top:9px;">GO</button>
	<hr />
	<ul class="donate-search-result" data-problemId="${problemId}">
	</ul>

</#macro>
<#macro page_js>
  <script type="text/javascript" src="/assets/js/donate.js"></script>
</#macro>

<@display_page/>
