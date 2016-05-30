package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.service.FileSaveService;
import com.google.common.io.Files;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author fangwentong
 * @title DiskFileSaveServiceImpl
 * @desc 文件本地磁盘存储服务
 * @date 2016-04-27 01:52
 */

@Service
public class DiskFileServiceImpl implements FileSaveService {
    @Value("${wowo.filesaver.basedir:../uploads}")
    private String baseDir;
    @Autowired
    private ApplicationContext context;

    private static final Logger logger = LoggerFactory.getLogger(DiskFileServiceImpl.class);

    @PostConstruct
    public void init() throws IOException {
        File outputFolder = Paths.get(baseDir).toFile();
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        } else if (!outputFolder.isDirectory()) {
            logger.warn("Path {} is exsits but not an valid directory.", outputFolder.getPath());
            Files.move(outputFolder, Paths.get(outputFolder.getParent(), "uploads_bak_" + System.currentTimeMillis()).toFile());
            outputFolder.mkdirs();
        }
    }

    @Override
    public FilePath save(File file, String relativeDir) throws IOException {
        String rootDir = Paths.get(baseDir).toAbsolutePath().toString(); // 根目录

        Path outputFilePath = Paths.get(rootDir, relativeDir); // 获取文件输出路径
        writeFileToDisk(file, outputFilePath);
        logger.info("RootDir {}, relativeDir: {}, new file is saved.", rootDir, relativeDir);

        return new FilePath()
                .setRootPath(rootDir)
                .setRelativePath(relativeDir);
    }


    private void writeFileToDisk(File sourceFile, Path outputFilePath) throws IOException {
        File outputFile = outputFilePath.toFile();
        if (outputFile.exists()) {
            throw new FileExistsException(outputFile.getAbsolutePath() + "is Already exsits");
        }
        FileUtils.copyFile(sourceFile, outputFile);
    }

    /**
     * 删除指定路径的文件或目录
     *
     * @param relativePath 待删除文件的相对路劲
     * @return 删除结果, 文件存在且成功删除返回true, 否则返回false
     * @throws IOException
     */
    @Override
    public boolean delete(String relativePath) throws IOException {
        String rootDir = Paths.get(baseDir).toAbsolutePath().toString(); // 根目录

        Path filePath = Paths.get(rootDir, relativePath); // 获取文件输出路径
        if (filePath.toFile().exists()) {
            filePath.toFile().delete();
            logger.info("RootDir {}, relativeDir: {}, new file is deleted.", rootDir, relativePath);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断指定路径是否存在
     *
     * @param relativePath 待判断的路径
     * @return 如果存在返回true, 不存在返回false
     */
    @Override
    public boolean isExists(String relativePath) {
        String rootDir = Paths.get(baseDir).toAbsolutePath().toString(); // 根目录
        Path filePath = Paths.get(rootDir, relativePath); // 获取文件输出路径
        return filePath.toFile().exists();
    }

}
