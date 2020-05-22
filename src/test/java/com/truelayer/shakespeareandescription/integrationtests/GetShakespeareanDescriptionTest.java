package com.truelayer.shakespeareandescription.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetShakespeareanDescriptionTest {

    @LocalServerPort
    private int port;

    @Test
    void givenServerIsUpCheckUseCaseIntegration() {
        assertEquals(
                new RestTemplate().getForObject("http://localhost:" + port + "/pokemon/charizard", String.class),
                "Charizard flies 'round the sky in search of powerful opponents. It breathes fire of such most wondrous heat."
        );
    }
}
