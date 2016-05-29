package cn.edu.hit.nongji.dto.user;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title UserDetail
 * @desc 前端关心的用户自身详情
 * @date 2016-04-09 02:17
 */

public class UserDetail implements Serializable {
    String name;
    String phone;
    Long userId;
    Integer status;

    public String getName() {
        return name;
    }

    public UserDetail setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDetail setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserDetail setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserDetail setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
