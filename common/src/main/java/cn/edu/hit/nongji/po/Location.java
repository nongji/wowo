package cn.edu.hit.nongji.po;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title Location
 * @desc 位置信息
 * @since 2016-05-30 16:58
 */

public class Location implements Serializable {

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
