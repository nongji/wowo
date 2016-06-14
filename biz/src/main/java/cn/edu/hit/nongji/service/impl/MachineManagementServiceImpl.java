package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.MachineExtDao;
import cn.edu.hit.nongji.dao.MachineManagementDao;
import cn.edu.hit.nongji.dto.MachineDetail;
import cn.edu.hit.nongji.dto.MachineDto;
import cn.edu.hit.nongji.dto.request.MachineRegisterRequest;
import cn.edu.hit.nongji.po.Machine;
import cn.edu.hit.nongji.po.MachineExt;
import cn.edu.hit.nongji.service.AssetManagementService;
import cn.edu.hit.nongji.service.MachineManagementService;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author fangwentong
 * @title MachineManagementServiceImpl
 * @desc 农机管理服务
 * @since 2016-05-29 18:56
 */

@Service
public class MachineManagementServiceImpl implements MachineManagementService {

    @Autowired
    private MachineManagementDao machineManagementDao;
    @Autowired
    private MachineExtDao machineExtDao;

    @Autowired
    private AssetManagementService assetManagementService;

    private static final Logger logger = LoggerFactory.getLogger(MachineManagementServiceImpl.class);

    /**
     * 添加农机
     *
     * @param registerRequest 注册请求对象
     */
    @Override
    public long addNewMachine(MachineRegisterRequest registerRequest) {
        Machine machine = Machine.fromMachineRegisterRequest(registerRequest);
        machineManagementDao.addNewMachine(machine);
        return machine.getId();
    }

    @Override
    public void updateMachine(long machineId, MachineRegisterRequest registerRequest) {
        Machine machine  = Machine.fromMachineRegisterRequest(registerRequest);
        machine.setId(machineId);
        machineManagementDao.updateMachine(machine);

    }

    /**
     * 获取指定用户所有注册机器的信息
     *
     * @param userId 用户id
     * @return 指定用户所有注册机器信息
     */
    @Override
    public List<MachineDto> getRegisteredMachineByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            return Collections.emptyList();
        }
        List<Machine> machines = machineManagementDao.getRegisteredMachineByUserId(userId);
        List<MachineDto> result = Lists.newArrayListWithExpectedSize(machines.size());
        for (Machine machine : machines) {
            MachineDto machineDto = MachineDto.fromMachine(machine);
            machineDto.setDriverLicense(assetManagementService.getAssetByAssetId(machine.getDriverLicense()))
                    .setMachineLicense1(assetManagementService.getAssetByAssetId(machine.getMachineLicense1()))
                    .setMachineLicense2(assetManagementService.getAssetByAssetId(machine.getMachineLicense2()));
            result.add(machineDto);
        }
        return result;
    }

    /**
     * 获取指定机器id对应的机器详情
     *
     * @param machineId 机器id
     * @return machineId对应的机器的详细信息
     */
    @Override
    public MachineDetail getMachineDetailByMachineId(Long machineId) {
        if (machineId == null || machineId <= 0) {
            return null;
        }
        Machine machine = machineManagementDao.getMachineDetailByMachineId(machineId);
        MachineExt machineExt = machineExtDao.getMachineExtByMachineId(machineId);
        MachineDetail result = MachineDetail.fromMachineAnaMachineExt(machine, machineExt);
        result.setDriverLicense(assetManagementService.getAssetByAssetId(machine.getDriverLicense()))
                .setMachineLicense1(assetManagementService.getAssetByAssetId(machine.getMachineLicense1()))
                .setMachineLicense2(assetManagementService.getAssetByAssetId(machine.getMachineLicense2()));
        return result;
    }

    /**
     * 删除指定的machineId对应的机器
     *
     * @param machineId 机器id
     */
    @Override
    public void deleteMachineByMachineId(Long machineId) {
        machineManagementDao.deleteMachineByMachineId(machineId);
        machineExtDao.deleteMachineExtByMachineId(machineId);
    }

    /**
     * 删除指定用户的所有机器信息
     *
     * @param userId 用户id
     * @return 删除的机器数量
     */
    @Override
    public int deleteMachineByUserId(Long userId) {
        List<Long> machineIds = machineManagementDao.getMachineIdsByUserId(userId);
        if (CollectionUtils.isEmpty(machineIds)) {
            return 0;
        }
        int affectedRows = machineManagementDao.deleteMachineByUserId(userId);
        machineExtDao.deleteMachineExtByMachineIds(machineIds);
        return affectedRows;
    }

    /**
     * 判断指定农机是否属于指定用户
     *
     * @param userId    用户id
     * @param machineId 农机id
     * @return 如果指定机器属于指定用户, 则返回true, 否则返回false
     */
    @Override
    public boolean isOwnerOfMachine(Long userId, Long machineId) {
        Machine machine = machineManagementDao.getMachineByMachineIdAndUserId(userId, machineId);
        return machine != null;
    }
}
