package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fangwentong
 * @title UserDaoTest
 * @date 2016-04-06 19:17
 */

public class UserDaoTest extends DaoTestBase {
    @Autowired
    private UserDao userDao;

    private User longJames = new User()
            .setId(0).setNumber(800000L)
            .setName("longJames2")
            .setMobile("12820001201")
            .setEmail("longjames@longjames.me")
            .setLoginPassword("hello")
            .setStatus(1);

    private void insertUser() {
        userDao.addUser(longJames);
    }

    @Test
    public void testGetUserById() {
        insertUser();
        long id = userDao.getUserByNumber(longJames.getNumber()).getId();
        User user = userDao.getUserById(id);
        Assert.assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testGetUserByNumber() {
        insertUser();
        User user = userDao.getUserByNumber(longJames.getNumber());
        Assert.assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testGetUserByName() {
        insertUser();
        User user = userDao.getUserByName(longJames.getName());
        Assert.assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testGetUserByPhoneNumber() {
        insertUser();
        User user = userDao.getUserByMobile(longJames.getMobile());
        Assert.assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testGetUserByEmail() {
        insertUser();
        User user = userDao.getUserByEmail(longJames.getEmail());
        Assert.assertNotNull(user);
        logger.info(user.toString());
    }

    @Test
    public void testGetUserByUserNameAndPassword() {
        insertUser();
        User user = userDao.getUserByUserNameAndPassword(longJames.getName(), longJames.getLoginPassword());
        Assert.assertNotNull(user);
        logger.info(user.toString());
    }
}
