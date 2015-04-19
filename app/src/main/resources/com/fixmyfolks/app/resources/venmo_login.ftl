<#include "/layout.ftl">
<#macro page_body>

<#if type == "folk">
	Signing up as a Folk 
<#else>
	Signing up as a Fixer
</#if>

<a href="https://api.venmo.com/v1/oauth/authorize?client_id=${venmoClientId}&scope=make_payments%20access_profile%20access_email%20access_phone%20access_balance&response_type=code" class="btn btn-primary">Sign Up</a>

</#macro>
<@display_page/>