package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.User;
import org.springframework.stereotype.Repository;

/**
 * @author fangwentong
 * @title UserDao
 * @desc 用户信息数据访问对象
 * @date 2016-04-04 23:29
 */
@Repository
public interface UserDao {
    /**
     * 通过用户id获取用户
     *
     * @param id
     * @return
     */
    User getUserById(long id);

    /**
     * 通过用户名获取用户
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 通过电话号码查找用户
     *
     * @param mobile
     * @return
     */
    User getUserByMobile(String mobile);

    /**
     * 通过电子邮箱查找用户
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 通过用户名或者手机号码或者email查找用户, 用户登录或查找用户
     *
     * @param key 用户名/手机号码/email
     * @return
     */
    User getUserByKeyUniqueValue(String key);

    /**
     * 通过用户名或者手机号码或者email查找用户
     *
     * @param username 用户名
     * @param mobile   手机号码
     * @param email    电子邮箱
     * @return
     */
    User getUserByNameOrMobileOrEmail(String username, String mobile, String email);
    
    /**
     * 根据用户名密码查找用户
     *
     * @param username
     * @param password
     * @return
     */
    User getUserByUserNameAndPassword(String username, String password);

    /**
     * 新建指定用户
     *
     * @param user
     * @return id
     */
    long addUser(User user);

    /**
     * 根据用户名删除用户
     *
     * @param username
     */
    void deleteUserByName(String username);

    /**
     * 更新用户
     *
     * @param user 需要更新的用户信息, user.id 必须
     */
    void updateUser(User user);
}
