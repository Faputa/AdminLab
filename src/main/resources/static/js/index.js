$(function(){

    // 菜单
    $('.menu-list>li>a').click(function(event) {
        $('.menu-list>li>a').removeClass('active');
        $(this).addClass('active');
        $(this).children('span.icon-right').toggleClass('glyphicon-chevron-up').toggleClass('glyphicon-chevron-down');
        $(this).siblings('.menu-expand').slideToggle(200);
    });

    // 隐藏左侧按钮
    $('.hide-left-bar').click(function(event) {
        var isShow = $('.index-box>.index-body>.body-left').width() > 0;
        var isMini = $(window).width() < 992;
        isMini ? $('.index-box').addClass('ignore-responsive') : $('.index-box').removeClass('ignore-responsive');
        isShow ? $('.index-box').addClass('hide-left') : $('.index-box').removeClass('hide-left');
    });

});