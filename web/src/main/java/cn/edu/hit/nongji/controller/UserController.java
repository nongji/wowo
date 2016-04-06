package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fangwentong
 * @title UserController
 * @desc 用户中心Controller
 * @date 2016-04-05 00:00
 */

@Controller
@RequestMapping("/user")
public class UserController extends AbstractCommonController {

    @RequestMapping("signup")
    @ResponseBody
    public Response userSignUp() {
        return null;
    }
}
