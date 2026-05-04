package routing.api.d2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//todo: tell spring that this is a service class and make an object of it to be used in the controller
@Service
public class EmployeeService {
    //? Use arraList to store employees and be able to add and remove employees
    List<Employee> employees = new ArrayList<>(List.of(
        new Employee("Alice", "Developer", 1),
        new Employee("Bob", "Designer", 2),
        new Employee("Charlie", "Manager", 3),
        new Employee("Adham", "Software Engineer", 4),
        new Employee("Mostafa", "Software Engineer", 5),
        new Employee("Peter", "DevOps", 6),
        new Employee("Joo", "DevOps", 7),
        new Employee("Besso", "Sofragy", 8)
    ));

    //? get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }
    //? get employee by id
    public Employee getEmployeeById(int id) {
        for(Employee e : employees) {
            if(e.getId() == id) {
                return e;
            }
        }
        return null; // or throw an exception    
    }

    //? get employees by department
    public List<Employee> getEmployeesByDepartment(String role) {

                // List<Employee> result = employees.stream()
        //     .filter(em -> em.getRole().equalsIgnoreCase(role))
        //     .toList();
        List<Employee> result = new ArrayList<>();
        for(Employee e : employees) {
            if(e.getRole().equalsIgnoreCase(role))
            {
                result.add(e);
            }
        }
        return result;
    }

    //? add employee POST
    public boolean addEmployee(Employee e){
        return employees.stream()
        .anyMatch(em -> em.getId() == e.getId()) ? false : employees.add(e) ? true : false;
    }

    //? remove employee by id DELETE
    public boolean removeEmployeeById(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }
}
