package cn.edu.hit.nongji.dto;

import cn.edu.hit.nongji.po.Machine;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title MachineDto
 * @desc 前端关心的农机详情信息
 * @since 2016-05-31 14:46
 */

public class MachineDto implements Serializable {

    Long id;
    @JsonProperty("user_type")
    Integer userType; // 用户类型
    @JsonProperty("drive_type")
    Integer driveType; // 驱动类型

    @JsonProperty("driver_name")
    String driverName; // 司机姓名
    @JsonProperty("driver_age")
    Integer driverAge;  // 司机年龄
    @JsonProperty("driver_gender")
    Integer driverGender; // 司机性别

    @JsonProperty("driver_license_type")
    String licenseType; //
    @JsonProperty("machine_type")
    String machineType; //  机器类型
    @JsonProperty("machine_name")
    String machineName; // 机器名称

    @JsonProperty("machine_powertype")
    Integer machinePowerType; // 动力类型
    @JsonProperty("machine_power")
    Integer machinePower; // 机器马力

    @JsonProperty("passenger_num")
    Integer passengerNum; // 最大乘客数量
    @JsonProperty("machine_wheeldistance")
    Integer wheelDistance; // 轮距
    @JsonProperty("machine_checktime")
    Integer checkTime; // 上次检查时间

    @JsonProperty("machine_paytype")
    Integer payType; // 支付方式
    @JsonProperty("lease_month")
    Integer leaseMonth; // 租赁月数
    @JsonProperty("lease_time")
    Integer leaseTime; // 租赁时间

    @JsonProperty("work_condition")
    String workCondition; // 工作环境

    @JsonProperty("need_type")
    Integer needType;
    @JsonProperty("with_item")
    Integer withItem;
    @JsonProperty("house_type")
    Integer houseType;


    @JsonProperty("driver_license")
    String driverLicense;
    @JsonProperty("machine_license1")
    String machineLicense1;
    @JsonProperty("machine_license2")
    String machineLicense2;

    public Long getId() {
        return id;
    }

    public MachineDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public MachineDto setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public Integer getDriveType() {
        return driveType;
    }

    public MachineDto setDriveType(Integer driveType) {
        this.driveType = driveType;
        return this;
    }

    public String getDriverName() {
        return driverName;
    }

    public MachineDto setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public MachineDto setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
        return this;
    }

    public Integer getDriverGender() {
        return driverGender;
    }

    public MachineDto setDriverGender(Integer driverGender) {
        this.driverGender = driverGender;
        return this;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public MachineDto setLicenseType(String licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    public String getMachineType() {
        return machineType;
    }

    public MachineDto setMachineType(String machineType) {
        this.machineType = machineType;
        return this;
    }

    public String getMachineName() {
        return machineName;
    }

    public MachineDto setMachineName(String machineName) {
        this.machineName = machineName;
        return this;
    }

    public Integer getMachinePowerType() {
        return machinePowerType;
    }

    public MachineDto setMachinePowerType(Integer machinePowerType) {
        this.machinePowerType = machinePowerType;
        return this;
    }

    public Integer getMachinePower() {
        return machinePower;
    }

    public MachineDto setMachinePower(Integer machinePower) {
        this.machinePower = machinePower;
        return this;
    }

    public Integer getPassengerNum() {
        return passengerNum;
    }

    public MachineDto setPassengerNum(Integer passengerNum) {
        this.passengerNum = passengerNum;
        return this;
    }

    public Integer getWheelDistance() {
        return wheelDistance;
    }

    public MachineDto setWheelDistance(Integer wheelDistance) {
        this.wheelDistance = wheelDistance;
        return this;
    }

    public Integer getCheckTime() {
        return checkTime;
    }

    public MachineDto setCheckTime(Integer checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public Integer getPayType() {
        return payType;
    }

    public MachineDto setPayType(Integer payType) {
        this.payType = payType;
        return this;
    }

    public Integer getLeaseMonth() {
        return leaseMonth;
    }

    public MachineDto setLeaseMonth(Integer leaseMonth) {
        this.leaseMonth = leaseMonth;
        return this;
    }

    public Integer getLeaseTime() {
        return leaseTime;
    }

    public MachineDto setLeaseTime(Integer leaseTime) {
        this.leaseTime = leaseTime;
        return this;
    }

    public String getWorkCondition() {
        return workCondition;
    }

    public MachineDto setWorkCondition(String workCondition) {
        this.workCondition = workCondition;
        return this;
    }

    public Integer getNeedType() {
        return needType;
    }

    public MachineDto setNeedType(Integer needType) {
        this.needType = needType;
        return this;
    }

    public Integer getWithItem() {
        return withItem;
    }

    public MachineDto setWithItem(Integer withItem) {
        this.withItem = withItem;
        return this;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public MachineDto setHouseType(Integer houseType) {
        this.houseType = houseType;
        return this;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public MachineDto setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
        return this;
    }

    public String getMachineLicense1() {
        return machineLicense1;
    }

    public MachineDto setMachineLicense1(String machineLicense1) {
        this.machineLicense1 = machineLicense1;
        return this;
    }

    public String getMachineLicense2() {
        return machineLicense2;
    }

    public MachineDto setMachineLicense2(String machineLicense2) {
        this.machineLicense2 = machineLicense2;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static MachineDto fromMachine(Machine machine) {
        MachineDto result = new MachineDto();

        result.setId(machine.getId())
                .setUserType(machine.getUserType())
                .setDriveType(machine.getDriveType())
                .setDriverName(machine.getDriverName())
                .setDriverAge(machine.getDriverAge())
                .setDriverGender(machine.getDriverGender())
                .setLicenseType(machine.getLicenseType())
                .setMachineType(machine.getMachineType())
                .setMachineName(machine.getMachineName())
                .setMachinePowerType(machine.getMachinePowerType())
                .setMachinePower(machine.getMachinePower())
                .setPassengerNum(machine.getPassengerNum())
                .setWheelDistance(machine.getWheelDistance().intValue())
                .setCheckTime(machine.getCheckTime())
                .setPayType(machine.getPayType())
                .setLeaseMonth(machine.getLeaseMonth())
                .setLeaseTime(machine.getLeaseTime().intValue())
                .setWorkCondition(machine.getWorkCondition())
                .setNeedType(machine.getNeedType())
                .setWithItem(machine.getWithItem())
                .setHouseType(machine.getHouseType())
        ;

        return result;
    }
}
