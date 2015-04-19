<#include "/layout.ftl">
<#macro page_body>

<header class="inside">
	<img class="logo" src="/assets/images/fixmyfolks-logo.png" alt="FixMyFolks" />
	<a href="#" class="menu">Menu</a>
	<ul class="menu-links">
		<li><a href="#">Account Settings</a></li>
		<li><a href="#">Problem History</a></li>
		<li><a href="#">Log out</a></li>
	</ul>
	<div class="shadow"></div>
</header>

<section class="content">
	<h1>Having technology troubles? Complete the request form below:</h1>
	<h2>What issues are you having?</h2>
	<p><select>
	<option disabled selected>Please select your problem »</option>
	<optgroup label="Phone" selected>
		<option value="Phone-iPhone">iPhone</option>
		<option value="Phone-Other">Other</option>
	</optgroup>
	<optgroup label="Tablet">
		<option value="Tablet-iPad">iPad</option>
		<option value="Tablet-Other">Other</option>
	</optgroup>
	<optgroup label="Mac Computer">
		<option value="Mac-Email">Email</option>
		<option value="Mac-Internet">Internet</option>
		<option value="Mac-Office">Office</option>
		<option value="Mac-Music">Music</option>
		<option value="Mac-Photos">Photos</option>
		<option value="Mac-Printer">Printer</option>
		<option value="Mac-Other">Other</option>
	</optgroup>
	<optgroup label="Windows Computer">
		<option value="Windows-Email">Email</option>
		<option value="Windows-Internet">Internet</option>
		<option value="Windows-Office">Office</option>
		<option value="Windows-Music">Music</option>
		<option value="Windows-Photos">Photos</option>
		<option value="Windows-Printer">Printer</option>
		<option value="Windows-Other">Other</option>
	</optgroup>
	<optgroup label="Television">
		<option value="Television-DVR">DVR</option>
		<option value="Television-Movies">Movies</option>
		<option value="Television-Other">Other</option>
	</optgroup>
</select></p>
	<h2>Can you give us a few details about your problem to better assist you?</h2>
	<p><textarea></textarea></p>
	<h2 style="margin-bottom:5px;">Please enter your donation amount:</h2>
	<p>We’ve suggested a fair amount based on the information above.</p>
	<p>$ <input type="number" class="price" value="75" /></p>
	<button type="button" class="btn btn-lg btn-warning">Get Started!</button>
</section>

<footer class="inside">
	<div><sup>$</sup>15,320 DONATIONS TO DATE</div>
	<ul>
		<li>Chris G. donated $25 to St. Jude Children’s Hospital</li>
	</ul>
</footer>

<div class="preload">
	<img src="/assets/images/menu-icon-hover.png" />
</div>

</#macro>
<@display_page/>
