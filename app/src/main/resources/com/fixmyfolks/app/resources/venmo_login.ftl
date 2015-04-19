<#include "/layout.ftl">
<#macro page_body>

<h2>Get your fix on folks!</h2>
<p>We've partnered with Venmo to make registration and donation processing easy. If you already have account, simply enter your login credentials or if you're new to Venmo, registration is quick and painless!</p>
<p><strong>Get started by clicking the button below.</strong></p>
<hr />
<a class="btn btn-lg btn-primary" style="margin-right:35px;" href="https://api.venmo.com/v1/oauth/authorize?client_id=${venmoClientId}&scope=make_payments%20access_profile%20access_email%20access_phone%20access_balance&response_type=code">Continue to Venmo Login</a>

</#macro>
<@display_page/>