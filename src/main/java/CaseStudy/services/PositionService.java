package CaseStudy.services;

import CaseStudy.models.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService {
    Page<Position> findAll(Pageable pageable);
    Position findById(Long id);
    void save(Position position);
    void remove(Long id);
    Page<Position> findAllByNameContaining(String name, Pageable pageable);
}
