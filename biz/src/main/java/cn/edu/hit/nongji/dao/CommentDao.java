package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fangwentong
 * @title CommentDao
 * @desc 评论数据访问对象
 * @since 2016-05-30 23:05
 */

@Repository
public interface CommentDao {
    /**
     * 添加新评论
     *
     * @param comment 新评论
     * @return 影响行数
     */
    int addNewComment(Comment comment);

    /**
     * 根据评论类型和被评论实体id查找评论
     *
     * @param type      评论类型
     * @param relatedId 被评论实体id
     * @return 满足条件的评论
     */
    List<Comment> getCommentByTypeAndRelatedId(int type, long relatedId);

    /**
     * 根据一级评论id获取二级评论
     *
     * @param parentId 一级评论id
     * @return 一级评论为parentId的二级评论
     */
    List<Comment> getCommentByParentId(long parentId);

    /**
     * 根据一级评论获取二级评论, 批量模式
     *
     * @param parentIds 一级评论id
     * @return 一级评论为parentIds其中之一的所有二级评论
     * @see #getCommentByParentId(long)
     */
    List<Comment> getCommentByParentIds(List<Long> parentIds);

    /**
     * 获取所有回复给指定用户的回复
     *
     * @param commentedUserId 被评论用户id
     * @return 所有回复给该用户的回复内容
     */
    List<Comment> getCommentByCommentedUserId(long commentedUserId);


    List<Comment> getCommentByCommentedUsername(String username);


    List<Comment> getCommentByUserId(long userId);

    /**
     * 根据评论类型和被评论实体id删除评论
     *
     * @param type
     * @param relatedId
     * @return
     */
    int deleteCommentsByTypeAndRelatedId(int type, long relatedId);

    /**
     * 删除指定用户发表的所有评论
     *
     * @param userId 用户id
     * @return
     */
    int deleteCommentsByUserId(long userId);

    /**
     * 删除评论id删除评论
     *
     * @param commentId 评论id
     * @return 影响行数
     */
    int deleteCommentsByCommentId(long commentId);
}
