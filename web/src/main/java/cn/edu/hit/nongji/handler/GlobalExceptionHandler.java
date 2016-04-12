package cn.edu.hit.nongji.handler;

import cn.edu.hit.nongji.controller.AbstractCommonController;
import cn.edu.hit.nongji.dto.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fangwentong
 * @title GlobalExceptionHandler
 * @desc 异常处理
 * @date 2016-04-11 20:45
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 通用异常处理, 仅打印错误日志
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public void handleException(HttpServletRequest req, Exception ex) {
        logger.error("Error occurred, {}", ex);
    }

    /**
     * 404 Handler, 返回JSON
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Response requestHandlingNoHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {
        return AbstractCommonController.resourceNotFoundResponse("oh, the resource you requested is not available now.");
    }

    /**
     * 客户端输入错误检查Hook, 返回json
     *
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class,
            MissingServletRequestParameterException.class})
    @ResponseBody
    public Response requestError(HttpServletRequest req, Exception ex) {
        return AbstractCommonController.inputErrorResponse("Data format error, please check it and retry.");
    }
}
