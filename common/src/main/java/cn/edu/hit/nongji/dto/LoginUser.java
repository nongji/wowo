package cn.edu.hit.nongji.dto;

/**
 * @author fangwentong
 * @title LoginUser
 * @date 2016-05-27 20:05
 */

public class LoginUser {
    String username;
    String userId;
    String userType;

    public String getUsername() {
        return username;
    }

    public LoginUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public LoginUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserType() {
        return userType;
    }

    public LoginUser setUserType(String userType) {
        this.userType = userType;
        return this;
    }
}
