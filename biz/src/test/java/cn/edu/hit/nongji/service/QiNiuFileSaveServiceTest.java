package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.service.impl.QiNiuFileSaveServiceImpl;
import com.qiniu.common.QiniuException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * @author fangwentong
 * @title QiNiuFileSaveServiceTest
 * @desc TODO
 * @date 2016-05-05 14:32
 */

@Ignore
public class QiNiuFileSaveServiceTest extends ServiceTestBase {
    @Autowired
    private QiNiuFileSaveServiceImpl qiNiuFileSaveService;

    @Test
    public void testAddNewFile() throws QiniuException {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File("/Users/tong/workspace/design/wowo/biz/src/test/java/cn/edu/hit/nongji/service/ServiceTestBase.java");
            qiNiuFileSaveService.save(file, "ServiceTestBase.java");
        } catch (QiniuException e) {
            System.out.println(e.response.toString());
        }
    }
}
