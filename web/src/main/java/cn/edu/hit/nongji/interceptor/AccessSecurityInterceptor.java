package cn.edu.hit.nongji.interceptor;

import cn.edu.hit.nongji.controller.AbstractCommonController;
import cn.edu.hit.nongji.handler.CustomHttpSessionStrategy;
import cn.edu.hit.nongji.util.AuthTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author fangwentong
 * @title AccessSecurityInterceptor
 * @desc 通用访问拦截器
 * @date 2016-04-12 13:22
 */

public class AccessSecurityInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccessSecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        String authToken = AuthTokenUtil.getAuthToken((HttpServletRequest) request);
        // block user not logged in
        if (authToken == null) {
            CustomHttpSessionStrategy.writeResponse(response, AbstractCommonController.inputErrorResponse("请提供 AuthToken."));
            return false;
        } else if (session == null) {
            logger.debug("Invalid AuthToken: {}.", authToken);
            CustomHttpSessionStrategy.writeResponse(response, AbstractCommonController.invalidTokenResponse());
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
