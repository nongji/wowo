package cn.edu.hit.nongji.util;

import cn.edu.hit.nongji.conf.BizConf;
import cn.edu.hit.nongji.dto.LoginUser;

import java.text.SimpleDateFormat;

/**
 * @author fangwentong
 * @title ThreadLocalHelper
 * @since 2016-06-01 04:28
 */

public final class ThreadLocalHelper {
    private static InheritableThreadLocal<LoginUser> loginUser = new InheritableThreadLocal<>();
    private static InheritableThreadLocal<SimpleDateFormat> dateFormat = new InheritableThreadLocal<>();

    public static LoginUser getLoginUser() {
        return loginUser.get();
    }

    public static void setLoginUser(LoginUser loginUser) {
        ThreadLocalHelper.loginUser.set(loginUser);
    }

    public static SimpleDateFormat getDateFormat() {
        SimpleDateFormat sdf = dateFormat.get();
        if (sdf == null) {
            setDateFormat(new SimpleDateFormat(BizConf.DEFAULT_DATE_TIME_STYLE));
        }
        return dateFormat.get();
    }

    public static void setDateFormat(SimpleDateFormat dateFormat) {
        ThreadLocalHelper.dateFormat.set(dateFormat);
    }
}
