package cn.edu.hit.nongji.dto;


import cn.edu.hit.nongji.po.Machine;
import cn.edu.hit.nongji.po.MachineExt;

import java.security.InvalidParameterException;

/**
 * @author fangwentong
 * @title MachineDetail
 * @desc 农机详情信息
 * @since 2016-05-31 22:36
 */

public class MachineDetail extends MachineDto {
    private String detail;

    public MachineDetail() {

    }

    public MachineDetail(MachineDto machineDto) {
        this.setId(machineDto.getId())
                .setUserType(machineDto.getUserType())
                .setDriveType(machineDto.getDriveType())
                .setDriverName(machineDto.getDriverName())
                .setDriverAge(machineDto.getDriverAge())
                .setDriverGender(machineDto.getDriverGender())
                .setLicenseType(machineDto.getLicenseType())
                .setMachineType(machineDto.getMachineType())
                .setMachineName(machineDto.getMachineName())
                .setMachinePowerType(machineDto.getMachinePowerType())
                .setMachinePower(machineDto.getMachinePower())
                .setPassengerNum(machineDto.getPassengerNum())
                .setWheelDistance(machineDto.getWheelDistance())
                .setCheckTime(machineDto.getCheckTime())
                .setPayType(machineDto.getPayType())
                .setLeaseMonth(machineDto.getLeaseMonth())
                .setLeaseTime(machineDto.getLeaseTime())
                .setWorkCondition(machineDto.getWorkCondition())
                .setNeedType(machineDto.getNeedType())
                .setWithItem(machineDto.getWithItem())
                .setHouseType(machineDto.getHouseType())
                .setDriverLicense(machineDto.getDriverLicense())
                .setMachineLicense1(machineDto.getMachineLicense1())
                .setMachineLicense2(machineDto.getMachineLicense2())
        ;
    }

    public String getDetail() {
        return detail;
    }

    public MachineDetail setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public static MachineDetail fromMachineAnaMachineExt(Machine machine, MachineExt machineExt) {
        MachineDetail result = new MachineDetail();

        if (machine != null && machineExt != null && machine.getId() != machineExt.getMachineId()) {
            throw new InvalidParameterException("Machine and machineExt are not match.");
        }
        if (machine != null) {
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
        }
        if (machineExt != null) {
            result.setDetail(machineExt.getDetail());
        }

        return result;
    }
}
