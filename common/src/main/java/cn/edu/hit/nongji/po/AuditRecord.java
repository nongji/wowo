package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangwentong
 * @title AuditRecord
 * @desc 审核记录
 * @since 2016-05-30 16:57
 */

public class AuditRecord implements Serializable {

    private Long id;
    private Integer status;  // 审核状态
    private Integer refuseType; // 拒绝理由分类
    private String refuseReason; // 拒绝理由
    private Integer type; // 审核类型
    private Long relatedId; // 审核关联记录id

    private Date createTime; // 审核记录创建时间
    private Date updateTime; // 审核记录更新时间
    private Date finishedTime; // 审核完成时间

    public Long getId() {
        return id;
    }

    public AuditRecord setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public AuditRecord setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getRefuseType() {
        return refuseType;
    }

    public AuditRecord setRefuseType(Integer refuseType) {
        this.refuseType = refuseType;
        return this;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public AuditRecord setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public AuditRecord setType(Integer type) {
        this.type = type;
        return this;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public AuditRecord setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public AuditRecord setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public AuditRecord setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public AuditRecord setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
