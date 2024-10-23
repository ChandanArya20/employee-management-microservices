package tech.hulkhire.employeeservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hulkhire.employeeservice.model.Department;
import tech.hulkhire.employeeservice.model.Employee;
import tech.hulkhire.employeeservice.repository.EmployeeRepository;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
        log.info("Employee add: {}",employee);
        Employee savedeEmployee = repository.addEmployee(employee);
        return ResponseEntity.ok(savedeEmployee);
    }

    @GetMapping
    public List<Employee> getAll(){
        log.info("Employee findAll");
        return repository.getAllEmployees();
    }

    @GetMapping("/departments/{id}")
    public List<Employee> getAllByDepartmentId(@PathVariable Long id){
        log.info("Employee findAll by department id");
        return repository.getEmployeesByDepartmentId(id);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        log.info("Employee find by id: {}",id);
        return repository.getEmployeeById(id);
    }
}
