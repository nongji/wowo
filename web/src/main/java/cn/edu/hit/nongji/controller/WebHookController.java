package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.MessageDigest;

/**
 * @author fangwentong
 * @title WebHookController
 * @desc Github webhook listener
 * @date 2016-04-09 13:08
 */

@Controller
@RequestMapping(path = "/github")
public class WebHookController extends AbstractCommonController {
    private static final int SIGNATURE_LENGTH = 45;
    private final String secret;


    public WebHookController() {
        this.secret = System.getenv("SECRET_KEY");
    }

    @RequestMapping(path = "deploy", method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public Response deployApp(@RequestHeader(value = "X-Hub-Signature", required = false) String signature,
                              @RequestBody String payload) {
        if (signature == null) {
            return inputErrorResponse("参数有误");
        }

        String computed = String.format("sha1=%s", HmacUtils.hmacSha1Hex(secret, payload));
        boolean invalidLength = signature.length() != SIGNATURE_LENGTH;

        if (invalidLength || !MessageDigest.isEqual(signature.getBytes(), computed.getBytes())) {
            return permissionDenyResponse();
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(payload);
            if (!("refs/heads/master".equals(node.get("ref").asText()))) {
                return successResponse("not the master branch, passed!");
            }
            Process process = Runtime.getRuntime().exec("/usr/bin/wowo-deploy");
            return successResponse("部署成功");
        } catch (JsonProcessingException e) {
            logger.error("Error while deploy: {}", e);
            return internalServerError(e.getCause().toString());
        } catch (IOException e) {
            logger.error("Error while deploy: {}", e);
            return internalServerError(e.getCause().toString());
        }
    }
}
