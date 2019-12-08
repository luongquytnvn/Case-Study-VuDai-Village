package CaseStudy.services;

import CaseStudy.models.Department;
import CaseStudy.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Page<Department> findAll(Pageable pageable);
    Page<Department> findAllByNameContaining(String name, Pageable pageable);
    Department findById(Long id);
    void save(Department department);
    void remove(Long id);
    Boolean isExisted(String name, Pageable pageable);
}
