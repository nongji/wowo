package cn.edu.hit.nongji.util;

/**
 * @author fangwentong
 * @title UserNumberUtil
 * @desc UserNumer生成工具
 * @date 2016-04-12 15:13
 */

public class UserNumberUtil {

    /**
     * 获取UserNumber, 这里先用时间戳顶着
     * TODO: 完善UserNumber生成算法
     *
     * @return
     */
    public static long getUserNumber() {
        return System.currentTimeMillis();
    }
}
