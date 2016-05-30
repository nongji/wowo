package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.service.FileSaveService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author fangwentong
 * @title QiNiuFileSaveServiceImpl
 * @desc 七牛云文件存储服务接口
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
    private BucketManager bucketManager;
    private static final Logger logger = LoggerFactory.getLogger(QiNiuFileSaveServiceImpl.class);

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
        bucketManager = new BucketManager(auth);
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

    /**
     * 删除指定路径的文件或目录
     *
     * @param relativePath 待删除文件的相对路劲
     * @return 删除结果, 文件存在且成功删除返回true, 否则返回false
     * @throws IOException
     */
    @Override
    public boolean delete(String relativePath) throws QiniuException {
        if (isExists(relativePath)) {
            bucketManager.delete(bucketName, getFullKey(relativePath));
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
    public boolean isExists(String relativePath) throws QiniuException {
        try {
            FileInfo fileInfo = bucketManager.stat(bucketName, getFullKey(relativePath));
            return true;
        } catch (QiniuException e) {
            Response response = e.response;
            if (response.statusCode == 612) {  // 612 为资源不存在的返回码
                return false;
            } else {
                throw e;
            }
        }
    }

}
