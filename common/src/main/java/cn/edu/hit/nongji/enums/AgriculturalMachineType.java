package cn.edu.hit.nongji.enums;

/**
 * @author fangwentong
 * @title AgriculturalMachineType
 * @desc 农机类型
 * @date 2016-04-28 18:56
 */

public enum AgriculturalMachineType {
    POWER_MECHINE(1, "动力机械"),
    PLANTING(2, "种植施肥"),
//
//    (3,"耕整地"),
//
//    MANAGEMENT(4,"田间管理"),
//
//    INVEST(5,"收获机械"),
//
//    (6,"收货后处理"),
//
//    PROCESSING(7,"农产品加工"),
//
//    IRRIGATE(8,"排灌"),
//
//    (9,"畜牧水产养殖"),
//            (10,"农机配套与配件"),
//            (11,"农田基本建设"),
//            (12,"设施农业设备"),
//            (13,"农业运输"),
//            (14,"其他机械")
    ;

    int type;
    String desc;

    private AgriculturalMachineType(int type, String desc) {
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
