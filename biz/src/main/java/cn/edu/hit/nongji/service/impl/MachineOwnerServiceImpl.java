package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.MachineOwnerDao;
import cn.edu.hit.nongji.dto.request.CompleteUserInfoRequest;
import cn.edu.hit.nongji.po.MachineOwner;
import cn.edu.hit.nongji.service.MachineOwnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fangwentong
 * @title MachineOwnerServiceImpl
 * @desc 农机主用管理服务
 * @since 2016-05-31 22:53
 */
@Service
public class MachineOwnerServiceImpl implements MachineOwnerService {

    @Autowired
    private MachineOwnerDao machineOwnerDao;

    private static final Logger logger = LoggerFactory.getLogger(MachineOwnerServiceImpl.class);

    @Override
    public Long completeUserInfo(CompleteUserInfoRequest completeUserInfoRequest) {
        MachineOwner owner = MachineOwner.fromCompleteUserInfoRequest(completeUserInfoRequest);
        machineOwnerDao.completeMachineOwnerInfo(owner);
        return owner.getId();
    }

    @Override
    public MachineOwner getMachineOwnerInfo(Long userId) {
        return machineOwnerDao.getMachineOwerByUserId(userId);
    }

}
