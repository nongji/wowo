package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.po.User;
import cn.edu.hit.nongji.service.FileSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author fangwentong
 * @title TestController
 * @desc TODO
 * @date 2016-04-11 18:00
 */

@Controller
@RequestMapping("/test")
public class TestController extends AbstractCommonController {
    @Autowired
    @Qualifier("diskFileServiceImpl")
    private FileSaveService fileSaveService;

    @ResponseBody
    @RequestMapping("get")
    public String index(HttpServletRequest request, String action, String msg, String key) {
        HttpSession session = request.getSession();
        String message = "ok";
        if ("set".equals(action)) {
            session.setAttribute(key, msg);
        } else if ("get".equals(action)) {
            message = (String) session.getAttribute(key);
        }
        return message;
    }

    @RequestMapping("hello")
    @ResponseBody
    public String throwEx(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("/index")
    @ResponseBody
    public Response name(HttpSession session) {
        session.setAttribute("hello", "world");
        session.setAttribute("user_id", 1L);
        return successResponse();
    }

    @RequestMapping("/session")
    @ResponseBody
    public Response get(HttpSession session) {
        String world = (String) session.getAttribute("hello");
        System.out.println("结果为:" + world);
        return successResponse().setData("" + session.getAttribute("hello"));
    }

    @RequestMapping("upload")
    @ResponseBody
    public Response upload(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name) {

        return successResponse("保存成功");

    }

    @RequestMapping("uploadMultiFile")
    @ResponseBody
    public Response uploadMultiFile(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IOException {

        logger.info("name: " + request.getParameter("name"));
        logger.info("files size {}", files.length);
        for (MultipartFile multipartFile : files) {
            File tmpFile = new File("" + System.currentTimeMillis() + multipartFile.getOriginalFilename());
            if (!tmpFile.exists()) {
                tmpFile.createNewFile();
            }
            multipartFile.transferTo(tmpFile);
            FilePath path = fileSaveService.save(tmpFile, multipartFile.getOriginalFilename());
            logger.info("File saved, path {}", path);
            tmpFile.delete();
        }
        return successResponse("保存成功");
    }
}
