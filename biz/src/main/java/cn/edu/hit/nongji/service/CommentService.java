package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.po.Comment;

/**
 * @author fangwentong
 * @title CommentService
 * @desc 评论服务
 * @since 2016-05-30 23:24
 */

public interface CommentService {

    void addNewComment(Comment comment);

    void deleteComment(Long commentId);

    void hideComment(Long commentId);

    void deleteCommentsByUserId(Long userId);

    void deleteCommentsByCommenttedUserId(Long commenttedUserId);

    void deleteCommentsByDemandId(Long demandId);
}
