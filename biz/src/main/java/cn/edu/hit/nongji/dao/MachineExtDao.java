package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.MachineExt;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangwentong
 * @title MachineExtDao
 * @desc 农机扩展信息数据访问对象
 * @since 2016-06-01 20:46
 */

@Repository
public interface MachineExtDao {
    /**
     * 保存农机扩展信息
     *
     * @param machineExt 农机详情
     * @return 影响行数
     */
    int addNewMachineExt(MachineExt machineExt);

    /**
     * 根据农机id获取对应农机扩展信息
     *
     * @param machineId 农机id
     * @return 对应的农机扩展信息
     */
    MachineExt getMachineExtByMachineId(Long machineId);

    /**
     * 删除指定农机的农机详情
     *
     * @param machineId 农机id
     * @return 影响行数
     * @see #deleteMachineExtByMachineIds(List) 批量操作接口
     */
    int deleteMachineExtByMachineId(Long machineId);

    /**
     * 删除指定农机列表的农机详情, 为批量操作
     *
     * @param machineIds 农机id
     * @return 影响行数
     * @see #deleteMachineExtByMachineId(Long) 单条记录删除接口
     */
    int deleteMachineExtByMachineIds(List<Long> machineIds);
}
