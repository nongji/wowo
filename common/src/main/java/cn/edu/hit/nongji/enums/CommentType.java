package cn.edu.hit.nongji.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangwentong
 * @title CommentType
 * @desc TODO
 * @since 2016-05-30 00:03
 */

public enum CommentType {
    UNKNOWN(0, "未知"),
    USER(1, "用户评论"),
    MACHINE(2, "农机评论"),
    ORDER(3, "订单评论"),
    ;

    int type;
    String desc;

    static Map<Integer, CommentType> commentTypeMap = new HashMap<>();

    static {
        for (CommentType commentType : values()) {
            commentTypeMap.put(commentType.getType(), commentType);
        }
    }

    private CommentType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public CommentType fromType(int type) {

        CommentType result = commentTypeMap.get(type);

        if (result == null) {
            result = UNKNOWN;
        }
        return result;

    }
}
