package com.truelayer.shakespeareandescription.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetShakespeareanDescriptionUseCase {

    public interface PokemonsRepository {
        String getPokemonDescription(String pokemonName);
    }

    public interface ShakespeareanTranslator {
        String geShakespeareanDescription(String pokemonName);
    }

    private final PokemonsRepository pokemonsRepository;
    private final ShakespeareanTranslator shakespeareanTranslator;

    @Autowired
    public GetShakespeareanDescriptionUseCase(
            PokemonsRepository pokemonsRepository,
            ShakespeareanTranslator shakespeareanTranslator) {

        this.pokemonsRepository = pokemonsRepository;
        this.shakespeareanTranslator = shakespeareanTranslator;
    }

    public String execute(String pokemonName) {

        var pokemonDescription = pokemonsRepository.getPokemonDescription(pokemonName);
        var shakespeareanDescription = shakespeareanTranslator.geShakespeareanDescription(pokemonDescription);

        return shakespeareanDescription;
    }

}
