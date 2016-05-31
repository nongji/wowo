package cn.edu.hit.nongji.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;
import java.util.Date;

/**
 * @author fangwentong
 * @title MachineRegisterRequest
 * @desc 农机登记接口
 * @since 2016-05-30 15:04
 */

public class MachineRegisterRequest extends AbstractRequest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    Integer userType; // 用户类型
    Integer driveTyep; // 驱动类型

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


    /**
     * 从JSON字符串中提取出农机登记信息
     *
     * @param jsonString
     * @return
     */
    public static MachineRegisterRequest fromJsonString(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, MachineRegisterRequest.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Integer getUserType() {
        return userType;
    }

    public MachineRegisterRequest setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public Integer getDriveTyep() {
        return driveTyep;
    }

    public MachineRegisterRequest setDriveTyep(Integer driveTyep) {
        this.driveTyep = driveTyep;
        return this;
    }

    public String getDriverName() {
        return driverName;
    }

    public MachineRegisterRequest setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public MachineRegisterRequest setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
        return this;
    }

    public Integer getDriverGender() {
        return driverGender;
    }

    public MachineRegisterRequest setDriverGender(Integer driverGender) {
        this.driverGender = driverGender;
        return this;
    }

    public Integer getLicenseType() {
        return licenseType;
    }

    public MachineRegisterRequest setLicenseType(Integer licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    public Integer getMachineType() {
        return machineType;
    }

    public MachineRegisterRequest setMachineType(Integer machineType) {
        this.machineType = machineType;
        return this;
    }

    public String getMachineName() {
        return machineName;
    }

    public MachineRegisterRequest setMachineName(String machineName) {
        this.machineName = machineName;
        return this;
    }

    public Integer getMachinePower() {
        return machinePower;
    }

    public MachineRegisterRequest setMachinePower(Integer machinePower) {
        this.machinePower = machinePower;
        return this;
    }

    public Integer getPassengerNum() {
        return passengerNum;
    }

    public MachineRegisterRequest setPassengerNum(Integer passengerNum) {
        this.passengerNum = passengerNum;
        return this;
    }

    public Double getWheelDistance() {
        return wheelDistance;
    }

    public MachineRegisterRequest setWheelDistance(Double wheelDistance) {
        this.wheelDistance = wheelDistance;
        return this;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public MachineRegisterRequest setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public Integer getPayType() {
        return payType;
    }

    public MachineRegisterRequest setPayType(Integer payType) {
        this.payType = payType;
        return this;
    }

    public Integer getLeaseMonth() {
        return leaseMonth;
    }

    public MachineRegisterRequest setLeaseMonth(Integer leaseMonth) {
        this.leaseMonth = leaseMonth;
        return this;
    }

    public Double getLeaseTime() {
        return leaseTime;
    }

    public MachineRegisterRequest setLeaseTime(Double leaseTime) {
        this.leaseTime = leaseTime;
        return this;
    }

    public Integer getWorkCondition() {
        return workCondition;
    }

    public MachineRegisterRequest setWorkCondition(Integer workCondition) {
        this.workCondition = workCondition;
        return this;
    }

    public Integer getNeedType() {
        return needType;
    }

    public MachineRegisterRequest setNeedType(Integer needType) {
        this.needType = needType;
        return this;
    }

    public Integer getWithItem() {
        return withItem;
    }

    public MachineRegisterRequest setWithItem(Integer withItem) {
        this.withItem = withItem;
        return this;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public MachineRegisterRequest setHouseType(Integer houseType) {
        this.houseType = houseType;
        return this;
    }

    public Long getDriverLicense() {
        return driverLicense;
    }

    public MachineRegisterRequest setDriverLicense(Long driverLicense) {
        this.driverLicense = driverLicense;
        return this;
    }

    public Long getMachineLicense1() {
        return machineLicense1;
    }

    public MachineRegisterRequest setMachineLicense1(Long machineLicense1) {
        this.machineLicense1 = machineLicense1;
        return this;
    }

    public Long getMachineLicense2() {
        return machineLicense2;
    }

    public MachineRegisterRequest setMachineLicense2(Long machineLicense2) {
        this.machineLicense2 = machineLicense2;
        return this;
    }
}
