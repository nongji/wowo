package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.dto.response.CommentDto;
import cn.edu.hit.nongji.po.Comment;

import java.util.List;

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


    /**
     * 根据评论类型和被评论实体id查找评论
     *
     * @param type      评论类型
     * @param relatedId 被评论实体id
     * @return 满足条件的评论
     */
    List<CommentDto> getCommentByTypeAndRelatedId(int type, long relatedId);

    /**
     * 根据一级评论id获取二级评论
     *
     * @param parentId 一级评论id
     * @return 一级评论为parentId的二级评论
     */
    List<CommentDto> getCommentByParentId(long parentId);

    List<CommentDto> getCommentsByCommenttedUsername(String username);


    List<CommentDto> getCommentByUserId(long userId);


    /**
     * 根据一级评论获取二级评论, 批量模式
     *
     * @param parentIds 一级评论id
     * @return 一级评论为parentIds其中之一的所有二级评论
     * @see #getCommentByParentId(long)
     */
    List<CommentDto> getCommentByParentIds(List<Long> parentIds);

    /**
     * 获取所有回复给指定用户的回复
     *
     * @param commentedUserId 被评论用户id
     * @return 所有回复给该用户的回复内容
     */
    List<CommentDto> getCommentByCommentedUserId(long commentedUserId);
}
