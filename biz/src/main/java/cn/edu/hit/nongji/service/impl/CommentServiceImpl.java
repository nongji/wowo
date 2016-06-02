package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.CommentDao;
import cn.edu.hit.nongji.po.Comment;
import cn.edu.hit.nongji.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fangwentong
 * @title CommentServiceImpl
 * @desc 评论服务
 * @since 2016-05-30 23:24
 */

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public Long addNewComment(Comment comment) {
        commentDao.addNewComment(comment);
        return comment.getId();
    }

    @Override
    public void deleteComment(Long commentId) {
        commentDao.deleteCommentsByCommentId(commentId);
    }

    @Override
    public void hideComment(Long commentId) {
    }

    @Override
    public void deleteCommentsByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            return;
        }
        commentDao.deleteCommentsByUserId(userId);
    }

    @Override
    public void deleteCommentsByDemandId(Long demandId) {

    }
}
