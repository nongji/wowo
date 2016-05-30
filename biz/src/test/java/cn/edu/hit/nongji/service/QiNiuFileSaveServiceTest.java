package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.service.impl.QiNiuFileSaveServiceImpl;
import com.qiniu.common.QiniuException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @author fangwentong
 * @title QiNiuFileSaveServiceTest
 * @desc 七牛云文件存储服务 {@link QiNiuFileSaveServiceImpl } 测试
 * @date 2016-05-05 14:32
 */

public class QiNiuFileSaveServiceTest extends ServiceTestBase {
    @Autowired
    private QiNiuFileSaveServiceImpl qiNiuFileSaveService;

    @Test
    public void testAddNewFile() throws QiniuException {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File("src/test/java/cn/edu/hit/nongji/service/ServiceTestBase.java");
            qiNiuFileSaveService.save(file, "ServiceTestBase.java");
        } catch (QiniuException e) {
            logger.error(e.response.toString());
        }
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
