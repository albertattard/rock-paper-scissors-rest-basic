package demo.games;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* Just load the following controller and all it needs */
@WebMvcTest( GameController.class )
@DisplayName( "Rock controller" )
public class GameControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GameService service;

  @Test
  @DisplayName( "should return the hand provided by the service" )
  public void shouldReturnTheHandProvidedByTheService() throws Exception {
    final Hand hand = Hand.PAPER;
    when( service.random() ).thenReturn( hand );

    mockMvc.perform( get( "/hand" ) )
      .andDo( print() )
      .andExpect( status().isOk() )
      .andExpect( jsonPath( "$.hand", is( hand.name() ) ) );

    verify( service, times( 1 ) ).random();
  }
}
