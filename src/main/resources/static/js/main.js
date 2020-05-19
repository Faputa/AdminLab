$(function(){

    $('.menu-list>li>a').click(function(event) {
        $('ul.nav-first>li>a').removeClass('active');
        $(this).addClass('active');
    });

});