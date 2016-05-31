package cn.edu.hit.nongji.service;

import cn.edu.hit.nongji.po.DriverLicence;

/**
 * @author fangwentong
 * @title DriverLicenseService
 * @desc 驾照管理服务接口
 * @since 2016-05-29 18:31
 */

public interface DriverLicenseService {
    Long addDriverLicense(DriverLicence driverLicence);

    void deleteDriverLicense(Long licenseId);
}
