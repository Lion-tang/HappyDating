/**
 * Created by konohanaruto on 2016/10/21.
 */

$(function(){
    var liObject = $('.small-image-list li');
    liObject.hover(
        function(){
            liObject.each(function(i,n){
                $(n).removeClass('hover-border');
            });
            if(!$(this).hasClass('selected-border')){
                $(this).addClass('hover-border');
            }
        },
        function(){
            liObject.each(function(i,n){
                $(n).removeClass('hover-border');
            });
        }
    );

    $('.close-x').on('click',function(){
        $('#layer').hide();
    });
});