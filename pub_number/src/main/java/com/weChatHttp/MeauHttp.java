package com.weChatHttp;

import com.chatwet.meau.bean.Button;
import com.chatwet.meau.bean.Matchrule;
import com.chatwet.until.http.Requester;
import com.chatwet.until.http.Respons;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixing on 2017/2/15.
 */
public class MeauHttp {
    @Autowired
    private static Requester httpRequester;
    public   Map<String, String> params=new HashMap<String, String>(); //get方式传递参数
    public   Map<String, String> propertys=new HashMap<String, String>(); //post方式传递参数

    /*****
     * 新增菜单
     * @param button 菜单对象
     * @return
     * @throws IOException
     */
    public JSONObject addGxhMeau(Button button) throws IOException{
        params.clear();
        propertys.clear();
        params.put("access_token",AccessToken.getAccess_token());
        JSONObject jo=JSONObject.fromObject(button);
        propertys.put("button",jo.toString());
        Respons hr=httpRequester.send(WetChatConfig.URL+"/cgi-bin/menu/create", WetChatConfig.POST, params, propertys);
        return JSONObject.fromObject(hr.getContent());
    }

    /*****
     * 新增个性化菜单 个性化菜单要求用户的微信客户端版本在iPhone6.2.2，Android 6.2.4以上。
     * @param button 菜单对象
     * @param matchrule
     * @return
     * @throws IOException
     */
    public JSONObject addGxhMeau(Button button, Matchrule matchrule) throws IOException{
        params.clear();
        propertys.clear();
        params.put("access_token",AccessToken.getAccess_token());
        JSONObject jo=JSONObject.fromObject(button);
        JSONObject jo1=JSONObject.fromObject(matchrule);
        propertys.put("button",jo.toString());
        propertys.put("matchrule",jo1.toString());
        Respons hr=httpRequester.send(WetChatConfig.URL+"/cgi-bin/menu/addconditional", WetChatConfig.POST, params, propertys);
        return JSONObject.fromObject(hr.getContent());
    }
    /****
     * 删除菜单;调用此接口会删除默认菜单及全部个性化菜单
     * @return
     * @throws IOException
     */
    public JSONObject delMeau() throws IOException{
        params.clear();
        propertys.clear();
        params.put("access_token",AccessToken.getAccess_token());
        Respons hr=httpRequester.send(WetChatConfig.URL+"/cgi-bin/menu/delete", WetChatConfig.GET, params, propertys);
        return JSONObject.fromObject(hr.getContent());
    }

    /****
     * 删除个性化菜单
     * @param menuid 新增菜单时，返回的值
     * @return
     * @throws IOException
     */
    public JSONObject delGxhMeau(String menuid) throws IOException{
        params.clear();
        propertys.clear();
        params.put("access_token",AccessToken.getAccess_token());
        propertys.put("menuid",menuid);
        Respons hr=httpRequester.send(WetChatConfig.URL+"/cgi-bin/menu/addconditional", WetChatConfig.POST, params, propertys);
        return JSONObject.fromObject(hr.getContent());

    }

    /*****
     *
     * @return
     * @throws IOException
     */
    public JSONObject findMeau()throws IOException{
        Map<String,Object> result=new HashMap<String,Object>();
        params.clear();
        propertys.clear();
        params.put("access_token",AccessToken.getAccess_token());
        Respons hr=httpRequester.send(WetChatConfig.URL+"/cgi-bin/menu/get", WetChatConfig.GET, params, propertys);
        return JSONObject.fromObject(hr.getContent());

    }

}
