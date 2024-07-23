package com.enviro.assessment.grad001.penelope.etalent.controller;

import com.enviro.assessment.grad001.penelope.etalent.model.RecyclingTip;
import com.enviro.assessment.grad001.penelope.etalent.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService service;

    @GetMapping
    public List<RecyclingTip> getAllTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public Optional<RecyclingTip> getTipById(@PathVariable Long id) {
        return service.getTipById(id);
    }

    @PostMapping
    public RecyclingTip createTip(@Valid @RequestBody RecyclingTip tip) {
        return service.saveTip(tip);
    }

    @PutMapping("/{id}")
    public RecyclingTip updateTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip tip) {
        return service.updateTip(id, tip);
    }

    @DeleteMapping("/{id}")
    public void deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
    }
}