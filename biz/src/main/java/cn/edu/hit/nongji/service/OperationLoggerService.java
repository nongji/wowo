package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.PageDto;
import cn.edu.hit.nongji.dto.user.OperationLogDto;
import cn.edu.hit.nongji.po.OperationLog;

import java.util.List;

/**
 * @author fangwentong
 * @title OperationLoggerService
 * @desc 用户敏感操作记录服务接口
 * @since 2016-05-29 18:29
 */

public interface OperationLoggerService {

    /**
     * 添加新的操作记录
     *
     * @param operationLog 操作记录
     * @return 对应主键
     */
    Long addNewOperationLog(OperationLog operationLog);


    /**
     * 根据用户Id和分页信息获取用户的操作记录
     *
     * @param userId  用户id
     * @param pageDto 分页信息
     * @return 满足要求的用户操作信息列表
     */
    List<OperationLogDto> getOprationHistoryByUserId(Long userId, PageDto pageDto);

}
