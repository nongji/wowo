package cn.edu.hit.nongji.enums;

/**
 * @author fangwentong
 * @title EmailVerifyStatus
 * @desc TODO
 * @date 2016-04-12 15:03
 */

public enum EmailVerifyStatus {
    NOT_VERIFY(1, "未验证"), VERIFIED(2, "已验证");
    int status;
    String desc;

    private EmailVerifyStatus(int status, String desc) {
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
