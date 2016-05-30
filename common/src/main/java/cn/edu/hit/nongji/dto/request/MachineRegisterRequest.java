package cn.edu.hit.nongji.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;

/**
 * @author fangwentong
 * @title MachineRegisterRequest
 * @desc 农机登记接口
 * @since 2016-05-30 15:04
 */

public class MachineRegisterRequest extends AbstractRequest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private Integer machineType;

    /**
     * 从JSON字符串中提取出农机登记信息
     *
     * @param jsonString
     * @return
     */
    public static MachineRegisterRequest fromJsonString(String jsonString) throws IOException {
        return objectMapper.readValue(jsonString, MachineRegisterRequest.class);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Integer getMachineType() {
        return machineType;
    }

    public MachineRegisterRequest setMachineType(Integer machineType) {
        this.machineType = machineType;
        return this;
    }
}
