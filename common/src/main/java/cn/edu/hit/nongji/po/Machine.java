package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title Machine
 * @desc 农机信息
 * @since 2016-05-30 16:57
 */

public class Machine implements Serializable {


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
