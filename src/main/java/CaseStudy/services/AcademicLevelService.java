package CaseStudy.services;

import CaseStudy.models.AcademicLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AcademicLevelService {
    Page<AcademicLevel> findAll(Pageable pageable);
    AcademicLevel findById(Long id);
    void save (AcademicLevel academicLevel);
    void remove (Long id);
}
