package cn.edu.hit.nongji.util;

import org.junit.Test;

/**
 * @author fangwentong
 * @title FileUtilTest
 * @desc Tests for {@link FileUtil }
 * @since 2016-05-30 14:14
 */

public class FileUtilTest {
    @Test
    public void testGetFilename() {
        System.out.println(FileUtil.getRandomPah("txt"));
        System.out.println(FileUtil.getRandomPah("a.txt"));
        System.out.println(FileUtil.getRandomPah("HelloWorld.java"));
    }
}
