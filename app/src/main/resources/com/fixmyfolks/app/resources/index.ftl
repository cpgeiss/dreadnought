<#include "/layout.ftl">
<#macro page_body>

<a href="https://api.venmo.com/v1/oauth/authorize?client_id=${venmoClientId}&scope=make_payments%20access_profile%20access_email%20access_phone%20access_balance&response_type=code">Login as fixer</a>

</#macro>
<@display_page/>