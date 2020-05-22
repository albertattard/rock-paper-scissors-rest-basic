package demo.games;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName( "Game service" )
public class GameServiceTest {

  @Test
  @DisplayName( "should return a random hand with a fair probability" )
  public void shouldReturnARandomHand() {

    final int sampleSize = 1000;
    final int numberOfCandidates = Hand.values().length;

    /* Retrieve a random hand and count the occurrence */
    final GameService service = new GameService();
    final int[] candidateCounts = new int[numberOfCandidates];
    for ( int i = 0; i < sampleSize; i++ ) {
      final Hand hand = service.random();
      candidateCounts[hand.ordinal()]++;
    }

    /* The expected counts for each hand */
    final int expectedCount = sampleSize / numberOfCandidates;
    final int buffer = Math.round( expectedCount * 0.05F );

    /* Verify that each hand has the same probability like any other */
    for ( int i = 0; i < numberOfCandidates; i++ ) {
      assertThat( candidateCounts[i] )
        .isBetween( expectedCount - buffer, expectedCount + buffer );
    }
  }
}
