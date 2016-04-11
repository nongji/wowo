package cn.edu.hit.nongji.handler;

import cn.edu.hit.nongji.controller.AbstractCommonController;
import cn.edu.hit.nongji.dto.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
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

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(HttpServletRequest req, Exception ex) {
        logger.warn("Error occured, {}", ex);
        if (logger.isDebugEnabled()) {
            return AbstractCommonController.internalServerError("Returned by global exception handler." + ex.toString());
        } else {
            return AbstractCommonController.internalServerError();
        }
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public Response requestHandlingNoHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {
        return AbstractCommonController.resourceNotFoundResponse();
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, HttpMediaTypeNotSupportedException.class})
    @ResponseBody
    public Response requestError(HttpServletRequest req, Exception ex) {
        return AbstractCommonController.inputErrorResponse();
    }
}
