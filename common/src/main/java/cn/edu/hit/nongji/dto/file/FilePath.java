package cn.edu.hit.nongji.dto.file;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title FilePath
 * @desc 文件路劲
 * @date 2016-05-05 19:46
 */

public class FilePath implements Serializable {
    String fullPath;
    String path;
    
    public String getFullPath() {
        return fullPath;
    }

    public FilePath setFullPath(String fullPath) {
        this.fullPath = fullPath;
        return this;
    }

    public String getPath() {
        return path;
    }

    public FilePath setPath(String path) {
        this.path = path;
        return this;
    }

}
