package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.AssetManagmentDao;
import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.po.Asset;
import cn.edu.hit.nongji.service.AssetManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fangwentong
 * @title AssetManagementServiceImpl
 * @desc 资源管理服务
 * @since 2016-05-31 23:47
 */

@Service
public class AssetManagementServiceImpl implements AssetManagementService {
    @Autowired
    private AssetManagmentDao assetManagmentDao;
    private static final Logger logger = LoggerFactory.getLogger(AssetManagementServiceImpl.class);

    @Override
    public Long addNewAsset(FilePath path) {
        Asset asset = new Asset().setBasePath(path.getRootPath())
                .setPath(path.getRelativePath());
        if (assetManagmentDao.addNewAsset(asset) > 0) {
            return asset.getId();
        } else {
            return null;
        }
    }

    /**
     * 删除指定资源
     *
     * @param assetId 资源id
     */
    @Override
    public void deleteAssetByAssetId(Long assetId) {
        assetManagmentDao.deleteAssetByAssetId(assetId);
    }

    @Override
    public String getAssetByAssetId(Long assetId) {
        Asset asset = assetManagmentDao.getAssetByAssetId(assetId);
        if (asset == null) {
            return null;
        }
        return String.format("%s/%s", asset.getBasePath(), asset.getPath());
    }

}
