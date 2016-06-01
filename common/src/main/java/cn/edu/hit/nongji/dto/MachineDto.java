package cn.edu.hit.nongji.dto;

import cn.edu.hit.nongji.po.Machine;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangwentong
 * @title MachineDto
 * @desc 前端关心的农机详情信息
 * @since 2016-05-31 14:46
 */

public class MachineDto implements Serializable {
    Long id;
    Integer userType; // 用户类型
    Integer driveType; // 驱动类型

    String driverName; // 司机姓名
    Integer driverAge;  // 司机年龄
    Integer driverGender; // 司机性别

    Integer licenseType; //
    Integer machineType; //  机器类型
    String machineName; // 机器名称
    Integer machinePower; // 机器马力

    Integer passengerNum; // 最大乘客数量
    Double wheelDistance; // 轮距
    Date checkTime; // 上次检查时间

    Integer payType; // 支付方式
    Integer leaseMonth; // 租赁月数
    Double leaseTime; // 租赁时间

    Integer workCondition; // 工作环境

    Integer needType;
    Integer withItem;
    Integer houseType;


    Long driverLicense;
    Long machineLicense1;
    Long machineLicense2;

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

    public Integer getLicenseType() {
        return licenseType;
    }

    public MachineDto setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    public Integer getMachineType() {
        return machineType;
    }

    public MachineDto setMachineType(Integer machineType) {
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

    public Double getWheelDistance() {
        return wheelDistance;
    }

    public MachineDto setWheelDistance(Double wheelDistance) {
        this.wheelDistance = wheelDistance;
        return this;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public MachineDto setCheckTime(Date checkTime) {
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

    public Double getLeaseTime() {
        return leaseTime;
    }

    public MachineDto setLeaseTime(Double leaseTime) {
        this.leaseTime = leaseTime;
        return this;
    }

    public Integer getWorkCondition() {
        return workCondition;
    }

    public MachineDto setWorkCondition(Integer workCondition) {
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

    public Long getDriverLicense() {
        return driverLicense;
    }

    public MachineDto setDriverLicense(Long driverLicense) {
        this.driverLicense = driverLicense;
        return this;
    }

    public Long getMachineLicense1() {
        return machineLicense1;
    }

    public MachineDto setMachineLicense1(Long machineLicense1) {
        this.machineLicense1 = machineLicense1;
        return this;
    }

    public Long getMachineLicense2() {
        return machineLicense2;
    }

    public MachineDto setMachineLicense2(Long machineLicense2) {
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
                .setMachinePower(machine.getMachinePower())
                .setPassengerNum(machine.getPassengerNum())
                .setWheelDistance(machine.getWheelDistance())
                .setCheckTime(machine.getCheckTime())
                .setPayType(machine.getPayType())
                .setLeaseMonth(machine.getLeaseMonth())
                .setLeaseTime(machine.getLeaseTime())
                .setWorkCondition(machine.getWorkCondition())
                .setNeedType(machine.getNeedType())
                .setWithItem(machine.getWithItem())
                .setHouseType(machine.getHouseType())
                .setDriverLicense(machine.getDriverLicense())
                .setMachineLicense1(machine.getMachineLicense1())
                .setMachineLicense2(machine.getMachineLicense2())
        ;

        return result;
    }
}
