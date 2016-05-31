package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.request.MachineRegisterRequest;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.service.AssetManagementService;
import cn.edu.hit.nongji.service.FileSaveService;
import cn.edu.hit.nongji.service.MachineManagementService;
import cn.edu.hit.nongji.util.FileUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
 * @title MachineController
 * @desc 农机管理
 * @date 2016-05-04 14:49
 */

@Controller
@RequestMapping("/machine")
public class MachineController extends AbstractCommonController {
    @Autowired
    public MachineManagementService machineManagementService;
    @Autowired
    @Qualifier("qiNiuFileSaveServiceImpl")
    private FileSaveService fileSaveService;
    @Autowired
    private AssetManagementService assetManagementService;

    @RequestMapping(value = "/new", method = {RequestMethod.POST})
    @ResponseBody
    public Response addNewMachine(@RequestParam(value = "driver_license", required = false) MultipartFile driverLicense,
                                  @RequestParam(value = "machine_license1", required = false) MultipartFile machineLicense1,
                                  @RequestParam(value = "machine_license2", required = false) MultipartFile machineLicense2,
                                  @RequestParam(value = "data", required = false) String data
    ) {
        if (driverLicense == null) {
            return inputErrorResponse("驾照图片缺失.");
        }
        if (machineLicense1 == null || machineLicense2 == null) {
            return inputErrorResponse("图片信息不完整.");
        }
        if (data == null) {
            return inputErrorResponse("data域不能为空.");
        }
        MachineRegisterRequest registerRequest = null;
        try {
            registerRequest = MachineRegisterRequest.fromJsonString(data);
        } catch (IOException e) {
            return inputErrorResponse("data域不是合法的JSON字符串.");
        }

        try {  // 保存文件
            if (driverLicense != null) {
                long pic1 = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(driverLicense),
                                FileUtil.getRandomPah(driverLicense.getOriginalFilename()))
                );
                registerRequest.setDriverLicense(pic1);
            }

            if (machineLicense1 != null) {
                long pic1 = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(machineLicense1),
                                FileUtil.getRandomPah(machineLicense1.getOriginalFilename()))
                );
                registerRequest.setMachineLicense1(pic1);
            }

            if (machineLicense2 != null) {
                long pic1 = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(machineLicense2),
                                FileUtil.getRandomPah(machineLicense2.getOriginalFilename()))
                );
                registerRequest.setMachineLicense2(pic1);
            }

        } catch (IOException e) {
            logger.error("Error while save file: {}", ExceptionUtils.getStackTrace(e));
            return internalServerError("Error while save file.");
        }

        machineManagementService.addNewMachine(registerRequest);

        return successResponse("添加成功");
    }
}
