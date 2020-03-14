function lease(){
	var bar=aaa_div.eq(n)
        aaa.eq(n).css({'background':'#00bcd4','color':'white'})
    $(bar).animate({
        width: "100%",
    }, 2000, 'linear', function(){
        aaa.css({'background':'transparent','color':'black'})
        aaa_div.css('width','0%')
        n=(n+1)%6
        lease()
    });
}

var aaa=$('.aaa')

aaa.on('mouseover',function(){
    aaa_div.eq(n).stop()
}).on('mouseleave',function(){
    var bar=aaa_div.eq(n)
    var this_aaa=this
    $(bar).animate({
        width: "100%",
    }, (2000*($(this_aaa).css('width')-parseFloat(bar.css('width')))/100), 'linear', function(){
    	aaa.css({'background':'transparent','color':'black'})
        aaa_div.css('width','0%')
        n=(n+1)%6
        console.log(n)
        lease()
    });
})

var n=0;
var W=$('.aaa').css('width');
var aaa_div=$('.aaa').children('div');

lease()