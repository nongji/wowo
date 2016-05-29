package cn.edu.hit.nongji.enums.machine;

/**
 * @author fangwentong
 * @title MachinePowerType
 * @desc 农机动力类型
 * @date 2016-04-28 19:09
 */

public enum MachinePowerType {
    DIESEL(1, "柴油"),
    GASOLINE(2, "汽油"),
    ELECTRIC(3, "电力"),
    MANPOWER(4, "人力"),;

    int type;
    String desc;

    private MachinePowerType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }
}
