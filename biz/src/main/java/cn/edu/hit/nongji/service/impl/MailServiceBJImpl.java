package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.service.MailService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

/**
 * @author bjhl
 * @title MailServiceBJImpl
 * @desc 邮件服务
 * @since 2016-05-27 22:39
 */

public class MailServiceBJImpl implements MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailServiceBJImpl.class);

    /**
     * 发送简单邮件
     *
     * @param props
     * @param subject
     * @param content
     */
    public void send(Properties props, String subject, String content) {
        send(props, subject, content, (String) null);
    }

    /**
     * 发送带附件邮件
     *
     * @param props
     * @param subject
     * @param content
     * @param attachFile
     */
    public void send(Properties props, String subject, String content, String attachFile) {
        String[] attachFiles = null;
        if (!StringUtils.isEmpty(attachFile)) {
            attachFiles = new String[]{attachFile};
        }
        send(props, subject, content, attachFiles);
    }

    /**
     * 发送带附件邮件
     *
     * @param props
     * @param subject
     * @param content
     * @param attachFiles
     */
    public void send(Properties props, String subject, String content, String[] attachFiles) {
        send(props, subject, content, attachFiles, null, true, true);
    }

    /**
     * 发送带附件邮件 <br>
     * 发送完后文件<b>【删除】</b>
     *
     * @param props
     * @param subject 主题
     * @param content 内容
     * @param file    文件
     */
    public void sendAndDeleteFile(Properties props, String subject, String content, File file) {
        send(props, subject, content, Arrays.asList(file), true);
    }

    /**
     * 发送带附件邮件<br>
     * 发送完后文件<b>【不删除】</b>
     *
     * @param props
     * @param subject 主题
     * @param content 内容
     * @param file    文件
     */
    public void sendAndKeepFile(Properties props, String subject, String content, File file) {
        send(props, subject, content, Arrays.asList(file), false);
    }

    /**
     * 发送带附件邮件
     *
     * @param props
     * @param subject     主题
     * @param content     内容
     * @param files       文件列表
     * @param deleteFiles 是否删除文件
     */
    public void send(Properties props, String subject, String content, Collection<File> files,
                     boolean deleteFiles) {
        send(props, subject, content, null, files, true, deleteFiles);
    }

    /**
     * @param props
     * @param subject
     * @param content
     * @param attachFiles
     * @param isHtml
     */
    public void send(Properties props, String subject, String content, String[] attachFiles,
                     Collection<File> files, boolean isHtml, boolean deleteFiles) {
        Transport transport = null;
        try {
            Session session = Session.getInstance(props);

            Message msg = new MimeMessage(session);

            // set mailfrom
            msg.setFrom(new InternetAddress(props.getProperty("mail.from")));

            // set mailto
            String mailto = props.getProperty("mail.to");
            String[] toAddr = mailto.split(",");
            Address[] addrs = new Address[toAddr.length];
            for (int i = 0; i < toAddr.length; i++) {
                addrs[i] = new InternetAddress(toAddr[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addrs);

            String mailcc = props.getProperty("mail.cc");
            if (!StringUtils.isEmpty(mailcc)) {
                String[] ccAddr = mailcc.split(",");
                Address[] ccAddrs = new Address[ccAddr.length];
                for (int i = 0; i < ccAddr.length; i++) {
                    ccAddrs[i] = new InternetAddress(ccAddr[i]);
                }
                msg.setRecipients(Message.RecipientType.CC, ccAddrs);
            }

            Multipart mmp = new MimeMultipart();
            msg.setContent(mmp);

            // set subject
            if (subject != null) {
                msg.setSubject(subject);
            }

            // set content
            if (content != null) {
                BodyPart contentMbp = new MimeBodyPart();
                if (isHtml) {
                    contentMbp.setContent(content, "text/html;charset=utf-8");
                } else {
                    contentMbp.setContent(content, "text/plain");
                }
                mmp.addBodyPart(contentMbp);
            }

            // set attachments
            if (attachFiles != null) {
                for (String attachFile : attachFiles) {
                    MimeBodyPart mbp = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(attachFile);
                    mbp.setDataHandler(new DataHandler(fds));
                    try {
                        mbp.setFileName(MimeUtility.encodeText(fds.getName()));
                    } catch (UnsupportedEncodingException e) {
                        logger.error("encode file name:{} catch error:{}", fds.getName(), e);
                        mbp.setFileName(fds.getName());
                    }
                    mmp.addBodyPart(mbp);
                }
            }

            // set attachments by file
            if (files != null && files.isEmpty() == false) {
                for (File file : files) {
                    MimeBodyPart mbp = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(file);
                    mbp.setDataHandler(new DataHandler(fds));
                    try {
                        mbp.setFileName(MimeUtility.encodeText(fds.getName()));
                    } catch (UnsupportedEncodingException e) {
                        logger.error("encode file name:{} catch error:{}", fds.getName(), e);
                        mbp.setFileName(fds.getName());
                    }
                    mmp.addBodyPart(mbp);
                }
            }

            // set time
            msg.setSentDate(new Date());

            transport = session.getTransport("smtp");
            transport.send(msg);

            logger.info("mail has been sent - subject:{}", subject);
        } catch (MessagingException e) {
            logger.error("send exception - ", e);
            throw new RuntimeException("send mail exception - ", e);
        } finally {
            try {
                if (transport != null) {
                    transport.close();
                }
            } catch (Exception e) {
                logger.error("send exception - ", e);
                throw new RuntimeException("send mail exception - ", e);
            }
            // 删除文件
            if (deleteFiles && files != null && files.isEmpty() == false) {
                for (File file : files) {
                    if (file != null) {
                        file.delete();
                    }
                }
            }
        }
    }
}
