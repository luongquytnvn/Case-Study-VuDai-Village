package CaseStudy.services.impl;

import CaseStudy.models.AcademicLevel;
import CaseStudy.repositories.AcademicLevelRepository;
import CaseStudy.services.AcademicLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class AcademicLevelServiceImpl implements AcademicLevelService {

    @Autowired
    private AcademicLevelRepository academicLevelRepository;
    @Override
    public Page<AcademicLevel> findAll(Pageable pageable) {
        return academicLevelRepository.findAll(pageable);
    }

    @Override
    public AcademicLevel findById(Long id) {
        return academicLevelRepository.findOne(id);
    }

    @Override
    public void save(AcademicLevel academicLevel) {
        academicLevelRepository.save(academicLevel);
    }

    @Override
    public void remove(Long id) {
        academicLevelRepository.delete(id);
    }
}
