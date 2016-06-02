package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.request.NewCommentRequet;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("new")
    @ResponseBody
    public Response addNewComment(@RequestBody NewCommentRequet newCommentRequet) {
        return successResponse();
    }
}
