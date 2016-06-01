package cn.edu.hit.nongji.dto.request;

import org.junit.Test;

import java.io.IOException;

/**
 * @author fangwentong
 * @title MachineRegisterRequestTest
 * @desc Tests for {@link MachineRegisterRequest }
 * @since 2016-06-01 15:40
 */

public class MachineRegisterRequestTest {
    @Test
    public void testReadFromJsonStrng() throws IOException {
        String jsonString = "{\"user_type\":\"1\"}";

        System.out.println(MachineRegisterRequest.fromJsonString(jsonString));
    }
}
