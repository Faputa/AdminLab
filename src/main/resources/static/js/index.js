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
        var isShow = $('.index-box.hide-left>.index-body>.body-right').is(":visible");
        var isResp = $(window).width() < 992;
        isResp ? $('.index-box').addClass('ignore-responsive') : $('.index-box').removeClass('ignore-responsive');
        isShow ? $('.index-box').removeClass('hide-left') : $('.index-box').addClass('hide-left');
    });

});