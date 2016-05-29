package cn.edu.hit.nongji.filter;

import cn.edu.hit.nongji.util.AuthTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author fangwentong
 * @title LoggerFilter
 * @desc 日志处理
 * @date 2016-04-11 17:26
 */

public class LoggerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);
    private String appName;

    public LoggerFilter() {
        this(null);
    }

    public LoggerFilter(String appName) {
        super();
        this.appName = appName;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 打印日志
        String addr = request.getRemoteAddr();
        String path = request.getRequestURI();
        String authToken = AuthTokenUtil.getAuthToken(request);
        String method = request.getMethod();
        logger.info("Request from {}, Method {}, URL: {}, AuthToken: {}", addr, method, path, authToken);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
