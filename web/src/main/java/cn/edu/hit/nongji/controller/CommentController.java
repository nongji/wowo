package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.request.NewCommentRequet;
import cn.edu.hit.nongji.dto.response.CommentDto;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.po.Comment;
import cn.edu.hit.nongji.service.CommentService;
import cn.edu.hit.nongji.util.ThreadLocalHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @author fangwentong
 * @title CommentController
 * @desc 评论控制器类
 * @since 2016-05-31 14:10
 */

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractCommonController {

    @Autowired
    private CommentService commentService;

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @RequestMapping(value = "new", method = RequestMethod.POST)
    @ResponseBody
    public Response addNewComment(@RequestBody NewCommentRequet newCommentRequet) throws ParseException {
        Comment comment = new Comment()
                .setContent(newCommentRequet.getContent())
                .setUserId(ThreadLocalHelper.getLoginUser().getUserId())
                .setRelatedId(newCommentRequet.getRelatedId())
                .setUsername(newCommentRequet.getUsername())
                .setCommenttedUserId(newCommentRequet.getCommentedUserId())
                .setCommenttedUsername(newCommentRequet.getCommentedUsername())
                .setType(newCommentRequet.getCommentType())
                .setPublishTime(ThreadLocalHelper.getDateFormat().parse(newCommentRequet.getPublishTimestamp()))
                ;
        commentService.addNewComment(comment);
        return successResponse("保存成功");
    }

    @RequestMapping("/demand/{demandId}")
    @ResponseBody
    public Response getCommentByCommandId(@PathVariable long demandId) {
        List<CommentDto> result = null;
        return successResponse().setData(result);
    }

    @RequestMapping("/list/{commentType}/{relatedId}")
    @ResponseBody
    public Response getCommentListByCommentTypeAndRelatedId(@PathVariable int commentType, @PathVariable long relatedId) {

        List<CommentDto> result = commentService.getCommentByTypeAndRelatedId(commentType, relatedId);
        return successResponse().setData(result);
    }


    @RequestMapping("/list/my")
    @ResponseBody
    public Response getMyComments() {
        List<CommentDto> result = commentService.getCommentByUserId(ThreadLocalHelper.getLoginUser().getUserId());
        return successResponse().setData(result);
    }

    @RequestMapping("/list/my/commented")
    @ResponseBody
    public Response getCommentsToMine() {
        List<CommentDto> result = commentService.getCommentsByCommenttedUsername(ThreadLocalHelper.getLoginUser().getUsername());
        return successResponse().setData(result);
    }

}
