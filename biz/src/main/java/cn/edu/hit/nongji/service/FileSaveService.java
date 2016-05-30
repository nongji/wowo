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
    /**
     * 保存文件到指定位置
     *
     * @param file         源文件
     * @param relativePath 目标地址
     * @return 最终保存到的路径
     * @throws IOException If relativePath is exsit, throw {@link org.apache.commons.io.FileExistsException }
     */
    FilePath save(File file, String relativePath) throws IOException;

    /**
     * 删除指定路径的文件或目录
     *
     * @param relativePath 待删除文件的相对路劲
     * @return 删除结果, 文件存在且成功删除返回true, 否则返回false
     * @throws IOException
     */
    boolean delete(String relativePath) throws IOException;

    /**
     * 判断指定路径是否存在
     *
     * @param relativePath 待判断的路径
     * @return 如果存在返回true, 不存在返回false
     */
    boolean isExists(String relativePath) throws IOException;
}
