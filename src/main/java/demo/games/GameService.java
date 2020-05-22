package demo.games;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

  public Hand random() {
    final Hand[] candidates = Hand.values();
    return candidates[randomNumber.nextInt( candidates.length )];
  }

  private final Random randomNumber = new Random();
}
