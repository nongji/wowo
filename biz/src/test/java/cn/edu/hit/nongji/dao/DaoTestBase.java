package cn.edu.hit.nongji.dao;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fangwentong
 * @title DaoTestBase
 * @date 2016-04-04 23:18
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ctx-test-dao.xml")
public abstract class DaoTestBase {
     protected Logger logger = LoggerFactory.getLogger(DaoTestBase.class);
}
