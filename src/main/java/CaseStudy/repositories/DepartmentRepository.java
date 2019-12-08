package CaseStudy.repositories;

import CaseStudy.models.Department;
import CaseStudy.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
    Page<Department> findAllByDepartmentNameContaining(String name, Pageable pageable);
}
