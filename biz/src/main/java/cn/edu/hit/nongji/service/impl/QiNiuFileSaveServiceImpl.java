package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.service.FileSaveService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    @Value("${qiniu.domain:}")
    private String qiniuDomain;
    @Value("${qiniu.accessKey:}")
    private String ACCESS_KEY;
    @Value("${qiniu.secretKey:}")
    private String SECRET_KEY;
    private Auth auth;
    private UploadManager uploadManager;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(ACCESS_KEY)) {
            ACCESS_KEY = System.getenv("QINIU_ACCESS_KEY");
        }
        if (StringUtils.isEmpty(SECRET_KEY)) {
            SECRET_KEY = System.getenv("QINIU_SECRET_KEY");
        }
        auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        uploadManager = new UploadManager();
    }

    String getUpToken() {
        System.out.println("bucketName: " + bucketName);
        return auth.uploadToken(bucketName);
    }

    String getFullKey(String targetPath) {
        return keyPrefix + targetPath;
    }

    String getFileUrl(String targetPath) {
        return getRootPath() + "/" + getFullKey(targetPath);
    }

    String getRootPath() {
        return qiniuDomain;
    }
    @Override
    public FilePath save(File file, String targetPath) throws QiniuException {
        Response res = uploadManager.put(file, getFullKey(targetPath), getUpToken());
        if (res.isOK()) {
            return new FilePath().setRelativePath(getRootPath())
                    .setRelativePath(getFullKey(targetPath));
        } else {
            return null;
        }
    }

}
