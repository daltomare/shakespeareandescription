package com.truelayer.shakespeareandescription.unittests;

import com.truelayer.shakespeareandescription.usecases.GetShakespeareanDescriptionUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class GetShakespeareanDescriptionTest {

    @Test
    void givenAPokemonNameReturnPokemonShakespeareanDescription() {

        var pokemonsDatabase = new Mocks.PokemonsDatabase();
        var shakespeareanTranslator = new Mocks.ShakespeareanTranslator();

        var useCase = new GetShakespeareanDescriptionUseCase(pokemonsDatabase, shakespeareanTranslator);
        var shakespeareanDescription = useCase.execute("charizard");

        assertTrue(pokemonsDatabase.getDescriptionWasCalled);
        assertTrue(shakespeareanTranslator.geShakespeareanTranslationWasCalled);

        assertEquals(shakespeareanDescription, "Charizard flies 'round the sky in search of powerful opponents. 't breathes fire of such most wondrous heat.");
    }


    static class Mocks {

        static class PokemonsDatabase implements GetShakespeareanDescriptionUseCase.PokemonsRepository {

            boolean getDescriptionWasCalled = false;

            @Override
            public String getPokemonDescription(String pokemonName) {

                getDescriptionWasCalled = true;
                return "Charizard flies around the sky in search of powerful opponents. It breathes fire of such most wondrous heat.";
            }
        }

        static class ShakespeareanTranslator implements GetShakespeareanDescriptionUseCase.ShakespeareanTranslator {

            boolean geShakespeareanTranslationWasCalled = false;

            @Override
            public String geShakespeareanDescription(String pokemonName) {

                geShakespeareanTranslationWasCalled = true;
                return "Charizard flies 'round the sky in search of powerful opponents. 't breathes fire of such most wondrous heat.";
            }

        }
    }
}
