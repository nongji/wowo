package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.enums.ResponseStatus;
import com.google.common.base.MoreObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fangwentong
 * @title AbstractCommonController
 * @date 2016-04-06 22:10
 */

public abstract class AbstractCommonController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据给定的响应状态和描述(可选)生成Response
     *
     * @param status ResponseStatus
     * @param s      description
     * @return Custom Response
     */
    private Response responseForResponseStatus(ResponseStatus status, String s) {
        String msg = MoreObjects.firstNonNull(s, status.getDesc());
        return new Response().setStatus(status.getStatus()).setMsg(msg);
    }

    Response successResponse() {
        return successResponse(null);
    }

    Response successResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.OK, msg);
    }

    Response invalidTokenResponse() {
        return invalidTokenResponse(null);
    }

    Response invalidTokenResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.INVALID_AUTHTOKEN, msg);
    }

    Response permissionDenyResponse() {
        return permissionDenyResponse(null);
    }

    Response permissionDenyResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.PERMISSION_DENYED, msg);
    }

    Response resourceNotFoundResponse() {
        return resourceNotFoundResponse(null);
    }

    Response resourceNotFoundResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.RESOURCE_NOT_FOUND, msg);
    }

    Response inputErrorResponse() {
        return inputErrorResponse(null);
    }

    Response inputErrorResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.INPUT_ERROR, msg);
    }

    Response internalServerError() {
        return internalServerError(null);
    }

    Response internalServerError(String msg) {
        return responseForResponseStatus(ResponseStatus.INTERNAL_SERVER_ERROR, msg);
    }
}
