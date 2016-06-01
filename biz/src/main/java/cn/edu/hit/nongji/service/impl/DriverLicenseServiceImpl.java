package cn.edu.hit.nongji.service.impl;

import cn.edu.hit.nongji.po.DriverLicence;
import cn.edu.hit.nongji.service.DriverLicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author fangwentong
 * @title DriverLicenseService
 * @desc 驾照管理服务
 * @since 2016-05-29 18:56
 */

@Service
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private static final Logger logger = LoggerFactory.getLogger(DriverLicenseServiceImpl.class);

    @Override
    public Long addDriverLicense(DriverLicence driverLicence) {
        return null;
    }

    @Override
    public void deleteDriverLicense(Long licenseId) {

    }
}
