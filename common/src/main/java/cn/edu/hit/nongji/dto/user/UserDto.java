package cn.edu.hit.nongji.dto.user;

/**
 * @author fangwentong
 * @title UserDto
 * @desc 用户公共信息
 * @date 2016-05-22 18:19
 */

public class UserDto {
    String phone;
    String name;
    String id;

    public String getPhone() {
        return phone;
    }

    public UserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserDto setId(String id) {
        this.id = id;
        return this;
    }
}
