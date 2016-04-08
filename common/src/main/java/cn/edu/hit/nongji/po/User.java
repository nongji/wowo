package cn.edu.hit.nongji.po;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangwentong
 * @title User
 * @desc 用户
 * @date 2016-04-04 23:31
 */

public class User implements Serializable {
    private static final long serialVersionUID = 12221321421321L;

    private long id;
    private long number;
    private String name;
    private String mobile; // 手机
    private Integer mobileVerify; // 手机验证状态
    private String email;  // 电子邮箱
    private Integer emailVerify; // 电子邮箱验证状态
    private String loginPassword;  // 登陆密码
    private Integer status; // 用户状态
    private Date createAt; // 创建时间
    private Date updateAt; // 更新时间
    private String domain; // 个性域名;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public User setNumber(long number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Integer getMobileVerify() {
        return mobileVerify;
    }

    public User setMobileVerify(Integer mobileVerify) {
        this.mobileVerify = mobileVerify;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getEmailVerify() {
        return emailVerify;
    }

    public User setEmailVerify(Integer emailVerify) {
        this.emailVerify = emailVerify;
        return this;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public User setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public User setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public User setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public User setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
