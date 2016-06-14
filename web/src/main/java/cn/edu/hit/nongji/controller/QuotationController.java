package cn.edu.hit.nongji.controller;

import cn.edu.hit.nongji.dto.response.Response;
import cn.edu.hit.nongji.po.Quotation;
import cn.edu.hit.nongji.service.QuotationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author fangwentong
 * @title QuotationController
 * @desc 报价控制器类
 * @since 2016-06-01 12:14
 */
@Controller
@RequestMapping("/quotation")
public class QuotationController extends AbstractCommonController {
    @Autowired
    private QuotationService quotationService;
    private static final Logger logger = LoggerFactory.getLogger(QuotationController.class);

    @RequestMapping("add")
    @ResponseBody
    public Response addNewQuotation() {
        return successResponse();
    }

    @RequestMapping("/list/{demandId}")
    @ResponseBody
    public Response getQuotationsByDemandId(@PathVariable long demandId) {
        List<Quotation> result = null;
        return successResponse().setData(result);
    }
}
