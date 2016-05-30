package cn.edu.hit.nongji.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;

/**
 * @author fangwentong
 * @title CompleteUserInfoRequest
 * @desc 完善用户身份请求
 * @since 2016-05-30 15:40
 */

public class CompleteUserInfoRequest extends AbstractRequest {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private Integer userType;  // 商户类型
    private String idCardNumber; // 证件号码
    private String driverLisence; // 驾驶证
    private String location; // 地址信息
    private Long idCard1; // 身份证正面照

    public Long getIdCard1() {
        return idCard1;
    }

    public CompleteUserInfoRequest setIdCard1(Long idCard1) {
        this.idCard1 = idCard1;
        return this;
    }

    public Long getIdCard2() {
        return idCard2;
    }

    public CompleteUserInfoRequest setIdCard2(Long idCard2) {
        this.idCard2 = idCard2;
        return this;
    }

    public Long getCertificate1() {
        return certificate1;
    }

    public CompleteUserInfoRequest setCertificate1(Long certificate1) {
        this.certificate1 = certificate1;
        return this;
    }

    public Long getCertificate2() {
        return certificate2;
    }

    public CompleteUserInfoRequest setCertificate2(Long certificate2) {
        this.certificate2 = certificate2;
        return this;
    }

    private Long idCard2; // 身份证反面照
    private Long certificate1; //
    private Long certificate2; //

    public Integer getUserType() {
        return userType;
    }

    public CompleteUserInfoRequest setUserType(Integer userType) {
        this.userType = userType;
        return this;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public CompleteUserInfoRequest setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
        return this;
    }

    public String getDriverLisence() {
        return driverLisence;
    }

    public CompleteUserInfoRequest setDriverLisence(String driverLisence) {
        this.driverLisence = driverLisence;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public CompleteUserInfoRequest setLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * 从Json字符串中提取请求对象
     *
     * @param jsonString
     * @return
     * @throws IOException
     */
    public CompleteUserInfoRequest fromJsonString(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, CompleteUserInfoRequest.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
