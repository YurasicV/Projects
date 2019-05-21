package app.service;

import app.entity.Resolution;
import app.repository.ResolutionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResolutionService {
    private ResolutionRepository resolutionRepository;

    public ResolutionService(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    public Optional<Resolution> findById(Long id) {
        return resolutionRepository.findById(id);
    }

    public void save(Resolution resolution) {
        resolutionRepository.save(resolution);
    }

    public void deleteById(Long id) {
        resolutionRepository.deleteById(id);
    }
}
