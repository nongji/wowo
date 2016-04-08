package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author fangwentong
 * @title UserControllerTest
 * @date 2016-04-08 23:59
 */
public class UserControllerTest extends ControllerTestBase {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSignUp() {

    }

    @Test
    public void testGetUserByNameAndPasword() {
        
    }
}
