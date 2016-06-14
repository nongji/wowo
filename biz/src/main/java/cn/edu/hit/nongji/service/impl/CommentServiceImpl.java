package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.dao.CommentDao;
import cn.edu.hit.nongji.dto.response.CommentDto;
import cn.edu.hit.nongji.po.Comment;
import cn.edu.hit.nongji.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 根据评论类型和被评论实体id查找评论
     *
     * @param type      评论类型
     * @param relatedId 被评论实体id
     * @return 满足条件的评论
     */
    @Override
    public List<CommentDto> getCommentByTypeAndRelatedId(int type, long relatedId) {
        List<Comment> comments = commentDao.getCommentByTypeAndRelatedId(type, relatedId);
        List<CommentDto> result = new ArrayList<>(comments.size());

        for (Comment comment: comments) {
            result.add(CommentDto.fromComment(comment));
        }

        return result;
    }

    /**
     * 根据一级评论id获取二级评论
     *
     * @param parentId 一级评论id
     * @return 一级评论为parentId的二级评论
     */
    @Override
    public List<CommentDto> getCommentByParentId(long parentId) {
        List<Comment> comments = commentDao.getCommentByParentId(parentId);
        List<CommentDto> result = new ArrayList<>(comments.size());

        for (Comment comment: comments) {
            result.add(CommentDto.fromComment(comment));
        }

        return result;
    }

    @Override
    public List<CommentDto> getCommentsByCommenttedUsername(String username) {
        List<Comment> comments = commentDao.getCommentByCommentedUsername(username);
        List<CommentDto> result = new ArrayList<>(comments.size());

        for (Comment comment: comments) {
            result.add(CommentDto.fromComment(comment));
        }

        return result;
    }

    @Override
    public List<CommentDto> getCommentByUserId(long userId) {
        List<Comment> comments = commentDao.getCommentByUserId(userId);
        List<CommentDto> result = new ArrayList<>(comments.size());

        for (Comment comment: comments) {
            result.add(CommentDto.fromComment(comment));
        }

        return result;
    }

    /**
     * 根据一级评论获取二级评论, 批量模式
     *
     * @param parentIds 一级评论id
     * @return 一级评论为parentIds其中之一的所有二级评论
     * @see #getCommentByParentId(long)
     */
    @Override
    public List<CommentDto> getCommentByParentIds(List<Long> parentIds) {
        return null;
    }

    /**
     * 获取所有回复给指定用户的回复
     *
     * @param commentedUserId 被评论用户id
     * @return 所有回复给该用户的回复内容
     */
    @Override
    public List<CommentDto> getCommentByCommentedUserId(long commentedUserId) {
        List<Comment> comments = commentDao.getCommentByCommentedUserId(commentedUserId);
        List<CommentDto> result = new ArrayList<>(comments.size());

        for (Comment comment: comments) {
            result.add(CommentDto.fromComment(comment));
        }

        return result;
    }

}
