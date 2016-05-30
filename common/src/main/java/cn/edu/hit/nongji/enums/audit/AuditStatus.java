package cn.edu.hit.nongji.enums.audit;

/**
 * @author fangwentong
 * @title AuditStatus
 * @desc 审核状态
 * @since 2016-05-30 17:23
 */

public enum AuditStatus {

    PENDING(0, "待审核"),

    PASS(1, "已通过"),

    REJECT(2, "已拒绝"),

    INIT(3, "待提交"),;

    int status;
    String desc;

    private AuditStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }

}
