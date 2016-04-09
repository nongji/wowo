package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.dto.user.UserDetail;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        try {
            userService.addUser(request);
            return successResponse();
        } catch (Exception e) {
            return internalServerError();
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public Response loginWithUsernameAndPassword(@RequestParam String username, @RequestParam String password) {
        try {
            User user = userService.getUserByUserNameAndPassword(username, password);
            if (user != null) {
                // set session infomation here.
                return successResponse("登陆成功");
            } else {
                return inputErrorResponse("输入的用户名或密码有误.");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            return internalServerError();
        }
    }

    @RequestMapping("logout")
    @ResponseBody
    public Response logout() {
        try {
            // remove session infomation here
            return successResponse("成功登出.");
        } catch (Exception e) {
            return internalServerError();
        }
    }

    @RequestMapping("/{id}/detail")
    @ResponseBody
    public Response getDetail(@PathVariable long id) {
        UserDetail detail = new UserDetail();
        return successResponse().setData(detail);
    }

    @RequestMapping("*")
    @ResponseBody
    public Response defaultController() {
        return resourceNotFoundResponse();
    }
}
