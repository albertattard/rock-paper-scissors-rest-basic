package demo.games;

import org.springframework.stereotype.Service;

@Service
public class GameService {

  private final RandomService randomService;

  public GameService( final RandomService randomService ) {
    this.randomService = randomService;
  }

  public Hand random() {
    final Hand[] candidates = Hand.values();
    return candidates[randomService.nextInt( candidates.length )];
  }
}
