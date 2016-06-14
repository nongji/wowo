package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.Machine;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangwentong
 * @title MachineManagementDao
 * @desc 农机数据访问对象
 * @since 2016-05-29 18:31
 */

@Repository
public interface MachineManagementDao {

    /**
     * 添加农机
     *
     * @param machine 新农机
     */
    void addNewMachine(Machine machine);

    /**
     * 获取指定用户所有注册机器的信息
     *
     * @param userId 用户id
     * @return 指定用户所有注册机器信息
     */
    List<Machine> getRegisteredMachineByUserId(Long userId);

    /**
     * 根据用户id获取其拥有的机器id列表
     *
     * @param userId 用户id
     * @return 用户拥有的机器id列表
     */
    List<Long> getMachineIdsByUserId(Long userId);

    /**
     * 获取指定机器id对应的机器信息
     *
     * @param machineId 机器id
     * @return machineId对应的机器的信息
     */
    Machine getMachineDetailByMachineId(Long machineId);

    /**
     * 删除指定的machineId对应的机器
     *
     * @param machineId 机器id
     * @return 删除行数
     */
    int deleteMachineByMachineId(Long machineId);

    /**
     * 删除指定用户的所有机器信息
     *
     * @param userId 用户id
     * @return 删除的机器数量
     */
    int deleteMachineByUserId(Long userId);

    /**
     * 根据农机id和用户id获取农机信息
     *
     * @param userId    用户id
     * @param machineId 农机id
     * @return 满足条件的农机信息
     */
    Machine getMachineByMachineIdAndUserId(Long userId, Long machineId);


    void updateMachine(Machine machine);
}
