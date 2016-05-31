package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.po.AuditRecord;
import cn.edu.hit.nongji.service.AuditManagementService;

/**
 * @author fangwentong
 * @title AuditManagementServiceImpl
 * @desc 审核记录管理服务
 * @since 2016-05-30 23:23
 */

public class AuditManagementServiceImpl implements AuditManagementService {
    @Override
    public Long addNewAuditItem(AuditRecord auditRecord) {
        return null;
    }

    @Override
    public void setAuditStatusToSuccess(Long auditId) {

    }

    @Override
    public void setAuditStatus(Long auditId, Integer newStatus) {

    }
}
