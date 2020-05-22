package com.truelayer.shakespeareandescription.adapters;

import com.truelayer.shakespeareandescription.usecases.GetShakespeareanDescriptionUseCase;
import org.springframework.stereotype.Component;

@Component
public class PokeAPIAdapter implements GetShakespeareanDescriptionUseCase.PokemonsRepository {

    @Override
    public String getPokemonDescription(String pokemonName) {

        // calls the Poke REST API and computes the response to get the Pokemon description

        return "Charizard flies around the sky in search of powerful opponents. It breathes fire of such most wondrous heat.";
    }

}
