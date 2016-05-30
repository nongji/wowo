package cn.edu.hit.nongji.enums.user;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangwentong
 * @title UserType
 * @desc 用户类型
 * @since 2016-05-29 18:35
 */

public enum UserType {
    UNKONWN(-1, "未知"),
    NONGJI_USE(1, "农机用户"),
    MACHINE_OWNER(2, "农机主"),
    AUDIT_STAFF(11, "审核工作人员"),
    ADMIN(99, "管理员");

    int type;
    String desc;
    static Map<Integer, UserType> innerMap = new HashMap<>();

    static {
        for (UserType userType : values()) {
            innerMap.put(userType.getType(), userType);
        }
    }

    private UserType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public UserType formType(int type) {
        UserType result = innerMap.get(type);

        if (result == null) {
            result = UNKONWN;
        }
        return result;
    }
}
