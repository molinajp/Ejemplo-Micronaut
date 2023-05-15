package com.example.controller.impl;

import com.example.controller.ExampleRestClientController;
import com.example.dto.pet.PetDTO;
import com.example.service.ExampleRestClientService;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Controller
@RequiredArgsConstructor
public class ExampleRestClientControllerImpl implements ExampleRestClientController {

    private final @NonNull ExampleRestClientService exampleRestService;

    @Status(HttpStatus.OK)
    @Override
    public PetDTO getPet(@PathVariable(name = "petId") @NotBlank Long petId) {
        return exampleRestService.getPet(petId);
    }

    @Status(HttpStatus.CREATED)
    @Override
    public PetDTO createPet(@Body @NotNull PetDTO petDTO) {
        return exampleRestService.createPet(petDTO);
    }

    @Status(HttpStatus.OK)
    @Override
    public String deletePet(@PathVariable(name = "petId") Long petId) {
        return exampleRestService.deletePet(petId);
    }

    @Status(HttpStatus.OK)
    @Override
    public PetDTO editPet(@Body PetDTO petDTO) {
        return exampleRestService.editPet(petDTO);
    }

}
