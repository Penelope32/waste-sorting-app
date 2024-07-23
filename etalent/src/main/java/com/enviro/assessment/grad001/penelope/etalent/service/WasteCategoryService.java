package com.enviro.assessment.grad001.penelope.etalent.service;

import com.enviro.assessment.grad001.penelope.etalent.model.WasteCategory;
import com.enviro.assessment.grad001.penelope.etalent.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {
    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public Optional<WasteCategory> getCategoryById(Long id) {
        return repository.findById(id);
    }

    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(Long id, WasteCategory category) {
        return repository.findById(id).map(existingCategory -> {
            existingCategory.setName(category.getName());
            return repository.save(existingCategory);
        }).orElseGet(() -> {
            category.setId(id);
            return repository.save(category);
        });
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
