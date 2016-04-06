package cn.edu.hit.nongji.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title PageDto
 * @desc 分页
 * @date 2016-04-06 12:56
 */

public class PageDto implements Serializable {
    private static final int DEF_PAGE_SIZE = 20;
    private static final int MAX_PAGE_SIZE = 100;
    private static final int DEF_PAGE_NUM = 1;

    private static final PageDto DEF_PAGE_DTO = new PageDto();

    public static final PageDto getDefPageDto() {
        try {
            return DEF_PAGE_DTO.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private Integer count;
    private Integer curPageCount;
    private Integer pageNum;
    private Integer pageSize;

    public PageDto() {
        this.count = 0;
        this.curPageCount = 0;
        this.pageNum = DEF_PAGE_NUM;
        this.pageSize = DEF_PAGE_SIZE;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if (count == null) {
            count = 0;
        }
        this.count = count;
    }

    public Integer getCurPageCount() {
        return curPageCount;
    }

    public void setCurPageCount(Integer curPageCount) {
        if (curPageCount == null) {
            curPageCount = 0;
        }
        this.curPageCount = curPageCount;
    }

    public Integer getPageNum() {
        if (pageNum == null || pageNum <= 0) {
            pageNum = DEF_PAGE_NUM;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = DEF_PAGE_NUM;
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEF_PAGE_SIZE;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            pageSize = DEF_PAGE_SIZE;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public void validate() {
        int pageNum = getPageNum();
        int pageSize = getPageSize();
        int count = getCount();
        // 无数据特殊处理
        if (count <= 0) {
            setPageNum(1);
            return;
        }

        // 当申请的页数大于总页数时，返回最后一页数据
        int lastPageNum = (count - 1) / pageSize + 1;
        if (lastPageNum > pageNum) {
            setCurPageCount(pageSize);
            return;
        }
        int lastPageSize = (count - 1) % pageSize + 1;
        setCurPageCount(lastPageSize);
        if (lastPageNum < pageNum) {
            setPageNum(lastPageNum);
            return;
        }
    }

    public int firstNum() {
        int pageNum = getPageNum();
        int pageSize = getPageSize();
        return (pageNum - 1) * pageSize;
    }

    public int lastNum() {
        int pageSize = getPageSize();
        int lastNum = firstNum() + pageSize;
        if (lastNum > getCount()) {
            return getCount();
        } else {
            return lastNum;
        }
    }

    @Override
    public String toString() {
        return "PageDto [count=" + count + ", curPageCount=" + curPageCount + ", pageNum=" + pageNum + ", pageSize="
                + pageSize + "]";
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    protected PageDto clone() throws CloneNotSupportedException {
        PageDto pageDto = new PageDto();
        pageDto.count = this.count;
        pageDto.pageNum = this.pageNum;
        pageDto.pageSize = this.pageSize;
        return pageDto;
    }
}
