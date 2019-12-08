package CaseStudy.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private Boolean gender;
    @NotEmpty
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth = LocalDate.now();
    private String phoneNumber;
    private String salary;
    @NotEmpty
    private String image;

    @ManyToOne
    private Department department;
    @ManyToOne
    private AcademicLevel academicLevel;
    @ManyToOne
    private Position position;
    @ManyToOne
    private LaborContract laborContract;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LaborContract getLaborContract() {
        return laborContract;
    }

    public void setLaborContract(LaborContract laborContract) {
        this.laborContract = laborContract;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
