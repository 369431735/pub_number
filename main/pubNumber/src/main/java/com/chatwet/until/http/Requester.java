package com.chatwet.until.http;
  
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Vector;

/** 
 * HTTP请求对象 
 *  
 * @author OUWCH 
 */  
@Component("Requester")
public class Requester {  
    private String defaultContentEncoding;  
    PrintWriter out = null; 
    public Requester() {  
        this.defaultContentEncoding = Charset.defaultCharset().name();  
    }  
   
    /** 
     * 发送GET请求 
     *  
     * @param urlString 
     *            URL地址 
     * @return 响应对象 
     * @throws IOException 
     */  
    public Respons sendGet(String urlString) throws IOException {  
        return this.send(urlString, "GET", null, null);  
    }  
   
    /** 
     * 发送GET请求 
     *  
     * @param urlString 
     *            URL地址 
     * @param params 
     *            参数集合 
     * @return 响应对象 
     * @throws IOException 
     */  
    public Respons sendGet(String urlString, Map<String, String> params)  
            throws IOException {  
        return this.send(urlString, "GET", params, null);  
    }  
   
    /** 
     * 发送GET请求 
     *  
     * @param urlString 
     *            URL地址 
     * @param params 
     *            参数集合 
     * @param propertys 
     *            请求属性 
     * @return 响应对象 
     * @throws IOException 
     */  
    public Respons sendGet(String urlString, Map<String, String> params,  
            Map<String, String> propertys) throws IOException {  
        return this.send(urlString, "GET", params, propertys);  
    }  
   
    /** 
     * 发送POST请求 
     *  
     * @param urlString 
     *            URL地址 
     * @return 响应对象 
     * @throws IOException 
     */  
    public Respons sendPost(String urlString) throws IOException {  
        return this.send(urlString, "POST", null, null);  
    }  
   
    /** 
     * 发送POST请求 
     *  
     * @param urlString 
     *            URL地址 
     * @param params 
     *            参数集合 
     * @return 响应对象 
     * @throws IOException 
     */  
    public Respons sendPost(String urlString, Map<String, String> params)  
            throws IOException {  
        return this.send(urlString, "POST", params, null);  
    }  
   
    /** 
     * 发送POST请求 
     *  
     * @param urlString 
     *            URL地址 
     * @param params 
     *            参数集合 
     * @param propertys 
     *            请求属性 
     * @return 响应对象 
     * @throws IOException 
     */  
    public Respons sendPost(String urlString, Map<String, String> params,  
            Map<String, String> propertys) throws IOException {  
        return this.send(urlString, "POST", params, propertys);  
    }  
   
    /** 
     * 发送HTTP请求 
     *  
     * @param urlString 
     * @return 响映对象 
     * @throws IOException 
     */  
    public Respons send(String urlString, String method,  
            Map<String, String> parameters, Map<String, String> propertys)  
            throws IOException {  
        HttpURLConnection urlConnection = null;  
   //get方式参数
        if (parameters != null) {  
            StringBuffer param = new StringBuffer();  
            int i = 0;  
            for (String key : parameters.keySet()) {  
                if (i == 0)  
                    param.append("?");  
                else  
                    param.append("&");  
                param.append(key).append("=").append(parameters.get(key));  
                i++;  
            }  
            urlString += param;  
        }  
        URL url = new URL(urlString);  
        urlConnection = (HttpURLConnection) url.openConnection();     
        urlConnection.setDoOutput(true);  
        urlConnection.setDoInput(true);  
        urlConnection.setUseCaches(false);  
   //post方式参数
      
   
        if (parameters != null) {  
            StringBuffer param = new StringBuffer();  
            for (String key : propertys.keySet()) {  
                param.append("&");  
                param.append(key).append("=").append(propertys.get(key));  
                // 获取HttpURLConnection对象对应的输出流  
                out = new PrintWriter(urlConnection.getOutputStream());  
                // 发送请求参数  
                out.write(param.substring(1, param.length()).toString());             
                // flush输出流的缓冲  
                out.flush();  
            }  
           
        
           
        }  
   
        return this.makeContent(urlString, urlConnection);  
    }  
   
    /** 
     * 得到响应对象 
     *  
     * @param urlConnection 
     * @return 响应对象 
     * @throws IOException 
     */  
    private Respons makeContent(String urlString,  
            HttpURLConnection urlConnection) throws IOException {  
        Respons httpResponser = new Respons();  
        try {  
            InputStream in = urlConnection.getInputStream();  
            BufferedReader bufferedReader = new BufferedReader(  
                    new InputStreamReader(in));  
            Vector<String> vec = new Vector<String>();  
            StringBuffer temp = new StringBuffer();  
            String line = bufferedReader.readLine();  
            while (line != null) {  
            	vec.add(line);  
                temp.append(line).append("\r\n");  
                line = bufferedReader.readLine();  
                httpResponser.setContentCollection(vec);
            }  
            bufferedReader.close();  
   
            String ecod = urlConnection.getContentEncoding();  
            if (ecod == null)  
                ecod = this.defaultContentEncoding;  
   
            httpResponser.setUrlString(urlString);
          
            httpResponser.setDefaultPort(urlConnection.getURL().getDefaultPort());  
            httpResponser.setFile(urlConnection.getURL().getFile());
            httpResponser.setHost(urlConnection.getURL().getHost()); 
            httpResponser.setPath(urlConnection.getURL().getPath());
            httpResponser.setPort(urlConnection.getURL().getPort());    
            httpResponser.setProtocol(urlConnection.getURL().getProtocol()); 
            httpResponser.setQuery(urlConnection.getURL().getQuery());
            httpResponser.setRef( urlConnection.getURL().getRef());  
            httpResponser.setUserInfo(urlConnection.getURL().getUserInfo());
   
            httpResponser.setContent(new String(temp.toString().getBytes(), ecod));   
            httpResponser.setContentEncoding(ecod);   
            httpResponser.setCode(urlConnection.getResponseCode());   
            httpResponser.setMessage(urlConnection.getResponseMessage());  
            httpResponser.setContentType(urlConnection.getContentType()); 
            httpResponser.setMethod(urlConnection.getRequestMethod());
            httpResponser.setConnectTimeout(urlConnection.getConnectTimeout());
            httpResponser.setReadTimeout(urlConnection.getReadTimeout());  
   
            return httpResponser;  
        } catch (IOException e) {  
            throw e;  
        } finally {  
            if (urlConnection != null)  
                urlConnection.disconnect();  
        }  
    }  
   
    /** 
     * 默认的响应字符集 
     */  
    public String getDefaultContentEncoding() {  
        return this.defaultContentEncoding;  
    }  
   
    /** 
     * 设置默认的响应字符集 
     */  
    public void setDefaultContentEncoding(String defaultContentEncoding) {  
        this.defaultContentEncoding = defaultContentEncoding;  
    }  
}  