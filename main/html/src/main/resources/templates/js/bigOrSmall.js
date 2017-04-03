/**
 * Created by UI2 on 2016/6/5.
 */
/*自动缩放*/
function zoomInOut(contentid) {
//            document.all[contentid].style.zoom = parseInt(document.all[contentid].style.zoom) - zoomRate + '%'
    var s = document.body.clientWidth;
    var size = parseFloat(s) / 320 * 100;
    //alert(size);
    document.all[contentid].style.zoom = size + '%'
}

/*去掉小数点后面的0*/
function priceForRMB(price) {
    if (price == "" || price == null || price == undefined) {
        return '¥' + 0.00;
    }
    return '¥' + parseFloat(price).toFixed(2);
    //return price - iPrice > 0f ?
    //    String.format("￥%,.2f", price)
    //    : String.format("￥%,.0f", price);
}
/*按钮的颜色*/
function btnBlue(id, type) {
    if (type == 0) {
        document.getElementById(id).disabled = 0;
        document.getElementById(id).style.background = '#46b8da';
    }
    if (type == 1) {
        document.getElementById(id).disabled = 1;
        document.getElementById(id).style.background = 'rgba(77,77,77,0.5)';
    }
    /*验证码按钮*/
    if (type == 2) {
        document.getElementById(id).disabled = 0;
        document.getElementById(id).style.background = 'rgb(255, 186, 51)';
    }
}

/*网络图片的地址*/
function imgUrl(imgUrl) {
    var pic = imgUrl;
    if (pic.indexOf(";") > -1) {
        var pics = "";
        if (pic != null && pic.length > 0) {
            pics = pic.split(";");
            pic = pics[0];
        }
    }
    pic = pic.replace(";", "");
    var url = 'http://datousuan.com.cn:9898/product/' + pic;
    return url;
}