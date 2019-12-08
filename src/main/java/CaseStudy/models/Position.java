package CaseStudy.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=2, max=50)
    private String name;
    @OneToMany
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Position(){

    }
    public Position(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
