package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangwentong
 * @title Asset
 * @desc 资源文件
 * @since 2016-05-31 14:34
 */

public class Asset implements Serializable {

    Long id;
    String basePath; // 文件基础路径
    String path;
    Date createTime;

    public Long getId() {
        return id;
    }

    public Asset setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Asset setPath(String path) {
        this.path = path;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Asset setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getBasePath() {
        return basePath;
    }

    public Asset setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
