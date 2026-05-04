package routing.api.d2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/filter")
    public List<Employee> getEmployeesByDepartment(@RequestParam String role) {
        return employeeService.getEmployeesByDepartment(role);
    }

    @PostMapping("/add")
    public boolean addEmployee(@RequestBody Employee e) {
        return employeeService.addEmployee(e);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removeEmployeeById(@PathVariable int id) {
        return employeeService.removeEmployeeById(id);
    }
}