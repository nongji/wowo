package cn.edu.hit.nongji.po;

import cn.edu.hit.nongji.dto.request.MachineRegisterRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title Machine
 * @desc 农机信息
 * @since 2016-05-30 16:57
 */

public class Machine implements Serializable {

    Long id;
    Integer userType; // 用户类型
    Long userId;
    Integer driveType; // 驱动类型

    String driverName; // 司机姓名
    Integer driverAge;  // 司机年龄
    Integer driverGender; // 司机性别

    String licenseType; //
    String machineType; //  机器类型
    String machineName; // 机器名称
    Integer machinePowerType;
    Integer machinePower; // 机器马力

    Integer passengerNum; // 最大乘客数量
    Double wheelDistance; // 轮距
    Integer checkTime; // 上次检查时间

    Integer payType; // 支付方式
    Integer leaseMonth; // 租赁月数
    Double leaseTime; // 租赁时间

    String workCondition; // 工作环境

    Integer needType;
    Integer withItem;
    Integer houseType;


    Long driverLicense;
    Long machineLicense1;
    Long machineLicense2;

    public Long getId() {
        return id;
    }

    public Machine setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public Machine setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Machine setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getDriveType() {
        return driveType;
    }

    public Machine setDriveType(Integer driveType) {
        this.driveType = driveType;
        return this;
    }

    public String getDriverName() {
        return driverName;
    }

    public Machine setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public Machine setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
        return this;
    }

    public Integer getDriverGender() {
        return driverGender;
    }

    public Machine setDriverGender(Integer driverGender) {
        this.driverGender = driverGender;
        return this;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public Machine setLicenseType(String licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    public String getMachineType() {
        return machineType;
    }

    public Machine setMachineType(String machineType) {
        this.machineType = machineType;
        return this;
    }

    public String getMachineName() {
        return machineName;
    }

    public Machine setMachineName(String machineName) {
        this.machineName = machineName;
        return this;
    }

    public Integer getMachinePowerType() {
        return machinePowerType;
    }

    public Machine setMachinePowerType(Integer machinePowerType) {
        this.machinePowerType = machinePowerType;
        return this;
    }

    public Integer getMachinePower() {
        return machinePower;
    }

    public Machine setMachinePower(Integer machinePower) {
        this.machinePower = machinePower;
        return this;
    }

    public Integer getPassengerNum() {
        return passengerNum;
    }

    public Machine setPassengerNum(Integer passengerNum) {
        this.passengerNum = passengerNum;
        return this;
    }

    public Double getWheelDistance() {
        return wheelDistance;
    }

    public Machine setWheelDistance(Double wheelDistance) {
        this.wheelDistance = wheelDistance;
        return this;
    }

    public Integer getCheckTime() {
        return checkTime;
    }

    public Machine setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public Integer getPayType() {
        return payType;
    }

    public Machine setPayType(Integer payType) {
        this.payType = payType;
        return this;
    }

    public Integer getLeaseMonth() {
        return leaseMonth;
    }

    public Machine setLeaseMonth(Integer leaseMonth) {
        this.leaseMonth = leaseMonth;
        return this;
    }

    public Double getLeaseTime() {
        return leaseTime;
    }

    public Machine setLeaseTime(Double leaseTime) {
        this.leaseTime = leaseTime;
        return this;
    }

    public String getWorkCondition() {
        return workCondition;
    }

    public Machine setWorkCondition(String workCondition) {
        this.workCondition = workCondition;
        return this;
    }

    public Integer getNeedType() {
        return needType;
    }

    public Machine setNeedType(Integer needType) {
        this.needType = needType;
        return this;
    }

    public Integer getWithItem() {
        return withItem;
    }

    public Machine setWithItem(Integer withItem) {
        this.withItem = withItem;
        return this;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public Machine setHouseType(Integer houseType) {
        this.houseType = houseType;
        return this;
    }

    public Long getDriverLicense() {
        return driverLicense;
    }

    public Machine setDriverLicense(Long driverLicense) {
        this.driverLicense = driverLicense;
        return this;
    }

    public Long getMachineLicense1() {
        return machineLicense1;
    }

    public Machine setMachineLicense1(Long machineLicense1) {
        this.machineLicense1 = machineLicense1;
        return this;
    }

    public Long getMachineLicense2() {
        return machineLicense2;
    }

    public Machine setMachineLicense2(Long machineLicense2) {
        this.machineLicense2 = machineLicense2;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static Machine fromMachineRegisterRequest(MachineRegisterRequest request) {
        Machine result = new Machine();

        result.setUserId(request.getUserId())
                .setUserType(request.getUserType())
                .setDriveType(request.getDriveType())
                .setDriverName(request.getDriverName())
                .setDriverAge(request.getDriverAge())
                .setDriverGender(request.getDriverGender())
                .setLicenseType(request.getLicenseType())
                .setMachineType(request.getMachineType())
                .setMachineName(request.getMachineName())
                .setMachinePowerType(request.getMachinePowerType())
                .setMachinePower(request.getMachinePower())
                .setPassengerNum(request.getPassengerNum())
                .setWheelDistance(request.getWheelDistance())
                .setCheckTime(request.getCheckTime())
                .setPayType(request.getPayType())
                .setLeaseMonth(request.getLeaseMonth())
                .setLeaseTime(request.getLeaseTime())
                .setWorkCondition(request.getWorkCondition())
                .setNeedType(request.getNeedType())
                .setWithItem(request.getWithItem())
                .setHouseType(request.getHouseType())
                .setDriverLicense(request.getDriverLicense())
                .setMachineLicense1(request.getMachineLicense1())
                .setMachineLicense2(request.getMachineLicense2())
        ;

        return result;
    }
}
