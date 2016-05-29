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
import java.util.UUID;

/**
 * @author fangwentong
 * @title DiskFileSaveServiceImpl
 * @desc TODO
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
    public FilePath save(File file, String originFileName) throws IOException {
        String rootDir = Paths.get(baseDir).toAbsolutePath().toString(); // 根目录
        String relativeDir = null;
        boolean isSaved = false;
        do {
            try {
                relativeDir = generateFileName(originFileName); // 相对目录
                logger.info("RootDir {}, relativeDir: {}", rootDir, relativeDir);
                Path outputFilePath = Paths.get(rootDir, relativeDir); // 获取文件输出路径
                writeFileToDisk(file, outputFilePath);
                isSaved = true;
            } catch (FileExistsException e) {
                logger.warn(e.toString());
            }

        } while (!isSaved);

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

    private String generateFileName(String originPath) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UUID.randomUUID());
        stringBuilder.append("-");
        stringBuilder.append(originPath);
        return stringBuilder.toString();
    }
}
