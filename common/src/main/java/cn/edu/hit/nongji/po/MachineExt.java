package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title MachineExt
 * @desc 农机详情
 * @since 2016-05-30 16:57
 */

public class MachineExt implements Serializable {
    private Long id;
    private Long machineId;
    private String detail;

    public Long getId() {
        return id;
    }

    public MachineExt setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getMachineId() {
        return machineId;
    }

    public MachineExt setMachineId(Long machineId) {
        this.machineId = machineId;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public MachineExt setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
