package routing.api.d2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import routing.api.d2.Employee;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    List<Employee> employees = List.of(
        new Employee("Alice", "Developer", 1),
        new Employee("Bob", "Designer", 2),
        new Employee("Charlie", "Manager", 3),
        new Employee("Adham", "Software Engineer", 4),
        new Employee("Mostafa", "Software Engineer", 5),
        new Employee("Peter", "DevOps", 6),
        new Employee("Joo", "DevOps", 7)
    );

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for(Employee e : employees) {
            if(e.getId() == id) {
                return e;
            }
        }
        return null; // or throw an exception    
    }

    @GetMapping("/filter")
    public List<Employee> getEmployeesByDepartment(@RequestParam String role) {
        List<Employee> result = new ArrayList<>();
        for(Employee e : employees) {
            if(e.getRole().equalsIgnoreCase(role))
            {
                result.add(e);
            }
        }
        return result;
    }
}