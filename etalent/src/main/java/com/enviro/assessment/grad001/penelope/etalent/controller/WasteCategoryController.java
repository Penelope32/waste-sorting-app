package com.enviro.assessment.grad001.penelope.etalent.controller;

import com.enviro.assessment.grad001.penelope.etalent.model.WasteCategory;
import com.enviro.assessment.grad001.penelope.etalent.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @PostMapping
    public WasteCategory createCategory(@Valid @RequestBody WasteCategory category) {
        return service.saveCategory(category);
    }

    @PutMapping("/{id}")
    public WasteCategory updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }
}
