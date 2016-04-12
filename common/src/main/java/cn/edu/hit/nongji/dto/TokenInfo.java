package cn.edu.hit.nongji.dto;

import java.io.Serializable;

/**
 * @author fangwentong
 * @title TokenInfo
 * @desc Token 信息
 * @date 2016-04-12 14:46
 */

public class TokenInfo implements Serializable {
    private String token;
    private Integer expiresIn;

    public TokenInfo() {
        this(null);
    }

    public TokenInfo(String token) {
        this(token, 0);
    }

    public TokenInfo(String token, Integer expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public TokenInfo setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getToken() {
        return token;
    }

    public TokenInfo setToken(String token) {
        this.token = token;
        return this;
    }

}
