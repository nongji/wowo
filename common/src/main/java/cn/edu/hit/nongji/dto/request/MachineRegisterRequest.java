package cn.edu.hit.nongji.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;

/**
 * @author fangwentong
 * @title MachineRegisterRequest
 * @desc 农机登记接口
 * @since 2016-05-30 15:04
 */

public class MachineRegisterRequest extends AbstractRequest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @JsonProperty("user_id")
    Long userId;

    @JsonProperty("machine_id")
    Long machineId;

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
    Integer machinePowerType;
    @JsonProperty("machine_power")
    Integer machinePower; // 机器马力

    @JsonProperty("passenger_num")
    Integer passengerNum; // 最大乘客数量
    @JsonProperty("machine_wheeldistance")
    Double wheelDistance; // 轮距
    @JsonProperty("machine_checktime")
    Integer checkTime; // 上次检查时间

    @JsonProperty("machine_paytype")
    Integer payType; // 支付方式
    @JsonProperty("lease_month")
    Integer leaseMonth; // 租赁月数
    @JsonProperty("lease_time")
    Double leaseTime; // 租赁时间

    @JsonProperty("work_condition")
    String workCondition; // 工作环境

    @JsonProperty("need_type")
    Integer needType;
    @JsonProperty("with_item")
    Integer withItem;
    @JsonProperty("house_type")
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

    public Long getUserId() {
        return userId;
    }

    public MachineRegisterRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getUserType() {
        return userType;
    }

    public MachineRegisterRequest setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public Integer getDriveType() {
        return driveType;
    }

    public MachineRegisterRequest setDriveType(Integer driveType) {
        this.driveType = driveType;
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

    public String getLicenseType() {
        return licenseType;
    }

    public MachineRegisterRequest setLicenseType(String licenseType) {
        this.licenseType = licenseType;
        return this;
    }

    public String getMachineType() {
        return machineType;
    }

    public MachineRegisterRequest setMachineType(String machineType) {
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

    public Integer getMachinePowerType() {
        return machinePowerType;
    }

    public MachineRegisterRequest setMachinePowerType(Integer machinePowerType) {
        this.machinePowerType = machinePowerType;
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

    public Integer getCheckTime() {
        return checkTime;
    }

    public MachineRegisterRequest setCheckTime(Integer checkTime) {
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

    public String getWorkCondition() {
        return workCondition;
    }

    public MachineRegisterRequest setWorkCondition(String workCondition) {
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
