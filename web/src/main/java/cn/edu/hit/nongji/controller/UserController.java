package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.TokenInfo;
import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.dto.user.UserDetail;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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
     * @param user 添加用户请求
     * @return
     */
    @RequestMapping(value = "/signup", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public Response userSignUp(@RequestBody AddUserRequest user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())
                || StringUtils.isEmpty(user.getMobile())) {
            return inputErrorResponse("用户名, 密码和手机号码均不能为空.");
        }
        userService.addUser(user);
        return successResponse();
    }

    /**
     * 使用用户名和密码登陆
     *
     * @param  request
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Response loginWithUsernameAndPassword(@RequestBody AddUserRequest request, HttpSession session) {
        String username = request.getUsername();
        String password = request.getPassword();
        User user = userService.getUserByUserNameAndPassword(username, password);
        if (user != null) {
            // set session infomation here.
            session.setAttribute("user_id", user.getId());
            session.setAttribute("username", user.getName());
            session.setAttribute("mobile", user.getMobile());
            return successResponse("login successful.").setData(new TokenInfo(session.getId(), session.getMaxInactiveInterval()));
        } else {
            return inputErrorResponse("输入的用户名或密码有误.");
        }
    }

    @RequestMapping("logout")
    @ResponseBody
    public Response logout(HttpSession session) {
        Enumeration<String> paramNames = session.getAttributeNames();
        // 清空session信息
        while (paramNames.hasMoreElements()) {
            session.removeAttribute(paramNames.nextElement());
        }
        return successResponse("成功登出.");
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("/{id}/detail")
    @ResponseBody
    public Response getDetail(@PathVariable long id) {
        UserDetail detail = new UserDetail();
        return successResponse().setData(detail);
    }
}
