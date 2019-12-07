package CaseStudy.services;

import CaseStudy.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Long id);
    void save(Employee employee);
    void delete(Long id);
    public List<Employee> findByName(String search, Pageable pageable);
}
