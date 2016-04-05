package cn.edu.hit.nongji.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fangwentong
 * @title ServiceTestBase
 * @date 2016-04-04 23:19
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ctx-test-service.xml")
public abstract class ServiceTestBase {
    protected Logger logger = LoggerFactory.getLogger(ServiceTestBase.class);
}
