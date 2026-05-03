package creative.api.logic;

// import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    //@JsonProperty("employee_name")
    private String name;
    private String role;
    private int id;

    // Constructor
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