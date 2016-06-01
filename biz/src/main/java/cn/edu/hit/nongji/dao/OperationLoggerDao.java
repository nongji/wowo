package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.OperationLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangwentong
 * @title OperationLoggerDao
 * @desc 用户操作纪录数据访问对象
 * @since 2016-05-29 18:32
 */

@Repository
public interface OperationLoggerDao {
    /**
     * 添加新的操作记录
     *
     * @param operationLog 操作记录
     * @return 影响行数
     */
    int addNewOperationLog(OperationLog operationLog);

    /**
     * 根据用户id获取用户操作记录
     *
     * @param userId 用户id
     * @return 用户操作记录
     */
    List<OperationLog> getOperationLogByUserId(long userId);

    /**
     * 根据用户id和操作类型获取操作记录
     *
     * @param userId 用户id
     * @param ops    操作类型列表
     * @return 用户操作记录
     */
    List<OperationLog> getOperationLogByUserIdAndOpTypes(long userId, List<Integer> ops);

    /**
     * 根据用户id删除用户所有操作记录
     *
     * @param userId 用户id
     * @return 影响行数
     */
    int deleteOperationLogByUserId(long userId);
}
