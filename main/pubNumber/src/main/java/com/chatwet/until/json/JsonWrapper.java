package com.chatwet.until.json;

import com.chatwet.until.string.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixing on 2017/2/15.
 */
public class JsonWrapper {
    private static Logger loger = LoggerFactory.getLogger(JsonWrapper.class);

    private JsonWrapper() {
    }

    public static HashMap<String, Object> successWrapper(Object pojo) {
        HashMap wrapper = new HashMap();
        wrapper.put("success", Boolean.valueOf(true));
        wrapper.put("data", pojo);
        return wrapper;
    }

    public static HashMap<String, Object> failureWrapper(Object pojo) {
        HashMap wrapper = new HashMap();
        wrapper.put("success", Boolean.valueOf(false));
        wrapper.put("data", pojo);
        return wrapper;
    }

    public static HashMap<String, Object> failureWrapperMsg(String msg) {
        HashMap wrapper = new HashMap();
        wrapper.put("success", Boolean.valueOf(false));
        wrapper.put("msg", msg);
        return wrapper;
    }

    public static HashMap<String, Object> failureWrapper(Object... pojo) {
        return wrapper(false, pojo);
    }

    public static HashMap<String, Object> successWrapper(Object... pojo) {
        return wrapper(true, pojo);
    }

    public static HashMap<String, Object> wrapper(boolean success, Object... pojo) {
        HashMap wrapper = new HashMap();
        wrapper.put("success", Boolean.valueOf(success));
        int length = pojo.length;
        if(pojo.length % 2 == 1) {
            --length;
        }

        length /= 2;

        for(int i = 0; i < length; ++i) {
            wrapper.put(String.valueOf(pojo[i * 2]), pojo[i * 2 + 1]);
        }

        return wrapper;
    }

    public static HashMap<String, Object> wrapperMap(boolean success, Map<String, Object> map) {
        HashMap wrapper = new HashMap();
        wrapper.put("success", Boolean.valueOf(success));
        wrapper.put("data", map);
        return wrapper;
    }

    public static Map<String, Object> wrapperDataRows(List<Object> dataRows) {
        HashMap wrapper = new HashMap();
        wrapper.put("success", Boolean.valueOf(true));
        wrapper.put("Rows", dataRows);
        return wrapper;
    }

    public static String successJSONString() {
        return "{\"success\":true}";
    }

    public static String failureJSONString(String message) {
        return "{\"success\":false" + (StringUtil.isEmpty(message)?"}":",\"msg\":\"" + message + "\"}");
    }

    public static String toJsonString(Object jsonObj) throws Exception {
        try {
            ObjectMapper e = new ObjectMapper();
            e.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return e.writeValueAsString(jsonObj).toString();
        } catch (Exception var2) {
            loger.error("将对象序列化为JSON String时发送错误:" + var2.getMessage());
            throw new Exception("将对象序列化为JSON String时发送错误,无法转换.");
        }
    }
}
