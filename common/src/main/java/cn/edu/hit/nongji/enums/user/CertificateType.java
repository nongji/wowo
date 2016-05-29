package cn.edu.hit.nongji.enums.user;

/**
 * @author fangwentong
 * @title CertificateType
 * @desc 证件类型
 * @date 2016-04-28 19:13
 */

public enum CertificateType {
    ID_CARD_FRONT(1, "身份证正面"),
    ID_CARD_END(2, "身份证反面"),;

    int type;
    String desc;

    private CertificateType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }
}
