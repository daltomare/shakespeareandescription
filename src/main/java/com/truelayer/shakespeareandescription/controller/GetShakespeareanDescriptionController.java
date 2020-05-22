package com.truelayer.shakespeareandescription.controller;

import com.truelayer.shakespeareandescription.usecases.GetShakespeareanDescriptionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetShakespeareanDescriptionController {

    private final GetShakespeareanDescriptionUseCase useCase;

    @Autowired
    public GetShakespeareanDescriptionController(GetShakespeareanDescriptionUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/pokemon/{pokemonName}")
    public String getShakespeareanDescription(@PathVariable String pokemonName) {
        return useCase.execute(pokemonName);
    }
}
