package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.request.CompleteUserInfoRequest;

/**
 * @author fangwentong
 * @title MachineOwnerService
 * @desc 农机主管理服务接口
 * @since 2016-05-31 22:48
 */

public interface MachineOwnerService {
    Long completeUserInfo(CompleteUserInfoRequest completeUserInfoRequest);

}
