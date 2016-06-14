package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.LoginUser;
import cn.edu.hit.nongji.dto.MachineDetail;
import cn.edu.hit.nongji.dto.MachineDto;
import cn.edu.hit.nongji.dto.request.MachineRegisterRequest;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.service.AssetManagementService;
import cn.edu.hit.nongji.service.FileSaveService;
import cn.edu.hit.nongji.service.MachineManagementService;
import cn.edu.hit.nongji.util.FileUtil;
import cn.edu.hit.nongji.util.ThreadLocalHelper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    private static final Logger logger = LoggerFactory.getLogger(MachineController.class);

    @RequestMapping(value = "/new", method = {RequestMethod.POST})
    @ResponseBody
    public Response addNewMachine(@RequestParam(value = "driver_license", required = false) MultipartFile driverLicense,
                                  @RequestParam(value = "machine_license_1", required = false) MultipartFile machineLicense1,
                                  @RequestParam(value = "machine_license_2", required = false) MultipartFile machineLicense2,
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
        } catch (UnrecognizedPropertyException | InvalidFormatException e) {
            return inputErrorResponse(e.getMessage());
        } catch (IOException e) {
            return inputErrorResponse("data域不是合法的JSON字符串.")
                    .setData(data);
        }

        LoginUser user = ThreadLocalHelper.getLoginUser();

        try {  // 保存文件
                long pic1 = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(driverLicense),
                                FileUtil.getRandomPah(driverLicense.getOriginalFilename()))
                );
                registerRequest.setDriverLicense(pic1);

                pic1 = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(machineLicense1),
                                FileUtil.getRandomPah(machineLicense1.getOriginalFilename()))
                );
                registerRequest.setMachineLicense1(pic1);

                pic1 = assetManagementService.addNewAsset(
                        fileSaveService.save(convertMultiPartFileToFile(machineLicense2),
                                FileUtil.getRandomPah(machineLicense2.getOriginalFilename()))
                );
                registerRequest.setMachineLicense2(pic1);

        } catch (IOException e) {
            logger.error("Error while save file: {}", ExceptionUtils.getStackTrace(e));
            return internalServerError("Error while save file.");
        }

        registerRequest.setUserId(user.getUserId());

        long machineId = machineManagementService.addNewMachine(registerRequest);

        MachineDetail detail = machineManagementService.getMachineDetailByMachineId(machineId);

        return successResponse("添加成功").setData(detail);
    }

    @RequestMapping(value = "/{machineId}/update", method = RequestMethod.POST)
    @ResponseBody
    public Response updateMachineInfo(@RequestParam(value = "driver_license", required = false) MultipartFile driverLicense,
                                      @RequestParam(value = "machine_license_1", required = false) MultipartFile machineLicense1,
                                      @RequestParam(value = "machine_license_2", required = false) MultipartFile machineLicense2,
                                      @RequestParam(value = "data", required = false) String data,
                                      @PathVariable long machineId
    ) {

        if (data == null) {
            return inputErrorResponse("data域不能为空.");
        }
        MachineRegisterRequest registerRequest = null;
        try {
            registerRequest = MachineRegisterRequest.fromJsonString(data);
        } catch (UnrecognizedPropertyException | InvalidFormatException e) {
            return inputErrorResponse(e.getMessage());
        } catch (IOException e) {
            return inputErrorResponse("data域不是合法的JSON字符串.")
                    .setData(data);
        }

        LoginUser user = ThreadLocalHelper.getLoginUser();

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

        registerRequest.setUserId(user.getUserId());

        machineManagementService.updateMachine(machineId, registerRequest);

        MachineDetail detail = machineManagementService.getMachineDetailByMachineId(machineId);

        return successResponse("更新成功").setData(detail);
    }

    @RequestMapping("/list/my")
    @ResponseBody
    public Response getMyMachines() {
        LoginUser user = ThreadLocalHelper.getLoginUser();
        List<MachineDto> result = machineManagementService.getRegisteredMachineByUserId(user.getUserId());
        return successResponse().setData(result);
    }

    @RequestMapping("/list/{userId}")
    @ResponseBody
    public Response getMachinesByUserId(@PathVariable long userId) {
        List<MachineDto> result = machineManagementService.getRegisteredMachineByUserId(userId);
        return successResponse().setData(result);
    }

    @RequestMapping("/{machineId}/detail")
    @ResponseBody
    public Response getMachineDetailByMachineId(@PathVariable long machineId) {
        MachineDetail detail = machineManagementService.getMachineDetailByMachineId(machineId);
        return successResponse().setData(detail);
    }

    @RequestMapping(value = "/{machineId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Response deleteMachineByMachineId(@PathVariable long machineId) {
        machineManagementService.deleteMachineByMachineId(machineId);
        return successResponse("删除成功");
    }
}
