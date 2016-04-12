package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.UserDao;
import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.enums.UserStatus;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.UserService;
import cn.edu.hit.nongji.util.PasswordUtil;
import cn.edu.hit.nongji.util.UserNumberUtil;
import com.google.common.base.MoreObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fangwentong
 * @title UserServiceImpl
 * @date 2016-04-04 23:30
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        String cipherPassword = PasswordUtil.generatePasswrod(password);
        return userDao.getUserByUserNameAndPassword(username, cipherPassword);
    }

    @Override
    public void addUser(AddUserRequest request) {
        User user = new User().setName(request.getUsername())
                .setNumber(UserNumberUtil.getUserNumber())
                .setLoginPassword(PasswordUtil.generatePasswrod(request.getPassword()))
                .setMobile(MoreObjects.firstNonNull(request.getMobile(), ""))
                .setEmail(MoreObjects.firstNonNull(request.getEmail(), ""))
                .setStatus(UserStatus.getDefaultStatus().getStatus())
                .setDomain(MoreObjects.firstNonNull(request.getDomain(), ""));
        userDao.addUser(user);
    }
}
