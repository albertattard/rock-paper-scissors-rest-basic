package demo.games;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@DisplayName( "Game application" )
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
public class GameApplicationTests {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  @DisplayName( "should return a random hand" )
  public void shouldReturnARandomHand() {
    final var candidates = List.of(
      new HandResponse( Hand.ROCK ),
      new HandResponse( Hand.PAPER ),
      new HandResponse( Hand.SCISSORS )
    );

    assertThat( this.restTemplate.getForObject( "http://localhost:" + port + "/hand", HandResponse.class ) )
      .isIn( candidates );
  }
}
