package cn.edu.hit.nongji.controller;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author fangwentong
 * @title ControllerTestBase
 * @desc 控制器测试基类
 * @date 2016-04-09 02:06
 */

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("classpath:ctx-test-controller.xml")
public class ControllerTestBase {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
