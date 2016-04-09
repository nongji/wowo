package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Objects;

/**
 * @author fangwentong
 * @title WebHookController
 * @desc Github webhook listener
 * @date 2016-04-09 13:08
 */

@Controller
@RequestMapping("/github")
public class WebHookController extends AbstractCommonController {
    private static final int SIGNATURE_LENGTH = 45;
    private final String secret;


    public WebHookController() {
        this(System.getenv("SECRET_KEY"));
    }

    public WebHookController(String secret) {
        Objects.requireNonNull(secret, "No secret given.");
        this.secret = secret;
    }

    @RequestMapping("deploy")
    @ResponseBody
    public Response deployApp(@RequestHeader("X-Hub-Signature") String signature,
                              @RequestBody String payload) {
        if (signature == null) {
            return inputErrorResponse("参数有误");
        }

        String computed = String.format("sha1=%s", HmacUtils.hmacSha1Hex(secret, payload));
        boolean invalidLength = signature.length() != SIGNATURE_LENGTH;


        if (invalidLength || !MessageDigest.isEqual(signature.getBytes(), computed.getBytes())) {
            return permissionDenyResponse();
        }

        try {
            Runtime.getRuntime().exec("wowo-deploy");
            return successResponse("部署成功");
        } catch (IOException e) {
            logger.error("Error while deploy: {}", e);
            return internalServerError(e.getCause().toString());
        }
    }
}
