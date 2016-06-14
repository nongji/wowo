package cn.edu.hit.nongji.dto.response;

import cn.edu.hit.nongji.po.Comment;
import cn.edu.hit.nongji.util.ThreadLocalHelper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title CommentDto
 * @desc 前端关心的评论
 * @since 2016-06-03 11:08
 */

public class CommentDto implements Serializable {

    private Long id;
    @JsonProperty("time")
    private String publishTime;  // 评论发表时间
    private Integer type;  // 评论类型
    @JsonProperty("related_id")
    private Long relatedId;  // 评论关联id
    @JsonProperty("name")
    private String username; // 用户名
    @JsonProperty("reply_to")
    private String commenttedUsername; // 被回复的用户名

    private String content; // 回复内容


    public Long getId() {
        return id;
    }

    public CommentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public CommentDto setPublishTime(String publishTime) {
        this.publishTime = publishTime;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public CommentDto setType(Integer type) {
        this.type = type;
        return this;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public CommentDto setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CommentDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getCommenttedUsername() {
        return commenttedUsername;
    }

    public CommentDto setCommenttedUsername(String commenttedUsername) {
        this.commenttedUsername = commenttedUsername;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentDto setContent(String content) {
        this.content = content;
        return this;
    }

    public static CommentDto fromComment(Comment comment) {
        CommentDto result = new CommentDto();

        result.setId(comment.getId())
                .setCommenttedUsername(comment.getCommenttedUsername())
                .setContent(comment.getContent())
                .setPublishTime(ThreadLocalHelper.getDateFormat().format(comment.getPublishTime()))
                .setRelatedId(comment.getRelatedId())
                .setType(comment.getType())
                .setUsername(comment.getUsername())
                ;
        return result;
    }
}
