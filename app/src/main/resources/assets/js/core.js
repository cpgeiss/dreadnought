/*
 * Core JS
 *
 *
 * by Geoff Baumbach, http://www.geoffbaumbach.com/
 */


////////////////////
// EVENT HANDLERS //
// Ready
$(document).ready(function() {
	$('header .menu').click(function(e) {
		e.preventDefault();
		$('header .menu-links').fadeToggle(300);
		return false;
	});
	$('section.home').hide().delay(500).fadeIn(1500);
	$('.bg-cover').hide().fadeIn(2000);
});

$(window).load(function () {
	fixMenuPos();
});

// Window Resize
$(window).resize(function() {
	fixMenuPos();
});

// Window Scroll 
$(window).scroll(function() {
	//
});


///////////////
// FUNCTIONS //
function fixMenuPos() {
	var menu = $('.menu-links');
	var yPos = $('header').outerHeight();
	menu.css("top", yPos);
}

// compare height size and adjust
function syncHeight(target, copy, limit) {
	var contentH = copy.outerHeight();
	var sidebarH = target.outerHeight();
	if (!limit || limit == undefined || (sidebarH < contentH)) target.css('height', contentH);
}

// scroll to anchor
function scrollToObj(obj){
    $('html,body').animate({scrollTop: obj.offset().top}, 1000, 'easeInOutQuad');
}

// centers div horizontally
function centerElement(target) { 
	var newMargin = -(target.outerWidth() / 2);
	target.css('marginLeft', newMargin);
	target.css('left', '50%');
};
