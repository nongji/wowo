package cn.edu.hit.nongji.dto.file;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title FilePath
 * @desc 文件路劲
 * @date 2016-05-05 19:46
 */

public class FilePath implements Serializable {
    String rootPath;
    String relativePath;

    public String getRootPath() {
        return rootPath;
    }

    public FilePath setRootPath(String rootPath) {
        this.rootPath = rootPath;
        return this;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public FilePath setRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getFullPath() {
        return String.format("%s/%s", rootPath, relativePath);
    }
}
