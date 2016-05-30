package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Date;

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
            String response = exec("sh", "/Users/tong/sandbox/test1");
            logger.info(response);
            return successResponse("部署成功")
                    .setData(response);
        } catch (JsonProcessingException e) {
            logger.error("Error while deploy: {}", e);
            return internalServerError(e.getCause().toString());
        } catch (IOException | InterruptedException e) {
            logger.error("Error while deploy: {}", e);
            return internalServerError(e.getCause().toString());
        }
    }

    private static String exec(String... cmds) throws IOException, InterruptedException {
        String line;
        StringBuilder result = new StringBuilder();
        Process process = Runtime.getRuntime().exec(cmds);  // 调用命令
        process.waitFor();

        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            writer = new FileWriter("project_update.log", true);
            while ((line = reader.readLine()) != null) {
                result.append(line);
                result.append("\n");
            }
            writer.append(result.toString());
            writer.append(String.format("\n\n\nProject updated at: %s.\n\n\n",
                    DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS")));
            writer.flush();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }
        return result.toString();
    }
}
