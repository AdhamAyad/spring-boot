package creative.api.logic;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/get")
public class GetEmployees {
    @GetMapping("/emps/")
    public List<Employee> getEmployees() {
        return List.of(
            new Employee("Mostafa", "Da3er", 1),
            new Employee("Adham", "Da3er", 2),
            new Employee("Adham", "Cloud Fucker",11));       
            
        }
    }