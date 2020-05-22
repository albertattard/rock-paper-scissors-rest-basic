package demo.games;

import java.util.Objects;

public class HandResponse {

  private Hand hand;

  public HandResponse() {
  }

  public HandResponse( final Hand hand ) {
    this.hand = hand;
  }

  public Hand getHand() {
    return hand;
  }

  @Override
  public boolean equals( final Object object ) {
    if ( this == object ) {
      return true;
    }

    if ( !( object instanceof HandResponse ) ) {
      return false;
    }

    final HandResponse that = (HandResponse) object;
    return hand == that.hand;
  }

  @Override
  public int hashCode() {
    return Objects.hash( hand );
  }

  @Override
  public String toString() {
    return String.format( "HandResponse{hand=%s}", hand );
  }
}
