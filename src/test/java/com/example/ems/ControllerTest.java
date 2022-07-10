package com.example.ems;

import com.example.ems.controllers.EmployeeController;
import com.example.ems.model.Employee;
import com.example.ems.services.EmployeeService;
import com.example.ems.services.LoginService;
import com.example.ems.services.TimesheetService;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class ControllerTest {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testEmployeePost() throws Exception {
        Employee employee = new Employee();
        employee.setEmpName("Test1");
        employee.setEmpAddress("Mumbai");
        employee.setEmpContact(98787878);
        employee.setEmpEmail("test@gmail.com");
        employee.setEmpRole("E");
        employee.setEmpDepartment("HR");

        List<Employee> employees = Arrays.asList(employee);

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].empName", Matchers.is("Test1")));

    }

    @Test
    public void testEmployeeGet() throws Exception {
        Employee employee = new Employee();
        employee.setEmpName("Test1");
        employee.setEmpAddress("Mumbai");
        employee.setEmpContact(98787878);
        employee.setEmpEmail("test@gmail.com");
        employee.setEmpRole("E");
        employee.setEmpDepartment("HR");

        List<Employee> employees = Arrays.asList(employee);

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].empID", Matchers.is(0)));

    }

    @Test
    public void testEmployeePut() throws Exception {

        Employee employee = new Employee();
        employee.setEmpID(1);
        employee.setEmpName("UpdatedTest1");
        employee.setEmpAddress("Navi Mumbai");
        employee.setEmpContact(98787878);
        employee.setEmpEmail("Updatedtest@gmail.com");
        employee.setEmpRole("E");
        employee.setEmpDepartment("ASDE");

        List<Employee> employees = Arrays.asList(employee);

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].empName", Matchers.is("UpdatedTest1")));

    }

    @Test
    public void testEmployeeDelete() throws Exception {
        employeeService.deleteAll();
        Assertions.assertThat(employeeService.findAll()).isEmpty();
    }

}
