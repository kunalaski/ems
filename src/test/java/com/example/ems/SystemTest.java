package com.example.ems;

import com.example.ems.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SystemTest {

    @Test
    public void testCreateReadDelete() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/ems/employee";

        Employee employee = new Employee();

        employee.setEmpName("Test");
        employee.setEmpAddress("Mumbai");
        employee.setEmpContact(98787878);
        employee.setEmpEmail("test@gmail.com");
        employee.setEmpRole("E");
        employee.setEmpDepartment("HR");

        ResponseEntity<Employee> entity = restTemplate.postForEntity(url, employee, Employee.class);

//			expects an array of list with a friend with first name gordon
        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
        Assertions.assertThat(employees).extracting(Employee::getEmpName).containsOnly("Test");

        restTemplate.delete(url + "/" + entity.getBody().getEmpID());
        Assertions.assertThat(restTemplate.getForObject(url, Employee[].class)).isEmpty();
    }

    @Test
    public void testErrorHandlingReturnsBadRequest() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/ems/wrong";

        try {
            restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }

}
