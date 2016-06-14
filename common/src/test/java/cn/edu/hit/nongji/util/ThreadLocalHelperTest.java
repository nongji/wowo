package cn.edu.hit.nongji.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertNotNull;

public class ThreadLocalHelperTest {
    @Test
    public void testGetTimeStamp() throws ParseException {
        SimpleDateFormat sdf = ThreadLocalHelper.getDateFormat();
        assertNotNull(sdf);

        assertNotNull(sdf.parse("2016-01-01 00:00:00"));
    }
}
