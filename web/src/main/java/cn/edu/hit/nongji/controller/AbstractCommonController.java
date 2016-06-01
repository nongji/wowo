package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.enums.ResponseStatus;
import cn.edu.hit.nongji.util.FileUtil;
import com.google.common.base.MoreObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
     * @param description      description
     * @return Custom Response
     */
    private static Response responseForResponseStatus(ResponseStatus status, String description) {
        String msg = MoreObjects.firstNonNull(description, status.getDesc());
        return new Response().setStatus(status.getStatus()).setMsg(msg);
    }

    public static Response successResponse() {
        return successResponse(null);
    }

    public static Response successResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.OK, msg);
    }

    public static Response invalidTokenResponse() {
        return invalidTokenResponse(null);
    }

    public static Response invalidTokenResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.INVALID_AUTHTOKEN, msg);
    }

    public static Response permissionDenyResponse() {
        return permissionDenyResponse(null);
    }

    public static Response permissionDenyResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.PERMISSION_DENYED, msg);
    }

    public static Response resourceNotFoundResponse() {
        return resourceNotFoundResponse(null);
    }

    public static Response resourceNotFoundResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.RESOURCE_NOT_FOUND, msg);
    }

    public static Response resourceAlreadyExistsResponse() {
        return resourceAlreadyExistsResponse(null);
    }

    public static Response resourceAlreadyExistsResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.RESOURCE_ALREADY_EXIST, msg);
    }

    public static Response inputErrorResponse() {
        return inputErrorResponse(null);
    }

    public static Response inputErrorResponse(String msg) {
        return responseForResponseStatus(ResponseStatus.INPUT_ERROR, msg);
    }

    public static Response internalServerError() {
        return internalServerError(null);
    }

    public static Response internalServerError(String msg) {
        return responseForResponseStatus(ResponseStatus.INTERNAL_SERVER_ERROR, msg);
    }

    public File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException {
        String filename = FileUtil.getRandomPah(multipartFile.getOriginalFilename());
        File tmpFile = new File(filename);

        if (tmpFile.exists()) {
            tmpFile.delete();
        }
        tmpFile.createNewFile();
        multipartFile.transferTo(tmpFile);
        return tmpFile;
    }

}
