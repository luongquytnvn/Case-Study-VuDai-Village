package CaseStudy.services.impl;

import CaseStudy.models.LaborContract;
import CaseStudy.repositories.LaborContractRepository;
import CaseStudy.services.LaborContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class LaborContractServiceImpl implements LaborContractService {
    @Autowired
    private LaborContractRepository laborContractRepository;
    @Override
    public Page<LaborContract> findAll(Pageable pageable) {
        return laborContractRepository.findAll(pageable);
    }

    @Override
    public LaborContract findById(Long id) {
        return laborContractRepository.findOne(id);
    }

    @Override
    public void save(LaborContract laborContract) {
        laborContractRepository.save(laborContract);
    }

    @Override
    public void remove(Long id) {
        laborContractRepository.delete(id);

    }

    @Override
    public Page<LaborContract> findAllByNameContaining(String name, Pageable pageable) {
        return laborContractRepository.findAllByNameContaining(name, pageable);
    }
}

  