package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.po.AuditRecord;

/**
 * @author fangwentong
 * @title AuditManagementService
 * @desc 审核管理服务接口
 * @since 2016-05-30 23:22
 */

public interface AuditManagementService {

    Long addNewAuditItem(AuditRecord auditRecord);

    void setAuditStatusToSuccess(Long auditId);

    void setAuditStatus(Long auditId, Integer newStatus);
}
