package cn.edu.hit.nongji.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangwentong
 * @title OperationType
 * @desc 操作类型
 * @since 2016-05-29 23:35
 */

public enum OperationType {
    UNKNOWN(0, "未知", "unknown"),
    USER_LOGIN_SUCCESS(1, "用户登录", "user.login"),
    USER_FAIL_LOGIN(2, "登录失败", "user.fail_login"),
    USER_SIGNUP(3, "用户注册", "user.signup"),
    USER_UPDATE(4, "用户更新", "user.update"),
    USER_DELETE(5, "删除用户", "user.delete"),;

    int type;
    String descChs;  // 中文描述
    String desc; // 英文描述

    static Map<Integer, OperationType> oprationTypeMap = new HashMap<>();

    static {
        for (OperationType operationType : values()) {
            oprationTypeMap.put(operationType.getType(), operationType);
        }
    }

    private OperationType(int type, String descChs, String desc) {
        this.type = type;
        this.descChs = descChs;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public String getDescChs() {
        return this.descChs;
    }

    public String getDesc() {
        return this.desc;
    }

    public OperationType fromType(int type) {
        OperationType result = oprationTypeMap.get(type);

        if (result == null) {
            result = UNKNOWN;
        }
        return result;

    }
}
