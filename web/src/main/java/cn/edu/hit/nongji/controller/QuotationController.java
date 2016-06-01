package cn.edu.hit.nongji.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fangwentong
 * @title QuotationController
 * @desc 报价控制器类
 * @since 2016-06-01 12:14
 */
@Controller
@RequestMapping("/quotation")
public class QuotationController extends AbstractCommonController {
    private static final Logger logger = LoggerFactory.getLogger(QuotationController.class);
}
