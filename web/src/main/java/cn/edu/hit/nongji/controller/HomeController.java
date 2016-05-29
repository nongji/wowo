package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import com.google.common.base.MoreObjects;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author fangwentong
 * @title HomeController
 * @desc 主页面渲染控制器
 * @date 2016-04-25 20:20
 */

@Controller
public class HomeController extends AbstractCommonController {
    @RequestMapping(value = {"/"})
    public String index(@RequestParam(required = false) String name, HttpServletRequest req) {
        return "sign/home";
    }

    @RequestMapping(value = {"/dashbaord", "/infocenter"})
    public String showDashBoard() {
        return "sign/dashboard";
    }

    @RequestMapping(value = {"/hello"})
    public String sayHello(@RequestParam(required = false) String name, HttpServletRequest req) {
        name = MoreObjects.firstNonNull(name, "Vistor");
        req.setAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPassword() {
        return "sign/forgot_password";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String resetPassword() {
        return "sign/reset_password";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response upload(MultipartFile image) {
        Response res = successResponse();
        res.setData("");
        return res;
    }
}
