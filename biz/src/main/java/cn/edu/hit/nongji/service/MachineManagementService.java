package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.MachineDetail;
import cn.edu.hit.nongji.dto.MachineDto;
import cn.edu.hit.nongji.dto.request.MachineRegisterRequest;

import java.util.List;

/**
 * @author fangwentong
 * @title MachineManagementService
 * @desc 农机管理服务接口
 * @since 2016-05-29 18:30
 */

public interface MachineManagementService {

    /**
     * 添加农机
     *
     * @param registerRequest 注册请求对象
     */
    long addNewMachine(MachineRegisterRequest registerRequest);

    /**
     * 获取指定用户所有注册机器的信息
     *
     * @param userId 用户id
     * @return 指定用户所有注册机器信息
     */
    List<MachineDto> getRegisteredMachineByUserId(Long userId);

    /**
     * 获取指定机器id对应的机器详情
     *
     * @param machineId 机器id
     * @return machineId对应的机器的详细信息
     */
    MachineDetail getMachineDetailByMachineId(Long machineId);

    /**
     * 删除指定的machineId对应的机器
     *
     * @param machineId 机器id
     */
    void deleteMachineByMachineId(Long machineId);

    /**
     * 删除指定用户的所有机器信息
     *
     * @param userId 用户id
     * @return 删除的机器数量
     */
    int deleteMachineByUserId(Long userId);

    /**
     * 判断指定农机是否属于指定用户
     *
     * @param userId    用户id
     * @param machineId 农机id
     * @return 如果指定机器属于指定用户, 则返回true, 否则返回false
     */
    boolean isOwnerOfMachine(Long userId, Long machineId);

}
