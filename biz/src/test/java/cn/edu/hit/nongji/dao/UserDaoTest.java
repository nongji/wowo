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
            .setName("longJames2")
            .setMobile("12820001201")
            .setEmail("longjames@longjames.me")
            .setLoginPassword("hello")
            .setStatus(1);

    private long insertUser() {
        return userDao.addUser(longJames);
    }

    private void deleteUser() {
        userDao.deleteUserByName(longJames.getName());
    }
    @Test
    public void testGetUserById() {
        insertUser();
        long id = userDao.getUserByMobile(longJames.getMobile()).getId();
        User user = userDao.getUserById(id);
        Assert.assertNotNull(user);
        logger.info(user.toString());
        deleteUser();
        Assert.assertNull(userDao.getUserByMobile(longJames.getMobile()));
    }

    @Test
    public void testGetUserByName() {
        insertUser();
        User user = userDao.getUserByName(longJames.getName());
        Assert.assertNotNull(user);
        logger.info(user.toString());
        deleteUser();
    }

    @Test
    public void testGetUserByPhoneNumber() {
        insertUser();
        User user = userDao.getUserByMobile(longJames.getMobile());
        Assert.assertNotNull(user);
        logger.info(user.toString());
        deleteUser();
    }

    @Test
    public void testGetUserByEmail() {
        insertUser();
        User user = userDao.getUserByEmail(longJames.getEmail());
        Assert.assertNotNull(user);
        logger.info(user.toString());
        deleteUser();
    }

    @Test
    public void testGetUserByUserNameAndPassword() {
        insertUser();
        User user = userDao.getUserByUserNameAndPassword(longJames.getName(), longJames.getLoginPassword());
        Assert.assertNotNull(user);
        logger.info(user.toString());
        deleteUser();
    }

    @Test
    public void testGetUserByKeyUniqueValue() {
        insertUser();
        Assert.assertNotNull(userDao.getUserByKeyUniqueValue(longJames.getName()));
        Assert.assertNotNull(userDao.getUserByKeyUniqueValue(longJames.getMobile()));
        Assert.assertNotNull(userDao.getUserByKeyUniqueValue(longJames.getEmail()));
        deleteUser();
    }

    @Test
    public void testUpdateUser() {
        long id = insertUser();
        String newMobile = "18511991234";
        userDao.updateUser(new User().setId(id).setMobile(newMobile));
        Assert.assertNotNull(userDao.getUserByMobile(newMobile));
        logger.debug("\n\nUserId: {}\n\n", id);
        logger.debug(userDao.getUserByMobile(newMobile).toString());
        deleteUser();
    }
}
