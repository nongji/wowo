package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.UserDao;
import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.dto.request.UpdateUserRequest;
import cn.edu.hit.nongji.enums.user.EmailVerifyStatus;
import cn.edu.hit.nongji.enums.user.MobileVerifyStatus;
import cn.edu.hit.nongji.enums.user.UserStatus;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.UserService;
import cn.edu.hit.nongji.util.PasswordUtil;
import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.StringUtils;
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
    public User getUserByNameOrMobileOrEmail(String username, String mobile, String email) {
        return userDao.getUserByNameOrMobileOrEmail(username, mobile, email);
    }

    @Override
    public User getUserByName(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return userDao.getUserByName(username);
    }

    @Override
    public User getUserByMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return null;
        }
        return userDao.getUserByMobile(mobile);
    }

    @Override
    public User getUserByEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return userDao.getUserByEmail(email);
    }

    /**
     * 根据用户id获取用户身份.
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public User getUserByUserId(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public void addUser(AddUserRequest request) {
        User user = new User().setName(request.getUsername())
                .setLoginPassword(PasswordUtil.generatePasswrod(request.getPassword()))
                .setMobile(MoreObjects.firstNonNull(request.getMobile(), ""))
                .setEmail(MoreObjects.firstNonNull(request.getEmail(), ""))
                .setStatus(UserStatus.getDefaultStatus().getStatus())
                .setDomain(MoreObjects.firstNonNull(request.getDomain(), ""));
        userDao.addUser(user);
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest) {
        User user = new User().setDomain(updateUserRequest.getDomain())
                .setMobile(updateUserRequest.getMobile())
                .setEmail(updateUserRequest.getEmail())
                .setLoginPassword(PasswordUtil.generatePasswrod(updateUserRequest.getPassword()));
        userDao.updateUser(user);
    }

    @Override
    public void updatePassword(long userId, String newPassword) {
        userDao.updateUser(new User().setId(userId)
                .setLoginPassword(PasswordUtil.generatePasswrod(newPassword)));
    }

    @Override
    public void updateEmail(long userId, String email) {
        userDao.updateUser(new User().setId(userId)
                .setEmail(email));
    }

    @Override
    public void updateEmailVerifyStatus(long userId, EmailVerifyStatus verifyStatus) {
        userDao.updateUser(new User().setId(userId)
                .setEmailVerify(verifyStatus.getStatus()));
    }

    @Override
    public void updateMobile(long userId, String phoneNumber) {
        userDao.updateUser(new User().setId(userId)
                .setMobile(phoneNumber));
    }

    @Override
    public void updateMobileVerifyStatus(long userId, MobileVerifyStatus verifyStatus) {
        userDao.updateUser(new User().setId(userId)
                .setMobileVerify(verifyStatus.getStatus()));

    }

    @Override
    public void updateUserStatus(long userId, UserStatus status) {
        userDao.updateUser(new User().setId(userId)
                .setStatus(status.getStatus()));

    }

    @Override
    public void updateUserDomain(long userId, String domain) {
        userDao.updateUser(new User().setId(userId)
                .setDomain(domain));
    }

}
