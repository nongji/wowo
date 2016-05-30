package cn.edu.hit.nongji.util;

import java.util.UUID;

/**
 * @author fangwentong
 * @title FileUtil
 * @desc 文件操作工具类
 * @since 2016-05-30 01:19
 */

public class FileUtil {
    private static final String AVATAR_PATH = "avatar";
    private static final String DRIVER_LISENCE = "lisence";
    private static final String MACHINE = "machine";
    private static final String ID_CARD = "idcard";
    private static final String RESOURCE = "";

    public static String getRandomPah(String filename) {
        boolean hasSuffix = filename.lastIndexOf(".") >= 0;
        String suffix = hasSuffix ? filename.substring(filename.lastIndexOf(".")) : "";

        return UUID.randomUUID().toString() + suffix;
    }

}
