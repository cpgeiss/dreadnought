<#include "/layout.ftl">
<#macro page_body>

</#macro>

<#macro page_js>
	<script type="text/javascript">
	$(function() {
		var params = 'width=' + screen.width;
		params += ', height=' + screen.height;
		params += ', top=0, left=0'
		params += ', fullscreen=yes';

		var newwin = window.open('https://free.gotomeeting.com/${problem.id}', 'gotomeetingwindow', params);
		if (window.focus) {
			newwin.focus();
		}
		window.location = "/problems";
	});
</script>
</#macro>

<@display_page/>