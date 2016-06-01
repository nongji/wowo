package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.Asset;
import org.springframework.stereotype.Repository;

/**
 * @author fangwentong
 * @title AssetManagmentDao
 * @desc 资源文件管理数据访问对象
 * @since 2016-05-30 23:18
 */

@Repository
public interface AssetManagmentDao {
    /**
     * 添加新的姿态资源
     *
     * @param asset 静态资源描述
     * @return 影响行数, 成功插入返回1
     */
    Long addNewAsset(Asset asset);

    /**
     * 根据assetId获取静态资源详细描述
     *
     * @param assetId 静态资源id
     * @return 静态资源描述
     */
    Asset getAssetByAssetId(Long assetId);

    /**
     * 删除assetId对应的静态资源描述
     *
     * @param assetId 静态资源id
     * @return 影响行数
     */
    int deleteAssetByAssetId(Long assetId);

}
