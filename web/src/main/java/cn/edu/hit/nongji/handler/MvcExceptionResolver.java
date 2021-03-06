package cn.edu.hit.nongji.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fangwentong
 * @title MvcExceptionResolver
 * @desc 自定义ExceptionResolver
 * @date 2016-04-11 20:23
 */

@Component
public class MvcExceptionResolver extends DefaultHandlerExceptionResolver {
    /**
     * 重写 404 处理逻辑
     *
     * @param ex
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws IOException
     */
    @Override
    protected ModelAndView handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                         HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        return new ModelAndView();
    }
}
