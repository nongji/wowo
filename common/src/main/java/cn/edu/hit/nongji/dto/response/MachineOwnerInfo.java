package cn.edu.hit.nongji.dto.response;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title MachineOwnerInfo
 * @desc 前端关注的农机详情
 * @since 2016-06-02 16:00
 */

public class MachineOwnerInfo implements Serializable {
    Long userId;  // 用户id
    Integer userType; // 用户类型
    String location; // 用户位置
    Double lng;  // 经度
    Double lat;  // 纬度

    String idCard1;
    String idCard2;
    String certificate1;
    String certificate2;

    public Long getUserId() {
        return userId;
    }

    public MachineOwnerInfo setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public MachineOwnerInfo setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public MachineOwnerInfo setLocation(String location) {
        this.location = location;
        return this;
    }

    public Double getLng() {
        return lng;
    }

    public MachineOwnerInfo setLng(Double lng) {
        this.lng = lng;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public MachineOwnerInfo setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public String getIdCard1() {
        return idCard1;
    }

    public MachineOwnerInfo setIdCard1(String idCard1) {
        this.idCard1 = idCard1;
        return this;
    }

    public String getIdCard2() {
        return idCard2;
    }

    public MachineOwnerInfo setIdCard2(String idCard2) {
        this.idCard2 = idCard2;
        return this;
    }

    public String getCertificate1() {
        return certificate1;
    }

    public MachineOwnerInfo setCertificate1(String certificate1) {
        this.certificate1 = certificate1;
        return this;
    }

    public String getCertificate2() {
        return certificate2;
    }

    public MachineOwnerInfo setCertificate2(String certificate2) {
        this.certificate2 = certificate2;
        return this;
    }
}
