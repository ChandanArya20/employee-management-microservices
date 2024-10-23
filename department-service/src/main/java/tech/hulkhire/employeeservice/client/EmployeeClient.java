package tech.hulkhire.employeeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.hulkhire.employeeservice.model.Employee;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id);

    @GetMapping("/employees/departments/{id}")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable Long id);
}
