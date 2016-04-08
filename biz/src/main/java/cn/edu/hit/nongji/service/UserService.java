package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.po.User;

/**
 * @author fangwentong
 * @title UserService
 * @date 2016-04-04 23:30
 */

public interface UserService {

    User getUserByUserNameAndPassword(String username, String password);

    void addUser(AddUserRequest newUserRequest);
}
