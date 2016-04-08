package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.enums.MobileResponseCode;
import cn.edu.hit.nongji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    /**
     * JSON接口, 添加新用户
     *
     * @param request 添加用户请求
     * @return
     */
    @RequestMapping(value = "/signup", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public Response userSignUp(@RequestBody AddUserRequest request) {
        userService.addUser(request);

        MobileResponseCode status = MobileResponseCode.OK;
        return new Response()
                .setMsg(status.getDesc())
                .setStatus(status.getCode());
    }

    @RequestMapping("*")
    @ResponseBody
    public String defaultController() {
        return "Hello, World!";
    }

    @RequestMapping("")
    @ResponseBody
    public Response defaultMainController() {
        return new Response().setMsg("Hello, world")
                .setStatus(MobileResponseCode.OK.getCode())
                ;
    }
}
