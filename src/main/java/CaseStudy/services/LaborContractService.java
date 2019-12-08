package CaseStudy.services;

import CaseStudy.models.LaborContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LaborContractService {
    Page<LaborContract> findAll(Pageable pageable);
    LaborContract findById(Long id);
    void save(LaborContract laborContract);
    void remove(Long id);
    Page<LaborContract> findAllByNameContaining(String name, Pageable pageable);

}
