package cn.edu.hit.nongji.dto;

/**
 * @author fangwentong
 * @title LoginUser
 * @date 2016-05-27 20:05
 */

public class LoginUser {
    String username;
    Long userId;
    Integer userType;

    public String getUsername() {
        return username;
    }

    public LoginUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public LoginUser setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public LoginUser setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }
}
