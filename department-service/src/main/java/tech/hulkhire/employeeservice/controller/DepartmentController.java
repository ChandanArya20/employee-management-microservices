package tech.hulkhire.employeeservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hulkhire.employeeservice.client.EmployeeClient;
import tech.hulkhire.employeeservice.model.Department;
import tech.hulkhire.employeeservice.model.Employee;
import tech.hulkhire.employeeservice.repository.DepartmentRepository;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department){
        log.info("Department add: {}",department);
        Department savededepartment = repository.addDepartment(department);
        return ResponseEntity.ok(savededepartment);
    }

    @GetMapping
    public List<Department> getAll(){
        log.info("Department findAll");
        return repository.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        log.info("Department find by id: {}",id);
        return repository.getDepartmentById(id);
    }

    @GetMapping("/{id}/with-employees")
    public Department getByIdWithEmployee(@PathVariable Long id){
        log.info("Department find by id: {}",id);

        Department department = repository.getDepartmentById(id);

        List<Employee> employees = employeeClient.getEmployeesByDepartmentId(id);

        department.setEmployees(employees);
        return department;
    }
}
