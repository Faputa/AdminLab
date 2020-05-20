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
        var isShow = $('.main-box.hide-left>.main-body>.body-right').is(":visible");
        var isResp = $(window).width() < 992;
        isResp ? $('.main-box').addClass('ignore-responsive') : $('.main-box').removeClass('ignore-responsive');
        isShow ? $('.main-box').removeClass('hide-left') : $('.main-box').addClass('hide-left');
    });

});