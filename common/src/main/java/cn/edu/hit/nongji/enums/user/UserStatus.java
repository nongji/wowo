package cn.edu.hit.nongji.enums.user;


/**
 * @author fangwentong
 * @title UserStatus
 * @desc 用户状态
 * @date 2016-04-12 14:59
 */

public enum UserStatus {
    UNACTIVE(1, "未激活"), ACTIVE(2, "已激活"), LOCKED(3, "被锁定"), DELETED(4, "被删除");
    int status;
    String desc;

    private UserStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    /**
     * 默认用户状态
     *
     * @return 暂时返回已激活状态
     */
    public static UserStatus getDefaultStatus() {
        return ACTIVE;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }
}
