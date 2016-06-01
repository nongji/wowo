package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.Asset;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author fangwentong
 * @title AssetDaoTest
 * @desc TODO
 * @since 2016-06-01 14:23
 */

public class AssetDaoTest extends DaoTestBase {
    @Autowired
    private AssetManagmentDao assetManagmentDao;

    @Test
    public void testAddAsset() {
        Asset asset1 = new Asset().setPath("sdsfdksafdsa.img").setBasePath("http://hi.com");
        Long assetId1 = assetManagmentDao.addNewAsset(asset1);
        assertNotNull(assetId1);
        assertTrue(assetId1 > 0);

        Asset asset2 = new Asset().setPath("sdsfdksafdsa.img").setBasePath("http://hi.com");
        assertNull(asset2.getId());
        Long assetId2 = assetManagmentDao.addNewAsset(asset2);
        assertNotNull(asset2.getId());
        assertNotNull(assetId2);
        assertTrue(asset2.getId() > asset1.getId());

        System.out.println("\n\n\n");
        System.out.printf("assetId1: %d, assetId2: %d\n", asset1.getId(), asset2.getId());
    }

    @Test
    public void testDeleteAsset() {

    }

    @Test
    public void testSelectAsset() {

    }
}
