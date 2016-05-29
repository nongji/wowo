package cn.edu.hit.nongji.dto.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author fangwentong
 * @title AddUserRequest
 * @date 2016-04-07 20:08
 */

public class AddUserRequest extends AbstractRequest {
    private static final long serialVersionUID = 12221321421321L;

    private String username;
    private String mobile; // 手机
    private String email;  // 电子邮箱
    private String password;  // 登陆密码
    private String domain; // 个性域名;


    public String getMobile() {
        return mobile;
    }

    public AddUserRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AddUserRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AddUserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AddUserRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public AddUserRequest setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
