package CaseStudy.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class LaborContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3,max = 100)
    private String name;
    @OneToMany
    private List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public LaborContract(){
    }
    public LaborContract(Long id, String name){
        this.id=id;
        this.name=name;
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
