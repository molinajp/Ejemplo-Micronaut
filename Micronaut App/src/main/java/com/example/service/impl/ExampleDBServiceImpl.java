package com.example.service.impl;

import com.example.converter.CategoryConverter;
import com.example.dto.category.CategoryDTO;
import com.example.repository.CategoryRepository;
import com.example.service.ExampleDBService;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class ExampleDBServiceImpl implements ExampleDBService {

    private final @NonNull CategoryRepository categoryRepository;
    private final @NonNull CategoryConverter categoryConverter;
    private static final String FAILURE_MESSAGE = "Category not found.";

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        categoryRepository.save(categoryConverter.dtoToEntity(categoryDTO));
        return categoryDTO;
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, FAILURE_MESSAGE));
        return categoryConverter.entityToDto(category);
    }

    @Override
    public CategoryDTO putCategory(Long id, CategoryDTO categoryDTO) {
        var categoryEdit = categoryRepository.findById(id)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, FAILURE_MESSAGE));
        categoryEdit.setName(categoryDTO.getName());
        categoryEdit.setDescription(categoryDTO.getDescription());
        categoryRepository.update(categoryEdit);
        return categoryDTO;
    }

    @Override
    public void deleteCategory(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new HttpStatusException(HttpStatus.NOT_FOUND, FAILURE_MESSAGE));
        categoryRepository.delete(category);
    }
}
