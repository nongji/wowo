package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.dto.request.UpdateUserRequest;
import cn.edu.hit.nongji.enums.user.EmailVerifyStatus;
import cn.edu.hit.nongji.enums.user.MobileVerifyStatus;
import cn.edu.hit.nongji.enums.user.UserStatus;
import cn.edu.hit.nongji.po.User;

/**
 * @author fangwentong
 * @title UserService
 * @desc 用户服务接口
 * @date 2016-04-04 23:30
 */

public interface UserService {

    /**
     * 通过用户名和密码获取用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User getUserByUserNameAndPassword(String username, String password);


    /**
     * 根据用户名,手机号码或邮件地址获取用户
     *
     * @param username 用户名
     * @param mobile   手机号
     * @param email    邮箱地址
     * @return
     */
    User getUserByNameOrMobileOrEmail(String username, String mobile, String email);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return
     */
    User getUserByName(String username);

    /**
     * 根据手机号码获取用户
     *
     * @param mobile 手机号码
     * @return
     */
    User getUserByMobile(String mobile);

    /**
     * 根据手机号码获取用户
     *
     * @param email 电子邮箱
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 根据用户id获取用户身份.
     *
     * @param userId 用户id
     * @return
     */
    User getUserByUserId(long userId);

    /**
     * 添加用户
     *
     * @param newUserRequest 添加用户请求
     */
    void addUser(AddUserRequest newUserRequest);


    /**
     * 更新用户
     *
     * @param updateUserRequest
     */
    void updateUser(UpdateUserRequest updateUserRequest);

    /**
     * 更新用户密码
     *
     * @param userId      用户id
     * @param newPassword 新密码
     */
    void updatePassword(long userId, String newPassword);

    /**
     * 更新用户邮箱
     *
     * @param userId 用户id
     * @param email  新电子邮箱
     */
    void updateEmail(long userId, String email);

    /**
     * 更新用户邮箱验证状态
     *
     * @param userId       用户id
     * @param verifyStatus 用户邮箱验证状态
     */
    void updateEmailVerifyStatus(long userId, EmailVerifyStatus verifyStatus);

    /**
     * 更新用户手机信息
     *
     * @param userId      用户id
     * @param phoneNumber 用户新的手机号码
     */
    void updateMobile(long userId, String phoneNumber);

    /**
     * 更新用户手机验证状态
     *
     * @param userId       用户id
     * @param verifyStatus 用户手机验证状态
     */
    void updateMobileVerifyStatus(long userId, MobileVerifyStatus verifyStatus);

    /**
     * 更新用户状态
     *
     * @param userId 用户id
     * @param status 用户状态
     */
    void updateUserStatus(long userId, UserStatus status);

    /**
     * 更新用户域名
     *
     * @param userId 用户id
     * @param domain 域名
     */
    void updateUserDomain(long userId, String domain);
}
