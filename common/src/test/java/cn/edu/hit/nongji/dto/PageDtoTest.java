package cn.edu.hit.nongji.dto;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fangwentong
 * @title PageDtoTest
 * @date 2016-04-07 02:10
 */

public class PageDtoTest {
    Logger logger = LoggerFactory.getLogger(PageDtoTest.class);

    @Test
    public void testDefaultPageDto() {
        Assert.assertTrue(new PageDto().equals(PageDto.getDefPageDto()));
    }

    @Test
    public void testGetAndSetPageSize() {
        int maxPageSize = PageDto.getMaxPageSize();
        PageDto testPage = new PageDto();

        int pageSize = maxPageSize + 1;
        testPage.setCount(pageSize);
        Assert.assertNotEquals(testPage.getPageSize(), (Integer) pageSize);

        pageSize = -1;
        testPage.setCount(pageSize);
        Assert.assertNotEquals(testPage.getPageSize(), (Integer) pageSize);
        Assert.assertEquals(testPage.getPageSize(), PageDto.getDefPageDto().getPageSize());

        pageSize = 10;
        Assert.assertTrue(pageSize < maxPageSize);
        testPage.setPageSize(pageSize);
        Assert.assertEquals(testPage.getPageSize(), (Integer) pageSize);
    }

    @Test
    public void testGetAndSetCount() {
        Assert.assertEquals(PageDto.getDefPageDto().getCount(), (Integer) 0);
        PageDto testPage = new PageDto();

        int count = -1;
        testPage.setCount(count);
        Assert.assertTrue(count < 0);
        Assert.assertTrue(testPage.getCount() == 0);

        count = 1000;
        testPage.setCount(count);
        Assert.assertTrue(count > 0);
        Assert.assertEquals(testPage.getCount(), (Integer) count);

    }

    @Test
    public void testValidate() {
        PageDto testPage = new PageDto();
        Integer pageNum = 10;
        Integer count = 998;
        Integer pageSize = 50;
        Integer pageCount = 100;

        Assert.assertTrue(pageSize <= PageDto.getMaxPageSize());
        testPage.setCount(count);
        testPage.setPageSize(pageSize);
        testPage.setCurPageCount(pageCount);
        testPage.setPageNum(pageNum);

        Assert.assertEquals(testPage.getCurPageCount(), pageCount);
        logger.info("Before validate: {}", testPage);
        testPage.validate();
        logger.info("After validate: {}", testPage);
        Assert.assertNotEquals(testPage.getCurPageCount(), pageCount);

        pageNum = 100;
        testPage.setPageNum(pageNum);

        Assert.assertEquals(testPage.getPageNum(), pageNum);
        testPage.validate();
        logger.info("Validate again: {}", testPage);
        Assert.assertNotEquals(testPage.getPageNum(), pageNum);
    }

}
