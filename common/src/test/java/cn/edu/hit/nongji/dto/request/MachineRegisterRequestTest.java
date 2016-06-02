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
        String jsonString = "{\"user_type\":\" 1\"}";

        System.out.println(MachineRegisterRequest.fromJsonString(jsonString));
        jsonString = "{\"drive_type\":\"1\",\"driver_name\":\"网易\",\"driver_age\":\"20\",\"driver_gender\":\"2\",\"driver_license_type\":\"K驾照\",\"machine_type\":\"耕整地\",\"machine_name\":\"人型大炮\",\"machine_power\":\"1000\",\"passenger_num\":\"20\",\"machine_wheeldistance\":\"50\",\"machine_checktime\":\"20\",\"machine_paytype\":\"2\",\"machine_powertype\":\"2\",\"lease_month\":\"10\",\"lease_time\":\"5\",\"work_condition\":\"农场主负责伙食\",\"need_type\":\"1\",\"house_type\":\"2\"}";
        System.out.println(MachineRegisterRequest.fromJsonString(jsonString));
    }
}
