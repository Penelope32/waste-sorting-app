package com.enviro.assessment.grad001.penelope.etalent.service;

import com.enviro.assessment.grad001.penelope.etalent.model.DisposalGuideline;
import com.enviro.assessment.grad001.penelope.etalent.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {
    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public Optional<DisposalGuideline> getGuidelineById(Long id) {
        return repository.findById(id);
    }

    public DisposalGuideline saveGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public DisposalGuideline updateGuideline(Long id, DisposalGuideline guideline) {
        return repository.findById(id).map(existingGuideline -> {
            existingGuideline.setGuideline(guideline.getGuideline());
            return repository.save(existingGuideline);
        }).orElseGet(() -> {
            guideline.setId(id);
            return repository.save(guideline);
        });
    }

    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }
}
