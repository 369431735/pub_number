package com.chatwet.until.string;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by lixing on 2017/2/15.
 */
public class StringUtil {
    private static final Log log = LogFactory.getLog(StringUtil.class);

    public StringUtil() {
    }

    public static boolean isEmpty(String source) {
        return source == null || source.isEmpty();
    }

    public static boolean isNotEmpty(String source) {
        return !isEmpty(source);
    }

    public static String transformUtf8(String str) {
        if(isEmpty(str)) {
            return "";
        } else {
            try {
                String restr = new String(str.getBytes("ISO8859-1"), "utf-8");
                return restr;
            } catch (UnsupportedEncodingException var3) {
                log.error(var3.getMessage());
                return str;
            }
        }
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    public static String transformNull(String str) {
        return str == null?"":str;
    }


    public static Object parseOriginalType(String str) {
        return !"true".equals(str) && !"false".equals(str)?(isNumeric(str)?new BigDecimal(str):str):Boolean.valueOf(str);
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+|\\d+.\\d+");
    }
}
