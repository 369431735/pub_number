package com.chatwet.meau.bean;

import com.chatwet.until.bean.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lixing on 2017/2/14.
 */
@Entity
public class Button implements BaseEntity {
    @Id
    @GeneratedValue
    private String id;
    private String type;//菜单响应类型 "view" or "click",
    private String name;//菜单名称
    private String key; // click等点击类型必须 菜单KEY值，用于消息接口推送，不超过128字节
    private String url ; //view类型必须 网页链接，用户点击菜单可打开链接，不超过1024字节
    private  String media_id;//media_id类型和view_limited类型必须 调用新增永久素材接口返回的合法media_id
    private String menuid; //

    public Button() {
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
}
