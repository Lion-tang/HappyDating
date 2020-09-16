/**
 * Created by konohanaruto on 2016/9/15.
 */

$(function(){

    $('#top-login .line-bar li').on('mouseover',function(){
        $(this).addClass('cursor');
    });

    $('#top-login .line-bar li').on('mouseout',function(){
        $(this).removeClass('cursor');
    });

    $('#top-login .line-bar li').on('click',function(){
        $('#top-login .line-bar li').each(function(i,n){
            $(n).removeClass('active');
        });

        var index = $(this).index() + 1;
        $(this).addClass('active');

        //content显示和隐藏
        $('#top-login .login-frame .content').each(function(i,n){
            $(n).hide();
        });
        //显示当前对应的content\
        $('#top-login .login-frame .content-' + index).show();
    });

    $('.clear-text').on('click',function(){
        $('.clear-text').parent().find("input[name='username']").val('');
    });

    $(window).scroll(function(){
        //滚动条距离文档顶部的高度
        var scrollTop = $(document).scrollTop();
        //文档高度
        //var docHeight = $(document).height();
        if(scrollTop > 500) {
            //显示底部固定定位导航
            $('#float-login').slideDown('slow');
        } else {
            //隐藏底部固定定位导航
            $('#float-login').slideUp('slow');
        }
    });


    $('#user-portrait .content').width(document.body.clientWidth);
    //中部小轮播
    $('#user-portrait .content .left-area').on('mouseover',function(){
        $('#user-portrait .content .left-area .fff-shadow').show();
    });
    $('#user-portrait .content .left-area').on('mouseout',function(){
        $('#user-portrait .content .left-area .fff-shadow').hide();
    });

    $('#user-portrait .content .right-area').on('mouseover',function(){
        $('#user-portrait .content .right-area .fff-shadow').show();
    });

    $('#user-portrait .content .right-area').on('mouseout',function(){
        $('#user-portrait .content .right-area .fff-shadow').hide();
    });
    //左边箭头事件
    $('#user-portrait .content .left-area').on('click',function(){
        var windowWidth = $('#user-portrait .content').width();
        var i = $('#user-portrait .content .left-area .arrows').data('index');
        var timer = setInterval(function(){
            var line = $('#user-portrait .content .line').offset();
            var step = (windowWidth-line.left)/100;
            var leftInit = line.left;
            var topInit = line.top;
            var left = line.left + step;
            if(i == 0 && left < 0){
                $('#user-portrait .content .line').offset({left:left,top:top});
            }
            /*
             else if(i == 1 && left > -2*windowWidth){
             $('#user-portrait .content .line').offset({left:left,top:top});
             }
             */
            else{
                $('#user-portrait .content .left-area').hide();
                $('#user-portrait .content .right-area').show();
                clearInterval(timer);
            }
        },10);
        //$('#user-portrait .content .right-area .arrows').data('index',i+1);
    });

    //右边箭头事件
    $('#user-portrait .content .right-area').on('click',function(){
        var windowWidth = $('#user-portrait .content').width();
        var i = $('#user-portrait .content .right-area .arrows').data('index');
        var timer = setInterval(function(){
            var line = $('#user-portrait .content .line').offset();
            var step = (windowWidth-line.left)/100;
            //console.log(step);
            var leftInit = line.left;
            var topInit = line.top;
            var left = line.left - step;
            if(i == 0 && left > -windowWidth){
                $('#user-portrait .content .line').offset({left:left,top:top});
            }
            /*
            else if(i == 1 && left > -2*windowWidth){
                $('#user-portrait .content .line').offset({left:left,top:top});
            }
            */
            else{
                $('#user-portrait .content .left-area').show();
                $('#user-portrait .content .right-area').hide();
                clearInterval(timer);
            }
        },10);
        //$('#user-portrait .content .right-area .arrows').data('index',i+1);
    });


});
