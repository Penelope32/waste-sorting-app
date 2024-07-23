package com.enviro.assessment.grad001.penelope.etalent.service;

import com.enviro.assessment.grad001.penelope.etalent.model.RecyclingTip;
import com.enviro.assessment.grad001.penelope.etalent.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {
    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> getTipById(Long id) {
        return repository.findById(id);
    }

    public RecyclingTip saveTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    public RecyclingTip updateTip(Long id, RecyclingTip tip) {
        return repository.findById(id).map(existingTip -> {
            existingTip.setTip(tip.getTip());
            return repository.save(existingTip);
        }).orElseGet(() -> {
            tip.setId(id);
            return repository.save(tip);
        });
    }

    public void deleteTip(Long id) {
        repository.deleteById(id);
    }
}