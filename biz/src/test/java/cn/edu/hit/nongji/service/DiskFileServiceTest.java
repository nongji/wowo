package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.service.impl.DiskFileServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author fangwentong
 * @title DiskFileServiceTest
 * @desc Tests for class {@link DiskFileServiceImpl }
 * @since 2016-05-29 03:21
 */

public class DiskFileServiceTest extends ServiceTestBase {
    @Autowired
    DiskFileServiceImpl diskFileSaveService;

    @Test
    public void testSaveFile() throws IOException {
        String filename = "helloworld";
        File sourceFile = createFileObject();
        FilePath path = diskFileSaveService.save(sourceFile, filename);
        assertNotNull(path);
        assertNotNull(path.getRelativePath());
        assertNotNull(path.getRootPath());
        System.out.println(path);
        sourceFile.delete();
        assertTrue(diskFileSaveService.isExists(filename));
        diskFileSaveService.delete(filename);
        assertFalse(diskFileSaveService.isExists(filename));
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

    @Test
    public void testIsFileExsits() throws IOException {
        String filename = "test_file_is_exist";
        File sourceFile = createFileObject();

        diskFileSaveService.save(sourceFile, filename);
        assertTrue(diskFileSaveService.isExists(filename));
        diskFileSaveService.delete(filename);
        assertFalse(diskFileSaveService.isExists(filename));

        sourceFile.delete();
    }

    @Test
    public void testDeleteFile() throws IOException {
        String filename = "test_file_delete";
        File sourceFile = createFileObject();

        try {
            diskFileSaveService.save(sourceFile, filename);
            assertTrue(diskFileSaveService.isExists(filename));
            assertTrue(diskFileSaveService.delete(filename));
            assertFalse(diskFileSaveService.isExists(filename));
            assertFalse(diskFileSaveService.delete(filename));
        } finally {
            sourceFile.delete();
        }

    }
}
