package cn.edu.hit.nongji.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangwentong
 * @title DriverLicence
 * @desc 驾照级别
 * @date 2016-04-28 18:46
 */

public enum DriverLicence {

    UNKOWN(0, "未知", "无效驾照, 留作默认值"),
    C3_OR_MORE(1, "C3以上的驾照", "低速载货汽车（原四轮农用运输车、轻型载货汽车，车长小于6m，总质量小于4500kg"),
    C4(2, "C4驾照", "三轮农用运输车"),
    G(3, "G驾照", "持证人可驾驶大中型拖拉机、拖拉机变型运输机和小型方向盘式拖拉机"),
    H(4, "H驾照", "持证人可驾驶小型方向盘式拖拉机"),
    K(5, "K驾照", "持证人可驾驶手扶式拖拉机"),
    R(6, "R驾照", "持证人可驾驶大中小型方向盘自走式联合收割机"),
    S(7, "S驾照", "持证人可驾驶悬挂式联合收割机"),
    T(8, "T驾照", "持证人可驾驶小型操纵杆自走式联合收割机");

    int code;
    String desc;
    String detail;
    static Map<Integer, DriverLicence> map = new HashMap<>();

    static {
        for (DriverLicence licence : values()) {
            map.put(licence.getCode(), licence);
        }
    }

    private DriverLicence(int code, String desc, String detail) {
        this.code = code;
        this.desc = desc;
        this.detail = detail;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDetail() {
        return this.detail;
    }

    public static DriverLicence fromCode(int code) {
        if (map.containsKey(code)) {
            return map.get(code);
        } else {
            return UNKOWN;
        }
    }
}
