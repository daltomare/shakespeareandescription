package com.truelayer.shakespeareandescription.adapters;

import com.truelayer.shakespeareandescription.usecases.GetShakespeareanDescriptionUseCase;
import org.springframework.stereotype.Component;

@Component
public class FunTranslationAPIAdapter implements GetShakespeareanDescriptionUseCase.ShakespeareanTranslator {

    @Override
    public String geShakespeareanDescription(String pokemonName) {

        // calls the FunTranslationAPI REST API and compute the response to get the Shakespearean translation

        return "Charizard flies 'round the sky in search of powerful opponents. It breathes fire of such most wondrous heat.";
    }

}
