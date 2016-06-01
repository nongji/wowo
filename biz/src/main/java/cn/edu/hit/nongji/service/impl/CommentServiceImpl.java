package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.po.Comment;
import cn.edu.hit.nongji.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fangwentong
 * @title CommentServiceImpl
 * @desc 评论服务
 * @since 2016-05-30 23:24
 */

public class CommentServiceImpl implements CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public void addNewComment(Comment comment) {

    }

    @Override
    public void deleteComment(Long commentId) {

    }

    @Override
    public void hideComment(Long commentId) {

    }

    @Override
    public void deleteCommentsByUserId(Long userId) {

    }

    @Override
    public void deleteCommentsByCommenttedUserId(Long commenttedUserId) {

    }

    @Override
    public void deleteCommentsByDemandId(Long demandId) {

    }
}
