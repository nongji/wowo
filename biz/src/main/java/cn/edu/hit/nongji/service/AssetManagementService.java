package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.file.FilePath;

/**
 * @author fangwentong
 * @title AssetManagementService
 * @desc 资源管理服务
 * @since 2016-05-31 23:46
 */

public interface AssetManagementService {

    /**
     * 保存指定路径信息, 并返回资源id
     *
     * @param path 路径信息
     * @return 资源id
     */
    Long addNewAsset(FilePath path);


    /**
     * 删除指定资源
     *
     * @param assetId 资源id
     */
    void deleteAssetByAssetId(Long assetId);


    /**
     * 根据资源id获取资源路径
     *
     * @param assetId 资源id
     * @return 资源路径信息
     */
    String getAssetByAssetId(Long assetId);

}
