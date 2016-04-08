package cn.edu.hit.nongji.enums;

/**
 * @author fangwentong
 * @title ResponseStatus
 * @desc 返回码定义
 * @date 2016-04-06 11:20
 */

public enum ResponseStatus {
    SYSTEM_BUSY(-1, "系统繁忙, 请稍后再试"),
    OK(0, "请求成功"),
    INVALID_AUTHTOKEN(40001, "无效的authToken"),
    PERMISSION_DENYED(40002, "没有权限"),
    RESOURCE_NOT_FOUND(40003, "资源不存在或已被移除"),
    INPUT_ERROR(40004, "用户输入有误"),

    INTERNAL_SERVER_ERROR(50001, "服务器内部错误"),;

    private int status;
    private String desc;

    private ResponseStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
