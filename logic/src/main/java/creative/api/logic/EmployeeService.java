package creative.api.logic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employee")
public class EmployeeService {

    List<Employee> employees = List.of(
            new Employee("Mostafa", "Da3er", 1),
            new Employee("Adham", "Da3er", 2),
            new Employee("Adham", "Cloud Fucker",11));

    @GetMapping()
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public Employee getEmployeeById(int id) {
        // In a real application, this would fetch data from a database
        if (id == 1) {
            return new Employee("Mostafa", "Da3er", 1);
        } else if (id == 2) {
            return new Employee("Adham", "Da3er", 2);
        } else if (id == 11) {
            return new Employee("Adham", "Cloud Fucker", 11);
        } else {
            return null; // or throw an exception
        }
    }
}
