package com.example.controller;

import com.example.dto.category.CategoryDTO;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ExampleDB")
public interface ExampleDBController {

    @Post("/categories")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class))))
    CategoryDTO createCategoryController(CategoryDTO categoryDTO);

    @Delete("/categories/{id}")
    @ApiResponses(value = @ApiResponse(responseCode = "202", description = "OK"))
    Long deleteCategoryController(Long id);

    @Get("/categories/{id}")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class))))
    CategoryDTO getCategoryController(Long id);

    @Put("/categories/{id}")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = CategoryDTO.class))))
    CategoryDTO editCategoryController(CategoryDTO categoryEntity, Long id);

}
