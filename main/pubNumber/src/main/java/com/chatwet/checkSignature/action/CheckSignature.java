package com.chatwet.checkSignature.action;

import com.chatwet.checkSignature.until.Sha1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by lixing on 2017/2/13.
 */
@RestController
public class CheckSignature {

    @Value("${token}")
    private String token;

    @RequestMapping(value = "")
    @ResponseBody
    public Object checkSignature(HttpServletRequest request, HttpServletResponse response) {
      String method=request.getMethod();
        //确认请求来自微信服务器   get方式请求
      if("get".equalsIgnoreCase(method)){
          String signature=request.getParameter("signature");
          String timestamp=request.getParameter("timestamp");
          String nonce=request.getParameter("nonce");
          String echostr=request.getParameter("echostr");
        String[] str = new String[]{token, timestamp, nonce};
        Arrays.sort(str);
        StringBuffer strb = new StringBuffer(str[0] + str[1] + str[2]);
        String sha1 = Sha1.getSha1(strb.toString());
        if (sha1.equals(signature)) {
            return echostr;
        } else {
            return "false";
        }
    }
    //处理微信服务器发来的消息  post方式请求
    else{}
        return null;
    }
}
