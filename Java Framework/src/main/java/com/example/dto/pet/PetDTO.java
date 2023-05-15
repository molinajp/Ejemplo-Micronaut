package com.example.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDTO {

    private Long id;
    private CategoryDTO category;
    private String name;
    private List<String> photoUrls;
    private List<TagsDTO> tags;
    private String status;

}
