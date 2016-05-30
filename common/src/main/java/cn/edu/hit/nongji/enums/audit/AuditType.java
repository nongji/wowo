package cn.edu.hit.nongji.enums.audit;

/**
 * @author fangwentong
 * @title AuditType
 * @desc 审核类型
 * @since 2016-05-30 17:35
 */

public enum AuditType {
    UNKOWN(0, "未知"),
    
    MACHINE(1, "农机审核"),

    IDENTITY(2, "用户身份审核"),

    DRIVER_LICENSE(3, "驾驶证审核"),

    VEHICLE_LICENSE(4, "行驶证审核"),;

    private int type;
    private String desc;

    private AuditType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getType() {
        return this.type;
    }
}
