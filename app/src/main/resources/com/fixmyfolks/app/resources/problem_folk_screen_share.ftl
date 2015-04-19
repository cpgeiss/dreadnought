<#include "/layout.ftl">
<#macro page_body>

<h1 class="text-center">
	<span class="waiting">Someone to help should be coming soon...</span>
	<span class="available">Thanks for using FixMyFolks!</span>
</h1>
<div class="text-center available"><a href="/problems/fixed?id=${problem.id}" class="btn btn-lg btn-success">My Problem Was Fixed</a></div>

</#macro>

<#macro page_js>
	<script type="text/javascript">
	$(function() {
		$(".available").hide();
		function pollForStatus() {
			$.get("/problems/status?id=${problem.id}", function(data) {
				if (data.fixer) {
					$(".waiting").hide();
					$(".available").show();
					var params = 'width=' + screen.width;
					params += ', height=' + screen.height;
					params += ', top=0, left=0'
					params += ', fullscreen=yes';

					var newwin = window.open('https://free.gotomeeting.com/${problem.id}', 'gotomeetingwindow', params);
					if (window.focus) {
						newwin.focus();
					}
				} else {
					setTimeout(pollForStatus, 100);
				}
			});
		}
		pollForStatus();
	});
</script>
</#macro>

<@display_page/>