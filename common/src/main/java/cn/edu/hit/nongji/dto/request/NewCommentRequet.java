package cn.edu.hit.nongji.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author fangwentong
 * @title NewCommentRequet
 * @desc 添加新评论请求
 * @since 2016-06-02 21:01
 */

public class NewCommentRequet extends AbstractRequest {
    @JsonProperty("comment_type")
    Integer commentType;
    @JsonProperty("related_id")
    Long relatedId;
    @JsonProperty("time")
    String publishTimestamp;
    @JsonProperty("user_id")
    Long userId;
    @JsonProperty("name")
    String username;

    @JsonProperty("commented_user_id")
    Long commentedUserId;

    @JsonProperty("reply_to")
    String commentedUsername;

    String content;


    public String getUsername() {
        return username;
    }

    public NewCommentRequet setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getCommentedUsername() {
        return commentedUsername;
    }

    public NewCommentRequet setCommentedUsername(String commentedUsername) {
        this.commentedUsername = commentedUsername;
        return this;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public NewCommentRequet setCommentType(Integer commentType) {
        this.commentType = commentType;
        return this;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public NewCommentRequet setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
        return this;
    }

    public String getPublishTimestamp() {
        return publishTimestamp;
    }

    public NewCommentRequet setPublishTimestamp(String publishTimestamp) {
        this.publishTimestamp = publishTimestamp;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public NewCommentRequet setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getCommentedUserId() {
        return commentedUserId;
    }

    public NewCommentRequet setCommentedUserId(Long commentedUserId) {
        this.commentedUserId = commentedUserId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewCommentRequet setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
