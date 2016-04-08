package cn.edu.hit.nongji.dto.response;

import cn.edu.hit.nongji.dto.PageDto;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title Response
 * @date 2016-04-04 23:33
 */

public class Response implements Serializable {
    private int status;
    private Object data;
    private PageDto pageDto;

    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Response setStatus(int status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public PageDto getPageDto() {
        return pageDto;
    }

    public Response setPageDto(PageDto pageDto) {
        this.pageDto = pageDto;
        return this;
    }

    private String msg;
}
