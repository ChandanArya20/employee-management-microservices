package tech.hulkhire.employeeservice.repository;

import org.springframework.stereotype.Repository;
import tech.hulkhire.employeeservice.model.Department;
import tech.hulkhire.employeeservice.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees(){
        return  employees;
    }

    public Employee getEmployeeById(Long id){
        return employees.stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public Employee getEmployeeByDepartmentId(Long departmentId){
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId){
        return employees.stream()
                .filter(employee -> employee.departmentId().equals(departmentId))
                .toList();
    }

}
