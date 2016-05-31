package cn.edu.hit.nongji.dto.user;

import cn.edu.hit.nongji.enums.OperationType;
import cn.edu.hit.nongji.po.OperationLog;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author fangwentong
 * @title OperationLogDto
 * @desc 前端关心的用户操作
 * @since 2016-06-01 03:16
 */

public class OperationLogDto {
    private String action;
    private String timestamp;

    public String getAction() {
        return action;
    }

    public OperationLogDto setAction(String action) {
        this.action = action;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public OperationLogDto setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static OperationLogDto fromOperationLog(OperationLog operationLog) {
        OperationLogDto result = new OperationLogDto();

        StringBuilder action = new StringBuilder(),
                timestamp = new StringBuilder();
        action.append(OperationType.fromType(operationLog.getType()).getDesc());

        timestamp.append("(")
                .append(operationLog.getIpAddress())
                .append(") ")
                .append(DateFormatUtils.format(operationLog.getFinishedTime(), "yyyy-MM-dd HH:mm:ss"));

        result.setAction(action.toString())
                .setTimestamp(timestamp.toString());
        return result;
    }
}
