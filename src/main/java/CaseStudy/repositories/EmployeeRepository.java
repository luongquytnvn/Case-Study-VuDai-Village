package CaseStudy.repositories;

import CaseStudy.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee> findAllByNameContaining(String name,Pageable pageable);
    Page<Employee> findAllByAcademicLevel_Id(Long id,Pageable pageable);
    Page<Employee> findAllByDepartment_Id(Long id,Pageable pageable);
    Page<Employee> findAllByLaborContract_Id(Long id,Pageable pageable);
    Page<Employee> findAllByPosition_Id(Long id,Pageable pageable);
}
