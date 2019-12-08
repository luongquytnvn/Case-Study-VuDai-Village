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
    Page<Employee> findAllByNameContaining(String name,Pageable pageable);
    Page<Employee> findAllByAcademicLevel_Id(Long id,Pageable pageable);
    Page<Employee> findAllByDepartment_Id(Long id,Pageable pageable);
    Page<Employee> findAllByLaborContract_Id(Long id,Pageable pageable);
    Page<Employee> findAllByPosition_Id(Long id,Pageable pageable);
}
