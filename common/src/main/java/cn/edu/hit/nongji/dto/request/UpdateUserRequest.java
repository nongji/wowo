package cn.edu.hit.nongji.dto.request;

/**
 * @author fangwentong
 * @title UpdateUserRequest
 * @desc 修改用户信息的请求
 * @date 2016-05-04 16:51
 */

public class UpdateUserRequest extends AbstractRequest {
    private Long userId; // 手机
    private String mobile; // 手机
    private String email;  // 电子邮箱
    private String password;  // 登陆密码
    private String domain; // 个性域名;

    public Long getUserId() {
        return userId;
    }

    public UpdateUserRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UpdateUserRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UpdateUserRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateUserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public UpdateUserRequest setDomain(String domain) {
        this.domain = domain;
        return this;
    }

}
