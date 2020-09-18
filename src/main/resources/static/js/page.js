$(function(){

    var curpage=1;//当前页码

    var maxpage = 5;//最大页码



    if(maxpage > 1)

        $("#nextpage").addClass("active");



    $("#rowsToshow").change(function(){

        console.log($("#rowsToshow").val());

    })

    $("#prepage").live("click",function(){

        curpage = curpage - 1;

        pageshow(curpage,maxpage);

    })

    $("#nextpage").live("click",function(){

        curpage = curpage + 1;

        pageshow(curpage,maxpage);

    })

    $("#pagecontrol li a").live("click",function(){

        curpage = Number($(this).text());

        pageshow(curpage,maxpage);

    })

})



function pageshow(cp,tp){



    var sp = cp - 2;//startpage

    var ep = cp + 2;//endpage

    var eoff = ep - tp;//tp:totalpage

    if(eoff>0){

        sp = sp - eoff;

    }

    if(sp<=0){

        ep = ep -sp + 1;

    }

    var str = '';

    if(cp != 1)

        str = str + '<ul><li><span id="prepage" class="active">上一页</span></li>'

    else

        str = str + '<ul><li><span id="prepage">上一页</span></li>'

    for(var i= sp;i<=ep;i++){

        if(i>0&& i<=tp){

            if(i == cp)

                str = str + '<li class="num current"><a>'+i+'</a></li>';

            else

                str = str + '<li class="num"><a>'+i+'</a></li>';

        }

    }



    if(cp != tp)

        str = str + '<li><span class="active" id="nextpage">下一页<span></li></ul>';

    else

        str = str + '<li><span id="nextpage">下一页<span></li></ul>';

    $("#pagecontrol").html(str);

}