package cn.edu.hit.nongji.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author fangwentong
 * @title PasswordUtil
 * @desc 用 密码操作相关工具
 * @date 2016-04-07 17:51
 */

public class PasswordUtil {

    private static Logger logger = LoggerFactory.getLogger(PasswordUtil.class);


    public static String generatePasswrod(String plainText) {
        if (plainText == null) {
            throw new NullPointerException("plain text can not be null");
        }
        return md5Encrypt(plainText);
    }

    public static String md5Encrypt(String plainText) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] cipherData = md5.digest(plainText.getBytes());
            for (byte cipher : cipherData) {
                String toHexStr = Integer.toHexString(cipher & 0xff);
                builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("Can not find algorithm: md5, {}", e);
        }
        return builder.toString();
    }

}
