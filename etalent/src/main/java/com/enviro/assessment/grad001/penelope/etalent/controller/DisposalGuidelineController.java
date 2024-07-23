package com.enviro.assessment.grad001.penelope.etalent.controller;

import com.enviro.assessment.grad001.penelope.etalent.model.DisposalGuideline;
import com.enviro.assessment.grad001.penelope.etalent.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {
    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuideline> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public Optional<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return service.getGuidelineById(id);
    }

    @PostMapping
    public DisposalGuideline createGuideline(@Valid @RequestBody DisposalGuideline guideline) {
        return service.saveGuideline(guideline);
    }

    @PutMapping("/{id}")
    public DisposalGuideline updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline guideline) {
        return service.updateGuideline(id, guideline);
    }

    @DeleteMapping("/{id}")
    public void deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
    }
}