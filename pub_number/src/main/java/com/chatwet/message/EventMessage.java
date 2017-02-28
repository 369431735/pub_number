package com.chatwet.message;

/**
 * Created by lixing on 2017/2/15.
 */
public class EventMessage {
    private  String    ToUserName;       //	开发者微信号
    private  String    FromUserName;     //	发送方帐号（一个OpenID）
    private  String    CreateTime;       //	消息创建时间 （整型）
    private  String    MsgType;         //	消息类型，event
    private  String    Event;           //	事件类型，subscribe:订阅、扫描带参数二维码事件（未关注）
                                       // unsubscribe:取消订阅 CLICK：自定义菜单事件
                                       //SCAN:扫描带参数二维码事件(已关注) VIEW：点击菜单跳转链接时的事件推送
                                       //LOCATION：上报地理位置
    private  String    EventKey;	      //事件KEY值，qrscene_为前缀，后面为二维码的参数值；事件KEY值，与自定义菜单接口中KEY值对应
                                          //事件KEY值，设置的跳转URL
    private  String    Ticket;          //二维码的ticket，可用来换取二维码图片
    private  String Latitude;	      //	地理位置纬度
    private  String Longitude;	      //	地理位置经度
    private  String  Precision;	      //	地理位置精度
}
