package cn.edu.hit.nongji.dto.response;

import cn.edu.hit.nongji.dto.user.UserDetail;

/**
 * @author fangwentong
 * @title LoginResultDto
 * @desc 登陆结果
 * @since 2016-05-31 15:16
 */

public class LoginResultDto extends UserDetail {
    public LoginResultDto() {
        super();
    }

    private String token;
    private Integer expiresIn;

    public String getToken() {
        return token;
    }

    public LoginResultDto setToken(String token) {
        this.token = token;
        return this;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public LoginResultDto setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
