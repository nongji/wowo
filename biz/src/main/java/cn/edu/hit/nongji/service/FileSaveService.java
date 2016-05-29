package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.file.FilePath;

import java.io.File;
import java.io.IOException;

/**
 * @author fangwentong
 * @title FileSaveService
 * @desc 文件保存接口
 * @date 2016-04-27 01:48
 */
public interface FileSaveService {
    FilePath save(File file, String targetPath) throws IOException;
}
