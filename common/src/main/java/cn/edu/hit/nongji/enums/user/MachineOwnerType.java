package cn.edu.hit.nongji.enums.user;

import java.util.HashMap;
import java.util.Map;


/**
 * @author fangwentong
 * @title MachineOwnerType
 * @desc 农机主 类型
 * @since 2016-05-30 15:33
 */


public enum MachineOwnerType {
    OTHER(0, "其他"),
    PERSONAL(1, "个人用户"),
    COMPANY(2, "公司"),
    COOPERATIVE(3, "合作社"),;

    int type;
    String desc;
    static Map<Integer, MachineOwnerType> machineOwnerTypeMap = new HashMap<>();

    static {
        for (MachineOwnerType machineOwnerType : values()) {
            machineOwnerTypeMap.put(machineOwnerType.getType(), machineOwnerType);
        }
    }

    private MachineOwnerType(int type, String desc) {
        this.desc = desc;
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public static MachineOwnerType fromType(int type) {
        MachineOwnerType result = machineOwnerTypeMap.get(type);
        if (result == null) {
            result = OTHER;
        }
        return result;
    }

}
