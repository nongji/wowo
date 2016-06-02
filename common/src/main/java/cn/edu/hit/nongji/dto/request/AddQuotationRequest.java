package cn.edu.hit.nongji.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author fangwentong
 * @title AddQuotationRequest
 * @desc 添加报价的请求
 * @since 2016-06-02 17:13
 */

public class AddQuotationRequest extends AbstractRequest {

    @JsonProperty("demand_id")
    private Long demandId; // 需求id
    @JsonProperty("offer_price")
    private Double offerPrice; // 报价
    @JsonProperty("offer_user_id")
    private String offerUserId; // 报价者id
    @JsonProperty("offer_machine_id")
    private Long offerMachineId; // 农机id
    @JsonProperty("offer_timestamp")
    private Long offerTimestamp; // 报价时间

    public Long getDemandId() {
        return demandId;
    }

    public AddQuotationRequest setDemandId(Long demandId) {
        this.demandId = demandId;
        return this;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public AddQuotationRequest setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }

    public String getOfferUserId() {
        return offerUserId;
    }

    public AddQuotationRequest setOfferUserId(String offerUserId) {
        this.offerUserId = offerUserId;
        return this;
    }

    public Long getOfferMachineId() {
        return offerMachineId;
    }

    public AddQuotationRequest setOfferMachineId(Long offerMachineId) {
        this.offerMachineId = offerMachineId;
        return this;
    }

    public Long getOfferTimestamp() {
        return offerTimestamp;
    }

    public AddQuotationRequest setOfferTimestamp(Long offerTimestamp) {
        this.offerTimestamp = offerTimestamp;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
