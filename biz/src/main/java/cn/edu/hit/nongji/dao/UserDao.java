package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.User;
import org.springframework.stereotype.Repository;

/**
 * @author fangwentong
 * @title UserDao
 * @desc TODO
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
     * 通过number获取用户
     *
     * @param number
     * @return
     */
    User getUserByNumber(long number);

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
     */
    void addUser(User user);
}
