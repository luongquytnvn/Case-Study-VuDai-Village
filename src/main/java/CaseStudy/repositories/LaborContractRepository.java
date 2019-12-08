package CaseStudy.repositories;

import CaseStudy.models.LaborContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LaborContractRepository extends PagingAndSortingRepository<LaborContract, Long> {
    Page<LaborContract> findAllByNameContaining(String name, Pageable pageable);
    Page<LaborContract> findAllByName(String name, Pageable pageable);

}
