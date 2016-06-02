package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.file.FilePath;
import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.service.AssetManagementService;
import cn.edu.hit.nongji.service.FileSaveService;
import cn.edu.hit.nongji.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author fangwentong
 * @title AssetController
 * @desc 静态文件管理接口
 * @since 2016-06-02 16:37
 */

@Controller
@RequestMapping("/asset")
public class AssetController extends AbstractCommonController {
    @Autowired
    @Qualifier("qiNiuFileSaveServiceImpl")
    private FileSaveService fileSaveService;
    @Autowired
    private AssetManagementService assetManagementService;

    @RequestMapping("/upload")
    @ResponseBody
    public Response uploadAssetFile(@RequestParam("file") MultipartFile file) {
        File tmpFile = null;
        String path = null;
        try {
            tmpFile = convertMultiPartFileToFile(file);
            FilePath filePath = fileSaveService.save(tmpFile, FileUtil.getRandomPah(file.getOriginalFilename()));
            assetManagementService.addNewAsset(filePath);

            return successResponse().setData(filePath.getFullPath());
        } catch (IOException e) {
            return internalServerError("Error while save file");
        }
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Response getFileUrl(@PathVariable long id) {
        return successResponse().setData(assetManagementService.getAssetByAssetId(id));
    }

}
