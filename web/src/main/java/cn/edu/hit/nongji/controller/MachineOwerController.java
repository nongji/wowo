package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.request.CompleteUserInfoRequest;
import cn.edu.hit.nongji.dto.response.MachineOwnerInfo;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.po.MachineOwner;
import cn.edu.hit.nongji.service.AssetManagementService;
import cn.edu.hit.nongji.service.FileSaveService;
import cn.edu.hit.nongji.service.MachineOwnerService;
import cn.edu.hit.nongji.util.FileUtil;
import cn.edu.hit.nongji.util.ThreadLocalHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author fangwentong
 * @title MachineOwerController
 * @desc 农机主信息管理
 * @date 2016-05-04 14:49
 */

@Controller
@RequestMapping("/user")
public class MachineOwerController extends AbstractCommonController {

    @Autowired
    private MachineOwnerService machineOwnerService;

    @Autowired
    @Qualifier("qiNiuFileSaveServiceImpl")
    private FileSaveService fileSaveService;
    @Autowired
    private AssetManagementService assetManagementService;

    private static final Logger logger = LoggerFactory.getLogger(MachineOwerController.class);

    @RequestMapping(value = "/profile", method = {RequestMethod.POST})
    @ResponseBody
    public Response uploadQulificationInfo(@RequestParam(value = "id_card_1", required = false) MultipartFile idCard1,
                                           @RequestParam(value = "id_card_2", required = false) MultipartFile idCard2,
                                           @RequestParam(value = "certificate_1", required = false) MultipartFile certificate1,
                                           @RequestParam(value = "certificate_2", required = false) MultipartFile certificate2,
                                           @RequestParam(value = "data", required = false) String data
    ) {
        if (idCard1 == null || idCard2 == null) {
            return inputErrorResponse("身份证信息不全, 请确保上传了身份证正反面信息.");
        }
        if (certificate1 == null) {
            return inputErrorResponse("驾照信息不全.");
        }
        if (StringUtils.isEmpty(data)) {
            return inputErrorResponse("缺少详细信息");
        }
        CompleteUserInfoRequest request = null;
        try {
            request = CompleteUserInfoRequest.fromJsonString(data);
        } catch (IOException e) {
            return inputErrorResponse("data域不是有效的JSON字符串.");
        }

        try {  // 保存文件
            if (idCard1 != null) {
                long picId = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(idCard1),
                                FileUtil.getRandomPah(idCard1.getOriginalFilename()))
                );
                request.setIdCard1(picId);
            }

            if (idCard2 != null) {
                long picId = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(idCard2),
                                FileUtil.getRandomPah(idCard2.getOriginalFilename()))
                );
                request.setIdCard2(picId);
            }

            if (certificate1 != null) {
                long picId = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(certificate1),
                                FileUtil.getRandomPah(certificate1.getOriginalFilename()))
                );
                request.setCertificate1(picId);
            }

            if (certificate2 != null) {
                long picId = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(certificate2),
                                FileUtil.getRandomPah(certificate2.getOriginalFilename()))
                );
                request.setCertificate2(picId);
            }

        } catch (IOException e) {
            logger.error("Error while save file: {}", ExceptionUtils.getStackTrace(e));
            return internalServerError("Error while save file.");
        }

        machineOwnerService.completeUserInfo(request);

        return successResponse("个人信息补充完成");
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET})
    @ResponseBody
    public Response getSelfProfile() {
        long userId = ThreadLocalHelper.getLoginUser().getUserId();
        MachineOwner owner = machineOwnerService.getMachineOwnerInfo(userId);
        MachineOwnerInfo result = new MachineOwnerInfo()
                .setLat(owner.getLat())
                .setLng(owner.getLng())
                .setUserId(owner.getUserId())
                .setUserType(owner.getUserType())
                .setLocation(owner.getLocation())
                .setIdCard1(assetManagementService.getAssetByAssetId(owner.getIdCard1()))
                .setIdCard2(assetManagementService.getAssetByAssetId(owner.getIdCard2()))
                .setCertificate1(assetManagementService.getAssetByAssetId(owner.getCertificate1()))
                .setCertificate2(assetManagementService.getAssetByAssetId(owner.getCertificate2()));

        return successResponse().setData(result);
    }

}
