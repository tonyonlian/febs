package cn.tongyl.febs.common.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author create by Tunyl on 2021/8/15
 * @version 1.0
 */
public class FebsUtil {

    public static void makeResponse(HttpServletResponse response,String contentType, int status, Object value) throws IOException {
        response.setContentType(contentType);
        response.setStatus(status);
        response.getOutputStream().write(JSONObject.toJSONString(value).getBytes());
    }
}
