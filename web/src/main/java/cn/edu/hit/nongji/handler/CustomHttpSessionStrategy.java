package cn.edu.hit.nongji.handler;


import cn.edu.hit.nongji.controller.AbstractCommonController;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.util.AuthTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.session.Session;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.util.Assert;

import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fangwentong
 * @title CustomHttpSessionStrategy
 * @date 2016-04-12 11:15
 */

public class CustomHttpSessionStrategy implements HttpSessionStrategy {


    private int sessionTimeoutSecond;

    private String headerName = "x-auth-token";
    private String queryStringKey = "authToken";
    private String cookieName = "AUTH_TOKEN";

    private static final Logger logger = LoggerFactory.getLogger(CustomHttpSessionStrategy.class);

    public CustomHttpSessionStrategy setSessionTimeoutSecond(int sessionTimeoutSecond) {
        this.sessionTimeoutSecond = sessionTimeoutSecond;
        return this;
    }

    public CustomHttpSessionStrategy setQueryStringKey(String queryStringKey) {
        this.queryStringKey = queryStringKey;
        return this;
    }

    public CustomHttpSessionStrategy setCookieName(String cookieName) {
        this.cookieName = cookieName;
        return this;
    }

    public CustomHttpSessionStrategy() {
    }

    public String getRequestedSessionId(HttpServletRequest request) {
        return AuthTokenUtil.getAuthToken(request);
    }

    /**
     * 新建Session时触发的动作: SessionID被记录到HTTP Response的中Header和Set-Cookie中
     *
     * @param session
     * @param request
     * @param response
     */
    public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {
        // 设置HTTP Header
        response.setHeader(this.headerName, session.getId());

        // 设置cookie
        Cookie cookie = new Cookie(this.cookieName, session.getId());
        cookie.setMaxAge(sessionTimeoutSecond);
        response.addCookie(cookie);
        logger.debug("new Session, cookie: {}: {}", cookie.getName(), cookie.getValue());
    }

    /**
     * 以特定格式返回对象, 目前只支持JSON
     *
     * @param servletResponse
     * @param response
     * @throws IOException
     */
    public static void writeResponse(ServletResponse servletResponse, Response response) throws IOException {
        servletResponse.setContentType("application/json; charset=utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        PrintWriter out = servletResponse.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        out.write(mapper.writeValueAsString(response));
    }

    public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader(this.headerName, "");
        logger.info("Invalid session: {}", request);
        try {
            writeResponse(response, AbstractCommonController.invalidTokenResponse());
        } catch (IOException e) {
            logger.error("Error while write response, {}", e);
        }
    }

    public void setHeaderName(String headerName) {
        Assert.notNull(headerName, "headerName cannot be null");
        this.headerName = headerName;
    }
}

