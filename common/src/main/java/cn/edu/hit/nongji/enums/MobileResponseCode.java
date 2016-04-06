package cn.edu.hit.nongji.enums;

/**
 * @author fangwentong
 * @title MobileResponseStatus
 * @desc 返回码定义
 * @date 2016-04-06 11:20
 */

public enum MobileResponseCode {
    SYSTEM_BUSY(-1, "系统繁忙, 请稍后再试"),
    OK(0, "请求成功"),
    INVALID_AUTHTOKEN(40001, "无效的authToken"),
    PERMISSION_DENYED(40002, "没有权限"),
    RESOURCE_NOT_FOUND(40003, "资源不存在或已被移除"),
    INTERNAL_SERVER_ERROR(50001, "服务器内部错误"),

    ;

    private int code;
    private String desc;

    private MobileResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
