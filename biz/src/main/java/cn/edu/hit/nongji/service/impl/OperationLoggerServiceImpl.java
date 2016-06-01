package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dto.PageDto;
import cn.edu.hit.nongji.dto.user.OperationLogDto;
import cn.edu.hit.nongji.po.OperationLog;
import cn.edu.hit.nongji.service.OperationLoggerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fangwentong
 * @title OperationLoggerServiceImpl
 * @desc 用户操作记录服务
 * @since 2016-05-29 18:57
 */

@Service
public class OperationLoggerServiceImpl implements OperationLoggerService {

    private static final Logger logger = LoggerFactory.getLogger(OperationLoggerServiceImpl.class);
    /**
     * 添加新的操作记录
     *
     * @param operationLog 操作记录
     * @return 对应主键
     */
    @Override
    public Long addNewOperationLog(OperationLog operationLog) {
        return null;
    }

    /**
     * 根据用户Id和分页信息获取用户的操作记录
     *
     * @param userId  用户id
     * @param pageDto 分页信息
     * @return 满足要求的用户操作信息列表
     */
    @Override
    public List<OperationLogDto> getOprationHistoryByUserId(Long userId, PageDto pageDto) {
        return null;
    }
}
