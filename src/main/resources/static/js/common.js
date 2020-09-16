/**
 * Created by konohanaruto on 2016/9/18.
 */

$(function(){
    var navBarMessageBox = $('.top-nav .right-area > a:eq(2)');

    navBarMessageBox.hover(function(){
        $(this).css('background-color','#fff');
        $(this).children('.icon-header-mess').addClass('hover');
        $('.today-base').hide();
        $('.msg-box').show();
    },
    function(){
        $(this).css('background-color','transparent');
        $(this).children('.icon-header-mess').removeClass('hover');
        $('.today-base').show();
        $('.msg-box').hide();
    });

    $('.msg-box').hover(function(){
        navBarMessageBox.children('.icon-header-mess').addClass('hover');
        navBarMessageBox.css('background-color','#fff');
        $(this).show();
        $('.today-base').hide();
    },
    function(){
        navBarMessageBox.children('.icon-header-mess').removeClass('hover');
        navBarMessageBox.css('background-color','transparent');
        $(this).hide();
        $('.today-base').show();
    });

    var navBarInfoBox = $('.top-nav .right-area > a:eq(3)');

    navBarInfoBox.hover(function(){
        $(this).css('background-color','#fff');
        $(this).children('.icon-header-info').addClass('hover');
        $('.msg-box1').show();
    },
    function(){
        $(this).css('background-color','transparent');
        $(this).children('.icon-header-info').removeClass('hover');
        $('.msg-box1').hide();
    });

    $('.msg-box1').hover(function(){
        var obj = $('.top-nav .right-area > a:eq(3)');
        navBarInfoBox.children('.icon-header-info').addClass('hover');
        navBarInfoBox.css('background-color','#fff');
        $(this).show();
    },
    function(){
        navBarInfoBox.children('.icon-header-info').removeClass('hover');
        navBarInfoBox.css('background-color','transparent');
        $(this).hide();
    });

    //banner区域
    $('#top-logo .right-area li a').hover(
        function(){
            $(this).children('img').removeClass();
            $(this).children('img').addClass('md-img');
            var vipType = $(this).find('em').attr('class');
            $(this).find('em').removeClass();
            if(vipType == 'sm-vip'){
                $(this).find('em').addClass('md-vip');
            }else{
                $(this).find('em').addClass('md-svip');
            }
            $(this).width(125);
            $(this).height(125);
            $(this).css({left:-18,top:-18,'z-index':1});
        },
        function(){
            $(this).children('img').removeClass();
            $(this).children('img').addClass('sm-img');
            var vipType = $(this).find('em').attr('class');
            $(this).find('em').removeClass();
            if(vipType == 'md-vip'){
                $(this).find('em').addClass('sm-vip');
            }else{
                $(this).find('em').addClass('sm-svip');
            }
            $(this).width(70);
            $(this).height(70);
            $(this).css({left:0,top:0,'z-index':0});
        }
    );

    var newTimer = setInterval(function(){
        var obj = $('.nest-news');
        var top = parseInt(obj.css('top'));
        var step = 3;
        var top = top - step;
        //console.log(top);
        if(top <= -196){
            obj.css({top:0});
        }else{
            obj.css({top:top});
        }
    },170);

    $('#float-bar .a-to-top').hover(
        function(){
            $('#float-bar .a-to-top em').removeClass('hl');
            $('#float-bar .a-to-top em').addClass('nohl');
        },
        function(){
            $('#float-bar .a-to-top em').removeClass('nohl');
            $('#float-bar .a-to-top em').addClass('hl');
        }
    );

    $('#float-bar .a-to-top').on('click',function(){
        document.getElementsByTagName('body')[0].scrollTop = 0;
    });

    $('.switch-search').on('click',function(){
        $('.current-focus').animate({
            height:0
        },500);

        //$('.custom-search-terms').show();
        $('.custom-search-terms').animate({
            height:56
        },500);
    });

    $('.cancel-submit').on('click',function(){
        //$('.custom-search-terms').animate({
        //    height:0
        //},1000);

        $('.custom-search-terms').animate({
            height:0
        },500);
        $('.current-focus').animate({
            height:30
        },500);
    });

    $('.relation-favor-text').hover(
        function(){
            $(this).find('em').removeClass();
            $(this).find('em').addClass('icon-like-h');
        },
        function(){
            $(this).find('em').removeClass();
            $(this).find('em').addClass('icon-like-s');
        }
    );

    $('.relation-unfavor-text').hover(
        function(){
            $(this).find('em').removeClass();
            $(this).find('em').addClass('icon-unlike-h');
        },
        function(){
            $(this).find('em').removeClass();
            $(this).find('em').addClass('icon-unlike-s');
        }
    );

    $('.right-contact-btn a').hover(
        function(){
            if($(this).index() == 1){
                $(this).find('em').addClass('invoke');
            }
            $(this).addClass('current');
        },
        function(){
            if($(this).index() == 1){
                $(this).find('em').removeClass('invoke');
            }
            $(this).removeClass('current');
        }
    );

    $('.trend-content-media img').on('click',function(){
        $('#layer').show();
    });

    $('.hot-recommand .fold-trigger').on('click',function(){
        if($('.hot-recommand .fold-arrows').hasClass('up-switch')) {
            $('.hot-recommand .fold-arrows').removeClass('up-switch').addClass('down-switch');
            $('.hot-recommand').css({height:28});
        }else{
            $('.hot-recommand .fold-arrows').removeClass('down-switch').addClass('up-switch');
            $('.hot-recommand').css({height:'auto'});
        }
    });
    $('.condition-filter .select-filter').on({
        'mouseover':function(){
            discoverSelectFilterHover($(this));
        },
        'mouseout':function(){
            discoverSelectFilterOut($(this));
        },
        'click': function () {
            closeAllSelectFilter();
            if (!$(this).children('.select-bg-arrows').hasClass('up-arrows')) {
                $(this).unbind('mouseover mouseout');
                $(this).addClass('border-bot-click');
                discoverSelectFilterClick($(this));
                $(this).children('.border-r-bg').hide();
                $(this).next('.folder-item').show();
                $(this).parents('.filter-parent').addClass('fold-item-actived');
            } else {
                $(this).children('.border-r-bg').show();
                $(this).next('.folder-item').hide();
                $(this).removeClass('border-bot-click');
                discoverSelectFilterHover($(this));
                $(this).bind('mouseover', function () {
                    discoverSelectFilterHover($(this));
                });
                $(this).bind('mouseout', function () {
                    discoverSelectFilterOut($(this));
                });
                $(this).parents('.filter-parent').removeClass('fold-item-actived');
            }
        }

    });

    $('.condition-filter .fold-trigger').on('click',function(){
        if($('.condition-filter .fold-arrows').hasClass('up-switch')) {
            $('.condition-filter .fold-arrows').removeClass('up-switch').addClass('down-switch');
            $('.condition-filter .t-l').show();
        }else{
            $('.condition-filter .fold-arrows').removeClass('down-switch').addClass('up-switch');

            $('.condition-filter .t-l').hide();
        }
    });

    $(".view-recommand-user .tigger-bar .next-page").on('click',function(){
        var center = $('.center-side');
        var index = center.index();
        center.removeClass('center-side z-index-1 z-index-2').addClass('left-side z-index-1');
        if(!center.next().hasClass('js-item')){
            $('.view-recommand-user').hide();
        }
        center.next().removeClass('right-side z-index-1 z-index-2').addClass('center-side z-index-2');
    });

    $(document).on('click','.view-recommand-user .user-item .center-side',function(){
        window.location.href = window.location.href;
    });

    $('.park-nav .park-nav-item').on({
        'mouseover':function(){
            if(!$(this).hasClass('current')){
                $(this).find('.park-nav-icon').addClass('hovered');
                $(this).find('.park-nav-marked').show();
                $(this).find('.box-icon').show();
            }
        },
        'mouseout':function(){
            if(!$(this).hasClass('current')){
                $(this).find('.park-nav-icon').removeClass('hovered');
                $(this).find('.park-nav-marked').hide();
                $(this).find('.box-icon').hide();
            }
        }
    });

    $('.topic-module-forum .topic-category li').on({
        'mouseover':function(){
            var currentBg = $(this).data('bg');
            $(this).addClass('bg-' + currentBg);
            $(this).find('.topic-cat-name').addClass('active');
        },
        'mouseout':function(){
            var currentBg = $(this).data('bg');
            $(this).removeClass('bg-' + currentBg);
            $(this).find('.topic-cat-name').removeClass('active');
        }
    });

    $('.recommand-user li').on({
        'mouseover':function(){
            $(this).addClass('hovered');
            $(this).find('.view-shadow').show();
        },
        'mouseout':function(){
            $(this).removeClass('hovered');
            $(this).find('.view-shadow').hide();
        }
    });

    $('.park-dating-list li').on({
        'mouseover':function(){
            $(this).addClass('hovered');
            $(this).find('.dating-list-response').addClass('hovered');
            $(this).find('.icon-response').addClass('hovered visit');
            $(this).find('.icon-response em').addClass('hovered');
        },
        'mouseout':function(){
            $(this).removeClass('hovered');
            $(this).find('.dating-list-response').removeClass('hovered');
            $(this).find('.icon-response').removeClass('hovered visit');
            $(this).find('.icon-response em').removeClass('hovered');
        }
    });

    $('.icon-response').on({
        'mouseover':function(){
            $(this).removeClass('visit');
            $(this).addClass('hovered');
        },
        'mouseout':function(){
            $(this).removeClass('hovered');
        }
    });

    $('.gift-list-box li').on({
        'mouseover':function(){
            $(this).find('.gift-item-desc-text').addClass('hovered');
        },
        'mouseout':function(){
            $(this).find('.gift-item-desc-text').removeClass('hovered');
        }
    });
    //$(document).on('click',function(){
    //    closeAllSelectFilter();
    //});

    // 注册最终页面上传图片的触发事件
    $('.open-selet-file').on('click', function () {
        $('.img-file-input').trigger('click');
    });

    // home页会员筛选js
    $('.slider-js').unbind('click').on('click', function () {
        var feedFilterObject = $('.feed-filter');
        if (feedFilterObject.hasClass('slider-hide')) {
            // 显示
            feedFilterObject.removeClass('slider-hide');
            feedFilterObject.slideUp(1000);
        } else {
            feedFilterObject.addClass('slider-hide');
            feedFilterObject.slideDown(1000);
        }
    });

    // home页会员筛选js
    $('.feed-filter-action .submit-cancel').unbind('click').on('click', function () {
        var feedFilterObject = $('.feed-filter');
        if (feedFilterObject.hasClass('slider-hide')) {
            // 显示
            feedFilterObject.removeClass('slider-hide');
            feedFilterObject.slideUp(1000);
        } else {
            feedFilterObject.addClass('slider-hide');
            feedFilterObject.slideDown(1000);
        }
    });

    /**
     * profile-basic-tag-desc
     */
    $('.profile-basic-tag-desc .icon-edit-s').on('click', function () {
        $('.tag-too-few-modal').removeClass('hide').addClass('show');
    });


    /**
     * 模态框的关闭
     */
    $('.tag-too-few-modal > .modal-layer-main-sm > .title-row > .icon-close').on('click', function () {
        $('.tag-too-few-modal').removeClass('show').addClass('hide');
    });

    $('.tag-too-few-modal .foot-row .red-button').on('click', function () {
        $('.tag-too-few-modal').removeClass('show').addClass('hide');
    });

    /**
     * 基本出入地资料的填写
     */
    $(document).on('click', '.lover-desc-box .a-icon-edit', function () {
        var jsEditObject = $('.lover-desc-box .js-edit');
        $('.lover-desc-box .js-info-preview').removeClass('show').addClass('hide');
        jsEditObject.removeClass('hide').addClass('show');
        $(this).parent().removeClass('show').addClass('hide');
        $('.lover-desc-box .a-cancel-edit-text').parent().removeClass('hide').addClass('show');
    });

    $('.lover-desc-box .a-cancel-edit-text').on('click', function () {
        var jsEditObject = $('.lover-desc-box .js-edit');
        $('.lover-desc-box .js-info-preview').removeClass('hide').addClass('show');
        jsEditObject.removeClass('show').addClass('hide');
        $(this).parent().removeClass('show').addClass('hide');
        $('.lover-desc-box .a-icon-edit').parent().removeClass('hide').addClass('show');
    });

    $('.js-tips .icon-close').on('click', function () {
        $(this).parent().remove();
    });

    $(document).on('click', '.member-base-info .a-icon-edit', function () {
        var jsEditObject = $('.member-base-info .js-edit');
        $('.member-base-info .js-info-preview').removeClass('show').addClass('hide');
        jsEditObject.removeClass('hide').addClass('show');
        $(this).parent().removeClass('show').addClass('hide');
        $('.member-base-info .a-cancel-edit-text').parent().removeClass('hide').addClass('show');
    });

    $('.member-base-info .a-cancel-edit-text').on('click', function () {
        var jsEditObject = $('.member-base-info .js-edit');
        $('.member-base-info .js-info-preview').removeClass('hide').addClass('show');
        jsEditObject.removeClass('show').addClass('hide');
        $(this).parent().removeClass('show').addClass('hide');
        $('.member-base-info .a-icon-edit').parent().removeClass('hide').addClass('show');
    });

    $(document).on('click', '.member-detail-box .a-icon-edit', function () {
        var jsEditObject = $('.member-detail-box .js-edit');
        $('.member-detail-box .js-info-preview').removeClass('show').addClass('hide');
        jsEditObject.removeClass('hide').addClass('show');
        $(this).parent().removeClass('show').addClass('hide');
        $('.member-detail-box .a-cancel-edit-text').parent().removeClass('hide').addClass('show');
    });

    $('.member-detail-box .a-cancel-edit-text').on('click', function () {
        var jsEditObject = $('.member-detail-box .js-edit');
        $('.member-detail-box .js-info-preview').removeClass('hide').addClass('show');
        jsEditObject.removeClass('show').addClass('hide');
        $(this).parent().removeClass('show').addClass('hide');
        $('.member-detail-box .a-icon-edit').parent().removeClass('hide').addClass('show');
    });

    // myaccount
    $('.select-university .poplayer-schoolbox-select .js-switch-form').on('click', function () {
        $(this).parent().addClass('hide');
        $('.poplayer-schoolbox-select-form').removeClass('hide');
    });

    $('input.graduate-university').on('focus', function () {
        $('.modal-layer.select-university').removeClass('hide').addClass('show');
    });

    $('.modal-layer.select-university .icon-close').on('click', function () {
        $('.modal-layer.select-university').removeClass('show').addClass('hide');
    });

    $('.poplayer-schoolbox-list .js-list li').on('click', function () {
        var universityName = $(this).children('span').html();
        $('input.graduate-university').val(universityName);
        $('.modal-layer.select-university').removeClass('show').addClass('hide');
    });

    $('.poplayer-schoolbox-select-form .js-form-submit').on('click', function () {
        var clientUniversityName = $('input[name="custom-university-name"]').val();

        if (clientUniversityName) {
            // 发送到后台操作
            // ... 等待添加

            $('input.graduate-university').val(clientUniversityName);
            $('.modal-layer.select-university').removeClass('show').addClass('hide');
        }
    });

    $('.monolog-box .profile-monolog-preview a.a-icon-edit').on('click', function () {
        $(this).parent().removeClass('show').addClass('hide');
        //$('.monolog-box .profile-monolog-preview a.a-cancel-edit-text').parent().removeClass('hide').addClass('show');
        $('.monolog-box .profile-monolog-edit-hd').removeClass('hide').addClass('show');
        $('.monolog-box .profile-monolog-edit-hd .js-edit-btn').removeClass('hide').addClass('show');
        $('.monolog-box .profile-monolog-preview').removeClass('show').addClass('hide');
        $('.monolog-box .profile-monolog-textarea').removeClass('hide').addClass('show');
        $('.monolog-box .profile-monolog-edit-send').removeClass('hide').addClass('show');
        $('.profile-content-box ').css('padding-top', '210px');
    });

    $('.monolog-box .profile-monolog-edit-hd a.a-cancel-edit-text').on('click', function () {
        $(this).parent().removeClass('show').addClass('hide');
        $('.monolog-box .profile-monolog-edit-hd').removeClass('show').addClass('hide');
        $('.monolog-box .profile-monolog-preview').removeClass('hide').addClass('show');
        $('.monolog-box .profile-monolog-preview .js-edit-btn').removeClass('hide').addClass('show');
        $('.monolog-box .profile-monolog-textarea').removeClass('show').addClass('hide');
        $('.monolog-box .profile-monolog-edit-send').removeClass('show').addClass('hide');
        $('.profile-content-box ').css('padding-top', '60px');
    });

    $('.profile-tabbar li').on('click', function () {
        $('.profile-trend-box').removeClass('show').addClass('hide');
        $('.profile-info-box').removeClass('show').addClass('hide');
        $('.profile-tabbar li').each(function (i, n) {
            $(n).removeClass('current');
        });
        $(this).addClass('current');

        if ($(this).hasClass('trigger-trend')) {
            $('.profile-trend-box').addClass('show');
        } else if ($(this).hasClass('trigger-info')) {
            $('.profile-info-box').addClass('show');
        }
    });

    $(document).on('mouseup', function(e) {
        var container = $('.emoji-layer');

        // 除该div之外，点击其它任意地方，都让它隐藏
        if (! container.is(e.target) && container.has(e.target).length === 0) {
            container.removeClass('show').addClass('hide');
        }
    });

    $('.emoji-layer .winlayer-emoji-list a').on('click', function () {
        var emojiCode = $(this).data('code');
        $('.private-mess-box .publish-textarea textarea').append(emojiCode);
        $('.emoji-layer').removeClass('show').addClass('hide');
    });

    $('.private-mess-box .publish-operate .emotion-trigger').on('click', function () {
        var emojiLayer = $('.emoji-layer');
        emojiLayer.removeClass('hide').addClass('show');
    });

    $('.emoji-layer > .title-row > .icon-close').on('click', function () {
        $('.emoji-layer').removeClass('show').addClass('hide');
    });

    $('.private-mess-box > .modal-layer-main-sm > .title-row > .icon-close').on('click', function () {
        $('.private-mess-box').removeClass('show').addClass('hide');
    });

    $('.profile-basic-main > .profile-basic-relation > a.icon-mess').on('click', function() {
        $('.private-mess-box').removeClass('hide').addClass('show');
    });

    $('.modal-layer.send-gift .gift-list-ul li').on('click', function () {
        $('.modal-layer.send-gift .gift-list-ul li').each(function (i, n) {
            $(n).removeClass('selected');
        });

        $('.icon-gift-selected').each(function (i, n) {
            $(n).removeClass('show').addClass('hide');
        });

        $(this).addClass('selected');
        $(this).find('.icon-gift-selected').removeClass('hide').addClass('show');
    });

    $('.profile-basic-relation .sendgift').on('click', function () {
        $('.modal-layer.send-gift').removeClass('hide').addClass('show');
    });

    $('.modal-layer.send-gift .poplayer-slider-next').on('click', function () {
        var modalObject = $('.modal-layer.send-gift .poplayer-gift-list-box');
        var currentDisplayItem = modalObject.find('.current');
        var prevTabCount = currentDisplayItem.prevAll('ul').length;
        var nextTabCount = currentDisplayItem.nextAll('ul').length;
        var target;
        var dynamicLeftOffset;
        var step;


        // 是否存在上一页
        if (prevTabCount >= 0) {
            $(this).prev('a.poplayer-slider-prev').removeClass('disabled');
        }

        // 是否存在下一页
        if (nextTabCount) {
            if (nextTabCount == 1) {
                $(this).addClass('disabled');
            }
            currentDisplayItem.removeClass('current');
            currentDisplayItem.next('ul').addClass('current');
        } else {
            return false;
        }

        var timer = setInterval(function () {
            var leftOffset = modalObject.position().left;

            if (! target) {
                target = leftOffset - 740;
            }

            step = (Math.abs(target) - Math.abs(leftOffset)) / 3;
            step = step > 0 ? Math.ceil(step) : Math.floor(step);
            dynamicLeftOffset = leftOffset - step;

            if (step == 0) {
                clearInterval(timer);
            }

            modalObject.css({left: dynamicLeftOffset});
        }, 30);

    });

    $('.modal-layer.send-gift .poplayer-slider-prev').on('click', function () {
        var modalObject = $('.modal-layer.send-gift .poplayer-gift-list-box');
        var currentDisplayItem = modalObject.find('.current');
        var prevTabCount = currentDisplayItem.prevAll('ul').length;
        var nextTabCount = currentDisplayItem.nextAll('ul').length;
        var target;
        var dynamicLeftOffset;
        var step;

        // 是否存在上一页
        if (prevTabCount) {
            if (prevTabCount == 1) {
                $(this).addClass('disabled');
            }

            currentDisplayItem.removeClass('current');
            currentDisplayItem.prev('ul').addClass('current');
        } else {
            return false;
        }

        if (nextTabCount >= 0) {
            $(this).next('a.poplayer-slider-next').removeClass('disabled');
        }

        var timer = setInterval(function () {
            var leftOffset = modalObject.position().left;

            if (typeof target == "undefined") {
                target = leftOffset + 740;
            }

            step = (Math.abs(leftOffset) - Math.abs(target) ) / 3;
            step = step > 0 ? Math.ceil(step) : Math.floor(step);
            dynamicLeftOffset = leftOffset + step;


            if (step == 0) {
                clearInterval(timer);
            }

            modalObject.css({left: dynamicLeftOffset});
        }, 30);

    });

    $('.modal-layer.send-gift .icon-close').on('click', function () {
        $(this).parents('.modal-layer.send-gift').removeClass('show').addClass('hide');
    });

    $('.profile-mainbox .user-avatar').on('mouseover', function() {
        $(this).children('.avatar-update').removeClass('hide').addClass('show');
        $(this).children('.user-check').removeClass('show').addClass('hide');
    });

    $('.profile-mainbox .user-avatar').on('mouseout', function() {
        $(this).children('.avatar-update').removeClass('show').addClass('hide');
        $(this).children('.user-check').removeClass('hide').addClass('show');
    });

    // topic-detail page
    $('.topic-hot-comment-list .comment').hover(function () {
        $(this).find('.comment-reportblock').removeClass('hide').addClass('show');
        $(this).find('.icon-delete-trigger').removeClass('hide').addClass('show');
    }, function () {
        $(this).find('.comment-reportblock').removeClass('show').addClass('hide');
        $(this).find('.icon-delete-trigger').removeClass('show').addClass('hide');
    });

    $('.topic-hot-comment-list .comment-operate .js-reply-trigger').on('click', function () {

        var currentReplyBox = $(this).parents('li.comment').find('.reply-send-box');

        if (currentReplyBox.hasClass('show')) {
            currentReplyBox.removeClass('show').addClass('hide');
        } else {
            $('.reply-send-box').each(function (i, n) {
                $(n).removeClass('show').addClass('hide');
            });

            currentReplyBox.removeClass('hide').addClass('show');
        }
    });

    $('.topic-hot-comment-list .comment-operate .js-like-trigger').on('click', function () {
        if (! $(this).hasClass('disabled')) {
            $(this).children('.icon-like').removeClass('native').addClass('liked');
            $(this).addClass('disabled');
        }
    });

    $('.remove-reply-modal .foot-row .gray-button').on('click', function () {
        $('.remove-reply-modal').removeClass('show').addClass('hide');
    });

    $('.remove-reply-modal .title-row .icon-close').on('click', function () {
        $('.remove-reply-modal').removeClass('show').addClass('hide');
    });

    $('.topic-comment-box .icon-delete-trigger').on('click', function () {
        $('.remove-reply-modal').removeClass('hide').addClass('show');
    });

});

function closeAllSelectFilter()
{
    $('.condition-filter .select-filter').each(function (i, n) {
        if (!$(n).next('.folder-item').is(':hidden')) {
            $(n).children('.border-r-bg').show();
            $(n).next('.folder-item').hide();
            $(n).removeClass('border-bot-click');
            //discoverSelectFilterHover($(this));
            $(n).bind('mouseover', function () {
                discoverSelectFilterHover($(this));
            });
            $(n).bind('mouseout', function () {
                discoverSelectFilterOut($(this));
            });
            $(n).parents('.filter-parent').removeClass('fold-item-actived');
        }
    });
}

function discoverSelectFilterHover(obj)
{
    obj.children('.select-bg-arrows').removeClass('up-arrows white-arrows down-arrows').addClass('white-arrows');
    obj.addClass('select-bor-bg-hover');
    obj.children('.border-r-bg').addClass('border-r-bg-hover');
}

function discoverSelectFilterOut(obj)
{
    obj.children('.select-bg-arrows').removeClass('up-arrows white-arrows down-arrows').addClass('down-arrows');
    obj.removeClass('select-bor-bg-hover');
    obj.children('.border-r-bg').removeClass('border-r-bg-hover');
}

function discoverSelectFilterClick(obj)
{
    obj.children('.select-bg-arrows').removeClass('up-arrows white-arrows down-arrows').addClass('up-arrows');
    obj.removeClass('select-bor-bg-hover');
    obj.children('.border-r-bg').removeClass('border-r-bg-hover');
}
