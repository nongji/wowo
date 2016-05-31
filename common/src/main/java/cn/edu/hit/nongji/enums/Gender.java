package cn.edu.hit.nongji.enums;

/**
 * @author fangwentong
 * @title Gender
 * @desc 性别
 * @since 2016-05-31 15:02
 */

public enum Gender {
    UNKNOW(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女"),;

    int type;
    String desc;

    private Gender(int type, String desc) {
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
