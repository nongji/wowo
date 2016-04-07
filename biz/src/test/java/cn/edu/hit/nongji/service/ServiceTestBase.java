package cn.edu.hit.nongji.service;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fangwentong
 * @title ServiceTestBase
 * @date 2016-04-04 23:19
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("classpath:ctx-test-service.xml")
public abstract class ServiceTestBase {
    protected Logger logger = LoggerFactory.getLogger(ServiceTestBase.class);
}
