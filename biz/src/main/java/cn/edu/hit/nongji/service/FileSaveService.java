package cn.edu.hit.nongji.service;

import java.io.File;

/**
 * @author fangwentong
 * @title FileSaveService
 * @desc 文件保存接口
 * @date 2016-04-27 01:48
 */
public interface FileSaveService {
    String save(File file, String originFileName);
}
