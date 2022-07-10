package com.example.ems;

import com.example.ems.controllers.EmployeeController;
import com.example.ems.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {
    @Autowired
    EmployeeController employeeController;

    @Test
    public void testCreateReadDelete() {
        Employee employee = new Employee();

        employee.setEmpName("Test");
        employee.setEmpAddress("Mumbai");
        employee.setEmpContact(98787878);
        employee.setEmpEmail("test@gmail.com");
        employee.setEmpRole("E");
        employee.setEmpDepartment("HR");

        Employee employeeResult = employeeController.create(employee);

        Iterable<Employee> friends = employeeController.read();
        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("empName", "Test");

        employeeController.delete(employeeResult.getEmpID());
        Assertions.assertThat(employeeController.read()).isEmpty();

    }

    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown() {
        employeeController.somethingIsWrong();

    }
}
