package com.example.controller;

import com.example.dto.pet.PetDTO;
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

@Tag(name = "ExampleFeign")
public interface ExampleRestClientController {
    @Get("/pets/{petId}")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = PetDTO.class))))
    PetDTO getPet(Long petId);

    @Post("/pets")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = PetDTO.class))))
    PetDTO createPet(PetDTO petDTO);

    @Delete("/pets/{petId}")
    @ApiResponses(value = @ApiResponse(responseCode = "202", description = "OK"))
    String deletePet(Long petId);

    @Put("/pets")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = PetDTO.class))))
    PetDTO editPet(PetDTO petDTO);
}
