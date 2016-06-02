package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.MachineOwner;
import org.springframework.stereotype.Repository;

/**
 * @author fangwentong
 * @title MachineOwnerDao
 * @desc 农机主用户信息 数据访问对象
 * @since 2016-05-30 23:07
 */

@Repository
public interface MachineOwnerDao {
    int completeMachineOwnerInfo(MachineOwner machineOwner);

    MachineOwner getMachineOwerByUserId(Long userId);
}
