package com.weChatHttp;

import com.chatwet.until.http.Requester;
import com.chatwet.until.http.Respons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixing on 2017/2/14.
 */
@Component("accessToken")
public class AccessToken {
    private final String grant_type="client_credential";
    @Value("${appid}")
    private static String appid;
    @Value("${appsecret}")
    private static String secret;
    private static String access_token;//获取到的凭证
    private static String expires_in;//凭证有效时间，单位：秒
    private static String errcode;//错误编码
    private static String errmsg;//错误原因
    @Autowired
    private static Requester httpRequester;
    public  static Map<String, String> params=new HashMap<String, String>(); //get方式传递参数
    public  static Map<String, String> propertys=new HashMap<String, String>(); //post方式传递参数

    public static void findAccessTokenByWeb(){
try{
    if(params.size()==0){
        params.put("grant_type","client_credential");
        params.put("appid",appid);
        params.put("secret",secret);
    }
        Respons hr=httpRequester.send(WetChatConfig.URL+"/cgi-bin/token", WetChatConfig.GET, params, propertys);
        JSONObject jsonObject=JSONObject.fromObject(hr.getContent());
        access_token=(String)jsonObject.get("access_token");
        expires_in=(String)jsonObject.get("expires_in");
}
    catch (IOException e){

    }
    }
    public static String getAccess_token(){
        return access_token;
    }

}

