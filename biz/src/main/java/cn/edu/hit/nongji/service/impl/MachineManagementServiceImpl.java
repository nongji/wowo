package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dto.MachineDetail;
import cn.edu.hit.nongji.dto.MachineDto;
import cn.edu.hit.nongji.dto.request.MachineRegisterRequest;
import cn.edu.hit.nongji.service.MachineManagementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangwentong
 * @title MachineManagementServiceImpl
 * @desc 农机管理服务
 * @since 2016-05-29 18:56
 */

@Service
public class MachineManagementServiceImpl implements MachineManagementService {
    /**
     * 添加农机
     *
     * @param registerRequest 注册请求对象
     */
    @Override
    public void addNewMachine(MachineRegisterRequest registerRequest) {

    }

    /**
     * 获取指定用户所有注册机器的信息
     *
     * @param userId 用户id
     * @return 指定用户所有注册机器信息
     */
    @Override
    public List<MachineDto> getRegisteredMachineByUserId(Long userId) {
        return null;
    }

    /**
     * 获取指定机器id对应的机器详情
     *
     * @param machineId 机器id
     * @return machineId对应的机器的详细信息
     */
    @Override
    public MachineDetail getMachineDetailByMachineId(Long machineId) {
        return null;
    }

    /**
     * 删除指定的machineId对应的机器
     *
     * @param machineId 机器id
     */
    @Override
    public void deleteMachineByMachineId(Long machineId) {

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
        return false;
    }
}
