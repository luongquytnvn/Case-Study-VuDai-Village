package CaseStudy.services.impl;

import CaseStudy.models.Position;
import CaseStudy.repositories.PositionRepository;
import CaseStudy.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PositionServiceImpl implements PositionService {
    @Autowired
    public PositionRepository positionRepository;
    @Override
    public Page<Position> findAll(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public Position findById(Long id) {
      return   positionRepository.findOne(id);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);

    }

    @Override
    public void remove(Long id) {
        positionRepository.delete(id);

    }

    @Override
    public Page<Position> findAllByNameContaining(String name, Pageable pageable) {
        return positionRepository.findAllByNameContaining(name, pageable);
    }
}

  