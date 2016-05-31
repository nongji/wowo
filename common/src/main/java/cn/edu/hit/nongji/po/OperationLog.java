package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangwentong
 * @title OperationLog
 * @desc 用户操作纪录
 * @since 2016-05-30 16:50
 */

public class OperationLog implements Serializable {
    private Long id;
    private Long userId; // 操作发起人id
    private Integer type;  // 操作类型
    private Date finishedTime; // 操作结束时间
    private String ipAddress; // 操作者IP地址

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Long getId() {
        return id;
    }

    public OperationLog setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OperationLog setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public OperationLog setType(Integer type) {
        this.type = type;
        return this;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public OperationLog setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public OperationLog setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }
}
