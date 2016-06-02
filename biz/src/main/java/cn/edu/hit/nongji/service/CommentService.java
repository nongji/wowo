package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.po.Comment;

/**
 * @author fangwentong
 * @title CommentService
 * @desc 评论服务
 * @since 2016-05-30 23:24
 */

public interface CommentService {

    /**
     * 添加新的评论
     *
     * @param comment
     */
    Long addNewComment(Comment comment);

    /**
     * 根据评论内容获取
     *
     * @param commentId
     */
    void deleteComment(Long commentId);

    /**
     * 隐藏评论
     *
     * @param commentId
     */
    void hideComment(Long commentId);

    /**
     * 删除指定用户所有的评论
     *
     * @param userId
     */
    void deleteCommentsByUserId(Long userId);


    /**
     * @param demandId
     */
    void deleteCommentsByDemandId(Long demandId);
}
