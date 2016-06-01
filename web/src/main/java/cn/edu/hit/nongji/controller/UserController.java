package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.LoginUser;
import cn.edu.hit.nongji.dto.request.AddUserRequest;
import cn.edu.hit.nongji.dto.request.UpdateUserRequest;
import cn.edu.hit.nongji.dto.response.LoginResultDto;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.dto.user.UserDetail;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.UserService;
import cn.edu.hit.nongji.util.ThreadLocalHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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
        User u = userService.getUserByNameOrMobileOrEmail(user.getUsername(), user.getMobile(), user.getEmail());
        if (u != null) {
            if (u.getName().equals(user.getUsername())) {
                return resourceAlreadyExistsResponse("用户名已存在");
            } else if (u.getMobile().equals(user.getMobile())) {
                return resourceAlreadyExistsResponse("手机号码已被绑定");
            } else if (u.getEmail().equals(user.getEmail())) {
                return resourceAlreadyExistsResponse("邮箱已被绑定");
            } else {
                return resourceAlreadyExistsResponse();
            }
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
            LoginUser loginUser = new LoginUser().setUserId(user.getId())
                    .setUserType(user.getUserType())
                    .setUsername(user.getName());

            session.setAttribute("user", loginUser);

            ThreadLocalHelper.setLoginUser(loginUser);
            return successResponse("login successful.")
                    .setData(new LoginResultDto()
                            .setToken(session.getId())
                            .setExpiresIn(session.getMaxInactiveInterval())
                            .setName(user.getName())
                            .setPhone(user.getMobile())
                            .setStatus(user.getStatus())
                            .setUserId(user.getId())
                    );
        } else {
            return inputErrorResponse("输入的用户名或密码有误.");
        }
    }

    @RequestMapping("logout")
    @ResponseBody
    public Response logout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            // 删除session信息
            session.invalidate();
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

    @RequestMapping("/detail/mine")
    @ResponseBody
    public Response getDetail(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Assert.notNull(session, "Session information should not be null");
        Long userId = (Long) session.getAttribute("user_id");
        Assert.notNull(userId, "UserId can not be null");
        User user = userService.getUserByUserId(userId);
        UserDetail detail = new UserDetail().setUserId(user.getId())
                .setPhone(user.getMobile())
                .setName(user.getName())
                .setStatus(user.getStatus());
        return successResponse().setData(detail);
    }

    @RequestMapping("/{id}/update")
    @ResponseBody
    public Response updateUserWithPathPara(@PathVariable long userId, @RequestBody UpdateUserRequest request) {
        request.setUserId(userId);
        userService.updateUser(request);
        return successResponse("更新成功.");
    }

    @RequestMapping("/update")
    @ResponseBody
    public Response updateUser(@RequestBody UpdateUserRequest request) {
        userService.updateUser(request);
        return successResponse("更新成功.");
    }

}
