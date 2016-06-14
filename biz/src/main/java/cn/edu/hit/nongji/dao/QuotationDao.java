package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.Quotation;
import org.springframework.stereotype.Repository;

/**
 * @author fangwentong
 * @title QuotationDao
 * @desc 报价数据访问对象接口
 * @since 2016-06-01 12:17
 */

@Repository
public interface QuotationDao {
    int addNewQuotation(Quotation quotation);

    Quotation getQuotationByQuotation(Long quotationId);

}
