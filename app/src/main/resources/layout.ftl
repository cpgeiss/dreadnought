<#macro page_js>
</#macro>
<#macro page_body>
</#macro>
<#macro page_body_no_section>
</#macro>

<#macro display_page>
<!doctype html>
<html>
	<head> 
		<title>Fix My Folks</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="dreadnought">
    <link rel="icon" href="/assets/favicon.ico">
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" type="text/css" href="/assets/css/core.css"/>
	</head>
   
	<body>
		<header class="inside">
			<a href="/"><img class="logo" src="/assets/images/fixmyfolks-logo.png" alt="FixMyFolks" /></a>
			<#if account??>
				<a href="#" class="menu">Menu</a>
				<ul class="menu-links">
					<#if !account.fixer><li><a href="/problems/new">Start a Problem</a></li></#if>
					<#if account.fixer><li><a href="/problems/current">View Current Problems</a></li></#if>
					<li><a href="/problems">Problem History</a></li>
					<li><a href="/accounts/logout">Log out</a></li>
				</ul>
			</#if>
			<div class="shadow"></div>
		</header>
		
		<@page_body_no_section/>
		
		<section class="content" style="margin-bottom: 20px;">
			<@page_body/>
		</section>

		<footer>
			<div><sup>$</sup>15,320 DONATIONS TO DATE</div>
			<ul class="cycle-slideshow" data-cycle-slides="> li" data-cycle-speed="1500" data-cycle-timeout="8000">
				<li>Chris G. donated $25 to St. Jude Children’s Hospital</li>
				<li>Marc B. donated $20 to World Wildlife Foundation</li>
			</ul>
		</footer>
		
		<div class="preload">
			<img src="/assets/images/menu-icon-hover.png" />
		</div>
	</body>
	
	<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script type='text/javascript' src="/assets/js/jquery.cycle2.min.js"></script>
	<script src="/assets/js/bootstrap.js"></script>
	<script src="/assets/js/core.js"></script>
	<@page_js/>
</html>
</#macro>
