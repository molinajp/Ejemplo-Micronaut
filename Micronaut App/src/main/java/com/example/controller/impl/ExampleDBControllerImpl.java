package com.example.controller.impl;

import com.example.controller.ExampleDBController;
import com.example.dto.category.CategoryDTO;
import com.example.service.ExampleDBService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Controller
@RequiredArgsConstructor
public class ExampleDBControllerImpl implements ExampleDBController {

    private final @NonNull ExampleDBService exampleDBService;

    @Status(HttpStatus.CREATED)
    @Override
    public CategoryDTO createCategoryController(@Body @Valid CategoryDTO categoryDTO) {
        return exampleDBService.addCategory(categoryDTO);
    }

    @Status(HttpStatus.NO_CONTENT)
    @Override
    public Long deleteCategoryController(@PathVariable @NotBlank Long id) {
        exampleDBService.deleteCategory(id);
        return id;
    }

    @Status(HttpStatus.OK)
    @Override
    public CategoryDTO getCategoryController(@PathVariable @NotBlank Long id) {
        return exampleDBService.getCategory(id);
    }

    @Status(HttpStatus.OK)
    @Override
    public CategoryDTO editCategoryController(@Body @Valid CategoryDTO categoryEntity,
            @PathVariable @NotBlank Long id) {
        return exampleDBService.putCategory(id, categoryEntity);
    }

}
