package demo.games;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

  private final GameService service;

  public GameController( final GameService service ) {
    this.service = service;
  }

  @RequestMapping( "/hand" )
  public @ResponseBody HandResponse hand() {
    final Hand hand = service.random();
    return new HandResponse( hand );
  }
}
