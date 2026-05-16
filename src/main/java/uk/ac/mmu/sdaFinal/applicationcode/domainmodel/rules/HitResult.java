package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

public class HitResult {
  private final Position finalPosition;
  private final Player hitPlayer;

  public HitResult(Position finalPosition, Player hitPlayer) {
    this.finalPosition = finalPosition;
    this.hitPlayer = hitPlayer;
  }

  public Position getFinalPosition() {
    return finalPosition;
  }

  public Player getHitPlayer() {
    return hitPlayer;
  }

  public boolean isHit() {
    return hitPlayer != null;
  }
}
