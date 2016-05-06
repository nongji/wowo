package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.service.FileSaveService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author fangwentong
 * @title QiNiuFileSaveServiceImpl
 * @desc TODO
 * @date 2016-04-27 01:51
 */

@Service
public class QiNiuFileSaveServiceImpl implements FileSaveService {
    @Value("${qiniu.bucket.name:wowo}")
    private String bucketName;
    @Value("${qiniu.key.prefix:}")
    private String keyPrefix;
    @Value("${qiniu.domain}")
    private String qiniuDomain;
    private String ACCESS_KEY = System.getenv("QINIU_ACCESS_KEY");
    private String SECRET_KEY = System.getenv("QINIU_SECRET_KEY");
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    private UploadManager uploadManager = new UploadManager();

    String getUpToken() {
        System.out.println("bucketName: " + bucketName);
        return auth.uploadToken(bucketName);
    }

    String getFullKey(String targetPath) {
        return keyPrefix + targetPath;
    }

    String getFileUrl(String targetPath) {
        return qiniuDomain + "/" + keyPrefix + targetPath;
    }

    @Override
    public FilePath save(File file, String targetPath) throws QiniuException {
        Response res = uploadManager.put(file, getFullKey(targetPath), getUpToken());
        if (res.isOK()) {
            return new FilePath().setFullPath(getFileUrl(targetPath))
                    .setPath(getFullKey(targetPath));
        } else {
            return null;
        }
    }

}
