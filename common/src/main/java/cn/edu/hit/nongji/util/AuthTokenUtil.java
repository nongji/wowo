package cn.edu.hit.nongji.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author fangwentong
 * @title AuthTokenUtil
 * @desc AuthToken 工具类
 * @date 2016-04-12 10:54
 */

public class AuthTokenUtil {
    public static final String COOKIE_NAME = "AUTH_TOKEN";
    public static final String HEADER_NAME = "x-auth-token";
    public static final String QUERY_STRING_KEY = "authToken";

    public static boolean isValidAuthToken(String authToken) {
        return true;
    }

    public static String getAuthToken(HttpServletRequest request) {
        if (request.getHeader(HEADER_NAME) != null) {
            return request.getHeader(HEADER_NAME);
        } else if (request.getParameter(QUERY_STRING_KEY) != null) {
            return request.getParameter(QUERY_STRING_KEY);
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(COOKIE_NAME)) {
                        return cookies[i].getValue();
                    }
                }
            }

        }
        return null;
    }

}
