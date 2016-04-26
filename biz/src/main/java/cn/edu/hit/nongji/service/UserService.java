package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.po.User;

/**
 * @author fangwentong
 * @title UserService
 * @date 2016-04-04 23:30
 */

public interface UserService {

    /**
     * 通过用户名和密码获取用户信息
     *
     * @param username
     * @param password
     * @return
     */
    User getUserByUserNameAndPassword(String username, String password);

    /**
     * 添加用户
     *
     * @param newUserRequest
     */
    void addUser(AddUserRequest newUserRequest);

}
