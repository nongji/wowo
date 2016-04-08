package cn.edu.hit.nongji.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fangwentong
 * @title PasswordUtilTest
 * @desc  对明文密码进行转化的算法
 * @date 2016-04-07 18:53
 */

public class PasswordUtilTest {
    private static Logger logger = LoggerFactory.getLogger(PasswordUtilTest.class);

    @Test
    public void testGeneratePassword() {
        logger.info(PasswordUtil.generatePasswrod("longjames"));
        logger.info(PasswordUtil.generatePasswrod("fangwentong"));
        try {
            logger.info(PasswordUtil.md5Encrypt(null));
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
        try {
            logger.info(PasswordUtil.generatePasswrod(null));
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
    }
}
