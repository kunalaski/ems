package com.example.ems;

import com.example.ems.model.Employee;
import com.example.ems.services.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testCreateReadDelete() {
        Employee employee = new Employee();

        employee.setEmpName("Test");
        employee.setEmpAddress("Mumbai");
        employee.setEmpContact(98787878);
        employee.setEmpEmail("test@gmail.com");
        employee.setEmpRole("E");
        employee.setEmpDepartment("HR");

        employeeService.save(employee);

        Iterable<Employee> friends = employeeService.findAll();
        Assertions.assertThat(friends).extracting(Employee::getEmpName).containsOnly("Testy");

        employeeService.deleteAll();
        Assertions.assertThat(employeeService.findAll()).isEmpty();
    }
}
