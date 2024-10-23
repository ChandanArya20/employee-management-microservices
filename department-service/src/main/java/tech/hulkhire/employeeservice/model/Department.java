package tech.hulkhire.employeeservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees;

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
