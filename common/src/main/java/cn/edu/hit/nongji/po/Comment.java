package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fangwentong
 * @title Comment
 * @desc 评论信息
 * @since 2016-05-30 16:56
 */

public class Comment implements Serializable {
    private Long id;
    private Date publishTime;  // 评论发表时间
    private Integer type;  // 评论类型
    private Long relatedId;  // 评论关联id
    private Long parentId; // 父评论id
    private Long userId; // 回复发起用户的userId
    private String username; // 用户名
    private Long commenttedUserId; // 被回复的用户
    private String commenttedUsername; // 被回复的用户名


    private String content; // 回复内容

    public String getUsername() {
        return username;
    }

    public Comment setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getCommenttedUsername() {
        return commenttedUsername;
    }

    public Comment setCommenttedUsername(String commenttedUsername) {
        this.commenttedUsername = commenttedUsername;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public Comment setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Comment setType(Integer type) {
        this.type = type;
        return this;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public Comment setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public Comment setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Comment setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getCommenttedUserId() {
        return commenttedUserId;
    }

    public Comment setCommenttedUserId(Long commenttedUserId) {
        this.commenttedUserId = commenttedUserId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
