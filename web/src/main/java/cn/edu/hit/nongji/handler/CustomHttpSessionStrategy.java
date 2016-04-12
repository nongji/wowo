package cn.edu.hit.nongji.handler;


import cn.edu.hit.nongji.controller.AbstractCommonController;
import cn.edu.hit.nongji.dto.response.Response;
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

    private static final Logger logger = LoggerFactory.getLogger(CustomHttpSessionStrategy.class);
    private String headerName = "x-auth-token";
    private String queryStringKey = "authToken";
    private String cookieName = "AUTH_TOKEN";

    public CustomHttpSessionStrategy() {
    }

    public String getRequestedSessionId(HttpServletRequest request) {
        String authToken = request.getHeader(headerName);
        if (authToken == null) {
            authToken = request.getParameter(queryStringKey);
        }
        if (authToken == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(cookieName)) {
                        authToken = cookies[i].getValue();
                        break;
                    }
                }
            }
        }
        logger.info("session id request! sessionId: {}, request {}", authToken, request);
        return authToken;
    }

    public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader(this.headerName, session.getId());
        Cookie cookie = new Cookie(this.cookieName, session.getId());
        response.addCookie(cookie);
        logger.info("new Session, cookie: {}", cookie);
    }

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

