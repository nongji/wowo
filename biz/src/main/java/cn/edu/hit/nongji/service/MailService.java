package cn.edu.hit.nongji.service;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

/**
 * @author fangwentong
 * @title MailService
 * @desc 发送邮件的接口
 * @since 2016-05-27 22:44
 */

public interface MailService {
    void send(Properties props, String subject, String content, String[] attachFiles,
              Collection<File> files, boolean isHtml, boolean deleteFiles);
}
