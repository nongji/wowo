package cn.edu.hit.nongji.po;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title MachineOwner
 * @desc 农机主信息
 * @since 2016-05-30 16:58
 */

public class MachineOwner implements Serializable {
    Long id;
    Long userId;  // 用户id
    Integer userType; // 用户类型
    String location; // 用户位置
    Double lng;  // 经度
    Double lat;  // 纬度

    Long idCard1;
    Long idCard2;
    Long certificate1;
    Long certificate2;

    public Long getId() {
        return id;
    }

    public MachineOwner setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public MachineOwner setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public MachineOwner setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public MachineOwner setLocation(String location) {
        this.location = location;
        return this;
    }

    public Double getLng() {
        return lng;
    }

    public MachineOwner setLng(Double lng) {
        this.lng = lng;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public MachineOwner setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Long getIdCard1() {
        return idCard1;
    }

    public MachineOwner setIdCard1(Long idCard1) {
        this.idCard1 = idCard1;
        return this;
    }

    public Long getIdCard2() {
        return idCard2;
    }

    public MachineOwner setIdCard2(Long idCard2) {
        this.idCard2 = idCard2;
        return this;
    }

    public Long getCertificate1() {
        return certificate1;
    }

    public MachineOwner setCertificate1(Long certificate1) {
        this.certificate1 = certificate1;
        return this;
    }

    public Long getCertificate2() {
        return certificate2;
    }

    public MachineOwner setCertificate2(Long certificate2) {
        this.certificate2 = certificate2;
        return this;
    }
}
