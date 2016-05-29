package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.service.impl.DiskFileServiceImpl;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @author fangwentong
 * @title FileDiskServiceTest
 * @desc TODO
 * @since 2016-05-29 03:21
 */

public class FileDiskServiceTest extends ServiceTestBase {
    DiskFileServiceImpl diskFileSaveService = new DiskFileServiceImpl();

    @Test
    public void testSaveFile() throws IOException {
        FilePath path = diskFileSaveService.save(createFileObject(), "helloworld");
        assertNotNull(path);
        assertNotNull(path.getRelativePath());
        assertNotNull(path.getRootPath());
        System.out.println(path);
    }


    private File createFileObject() throws IOException {
        String filename = "test";
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file);
        out.write("Hello, World".getBytes());
        out.flush();
        out.close();
        return new File(filename);
    }
}
