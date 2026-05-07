package routing.api.d2;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Employee {

    //@JsonProperty("employee_name")
    private String name;
    private String role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Constructor
    public Employee() {}
    public Employee (String name, String role, int id) {
        this.name = name;
        this.role = role;
        this.id = id;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }
}