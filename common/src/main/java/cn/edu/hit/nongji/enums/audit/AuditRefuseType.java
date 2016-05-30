package cn.edu.hit.nongji.enums.audit;

/**
 * @author fangwentong
 * @title AuditRefuseType
 * @desc 审核拒绝理由
 * @since 2016-05-30 17:14
 */

public enum AuditRefuseType {
    UNKNOW(0, "未知"),

    INADEQUACY_WORD(1, "不适当或有攻击性的文字"),

    IMAGE_FUZZY(2, "图片模糊"),

    REQUIRED_FIELD_NOT_COMPLETED(3, "信息不全"),

    OTHER(99, "其他");

    int code;
    String desc;

    private AuditRefuseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getCode() {
        return this.code;
    }
}
