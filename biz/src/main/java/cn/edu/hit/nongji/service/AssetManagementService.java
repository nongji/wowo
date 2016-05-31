package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.file.FilePath;

/**
 * @author fangwentong
 * @title AssetManagementService
 * @desc 资源管理服务
 * @since 2016-05-31 23:46
 */

public interface AssetManagementService {
    Long addNewAsset(FilePath path);
}
