package cn.edu.hit.nongji.dto.response;

import cn.edu.hit.nongji.dto.PageDto;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title Response
 * @desc TODO
 * @date 2016-04-04 23:33
 */

public class Response implements Serializable {
    private int status;
    private Object data;
    private PageDto pageDto;
    private String msg;
}
