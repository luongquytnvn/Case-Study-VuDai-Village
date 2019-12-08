package CaseStudy.repositories;

import CaseStudy.models.AcademicLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AcademicLevelRepository extends PagingAndSortingRepository<AcademicLevel, Long> {
    Page<AcademicLevel> findAllByNameLevel(String name, Pageable pageable);
}
