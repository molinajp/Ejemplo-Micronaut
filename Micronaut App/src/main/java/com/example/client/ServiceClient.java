package com.example.client;

import com.example.dto.pet.PetDTO;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${petStore.url}")
public interface ServiceClient {

    @Get("/pet/{petId}")
    PetDTO getPet(@QueryValue Long petId);

    @Post("/pet/")
    PetDTO addPet(@Body PetDTO petDTO);

    @Put("/pet/")
    PetDTO editPet(@Body PetDTO petDTO);

    @Delete("/pet/{petId}")
    String deletePet(@QueryValue Long petId);

}
