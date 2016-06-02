package cn.edu.hit.nongji.dao;

import cn.edu.hit.nongji.po.Machine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author fangwentong
 * @title MachineManagementDaoTest
 * @desc unit test for {@link MachineManagementDao}
 * @since 2016-06-02 18:31
 */

public class MachineManagementDaoTest extends DaoTestBase {
    @Autowired
    private MachineManagementDao machineManagementDao;

    @Test
    public void testAddNewMachine() {
        Long userId = 124L;
        Machine machine = new Machine().setUserId(userId);

        assertNull(machine.getId());
        machineManagementDao.addNewMachine(machine);
        assertNotNull(machine.getId());
        Long machineId = machine.getId();
        assertNotNull(machineManagementDao.getMachineDetailByMachineId(machineId));
        assertNotNull(machineManagementDao.getRegisteredMachineByUserId(userId));
        assertTrue(machineManagementDao.getRegisteredMachineByUserId(userId).size() > 0);
        assertTrue(machineManagementDao.deleteMachineByMachineId(machineId) > 0);
        assertNull(machineManagementDao.getMachineDetailByMachineId(machineId));
    }

    @Test
    public void testGetMachineDetailByMachineId() {
        Machine machine = new Machine().setUserId(1L).setDriverLicense(10L);

        machineManagementDao.addNewMachine(machine);
        Long machineId = machine.getId();
        assertNotNull(machineId);

        Machine machineSelected = machineManagementDao.getMachineDetailByMachineId(machineId);
        assertNotNull(machineSelected);
        System.out.println(machineSelected);
        assertNotNull(machineSelected.getUserId());
        assertNotNull(machineSelected.getDriverLicense());
    }
}
