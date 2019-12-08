package CaseStudy.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "levels")
public class AcademicLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String nameLevel;
    @NotEmpty
    private String specialized;
    @OneToMany
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public AcademicLevel() {
    }

    public AcademicLevel(String nameLevel, String specialized) {
        this.nameLevel = nameLevel;
        this.specialized = specialized;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }
}
