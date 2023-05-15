package com.example.dto.category;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Introspected
public class CategoryDTO {

    @NotBlank(message = "The category name is mandatory")
    private String name;
    @NotBlank(message = "The category description is mandatory")
    private String description;

}
