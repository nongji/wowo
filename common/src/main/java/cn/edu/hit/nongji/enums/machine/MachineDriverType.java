package cn.edu.hit.nongji.enums.machine;

/**
 * @author fangwentong
 * @title MachineDriverType
 * @desc 农机驱动类型
 * @date 2016-04-28 19:06
 */

public enum MachineDriverType {
    FOUR_WHEEL(1, "四驱"),
    TWO_WHEEL(2, "两驱"),
    THREE_WHEEL(3, "三轮"),;

    int type;
    String desc;

    private MachineDriverType(int type, String desc) {
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
