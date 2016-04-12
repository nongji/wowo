package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dao.UserDao;
import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.impl.UserServiceImpl;
import cn.edu.hit.nongji.util.PasswordUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * @author fangwentong
 * @title UserServiceImplTest
 * @date 2016-04-07 13:45
 */

public class UserServiceImplTest extends ServiceTestBase {
    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserByUserNameAndPassword() {
        String username = "fangwentong";
        String password = "fangwentong";
        User me = new User().setId(1L).setName(username)
                .setLoginPassword(PasswordUtil.generatePasswrod(password));
        when(userDao.getUserByUserNameAndPassword(username, PasswordUtil.generatePasswrod(password)))
                .thenReturn(me);
        User user = userService.getUserByUserNameAndPassword(username, password);

        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(), username);
    }

    @Test
    public void testAddUser() {
        AddUserRequest request = new AddUserRequest().setUsername("fangwentong")
                .setPassword("123456")
                .setMobile("18011991234");

        userService.addUser(request);
    }

}
