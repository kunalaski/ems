package com.example.ems;

import com.example.ems.controllers.EmployeeController;
import com.example.ems.controllers.LoginController;
import com.example.ems.controllers.TimesheetController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmsApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Test
	void contextLoads() {
		Assert.assertNotNull(employeeController);
	}

}
