package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fangwentong
 * @title MachineOwerController
 * @desc 农机主信息管理
 * @date 2016-05-04 14:49
 */

@Controller
@RequestMapping("/user")
public class MachineOwerController extends AbstractCommonController {

    @RequestMapping("/profile")
    @ResponseBody
    public Response uploadQulificationInfo() {
        return successResponse();
    }
}
