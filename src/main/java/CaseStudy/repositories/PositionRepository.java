package CaseStudy.repositories;

import CaseStudy.models.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PositionRepository extends PagingAndSortingRepository<Position, Long>  {
    Page<Position> findAllByNameContaining(String name, Pageable pageable);
}
