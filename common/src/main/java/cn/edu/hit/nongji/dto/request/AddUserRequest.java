package cn.edu.hit.nongji.dto.request;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author fangwentong
 * @title AddUserRequest
 * @date 2016-04-07 20:08
 */

public class AddUserRequest extends AbstractRequest {
    private static final long serialVersionUID = 12221321421321L;

    private String name;
    private String mobile; // 手机
    private String email;  // 电子邮箱
    private String loginPassword;  // 登陆密码
    private String domain; // 个性域名;

    public String getName() {
        return name;
    }

    public AddUserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public AddUserRequest setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
    public String getEmail() {
        return email;
    }

    public AddUserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public AddUserRequest setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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
