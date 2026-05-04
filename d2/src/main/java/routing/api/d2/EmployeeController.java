package routing.api.d2;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        if(allEmployees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getEmployeesByDepartment(@RequestParam String role) {
        List<Employee> Filterdemployees = employeeService.getEmployeesByDepartment(role);
        if(Filterdemployees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees found in this department");
        }
        return ResponseEntity.status(HttpStatus.OK).body(Filterdemployees);   
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee e) {
        return employeeService.addEmployee(e) 
        ? ResponseEntity.status(HttpStatus.CREATED).body("Employee Created Successfully")
        : ResponseEntity.status(HttpStatus.CONFLICT).body("Employee with this ID already exists");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeEmployeeById(@PathVariable int id){
        return employeeService.removeEmployeeById(id) 
        ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
        : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}