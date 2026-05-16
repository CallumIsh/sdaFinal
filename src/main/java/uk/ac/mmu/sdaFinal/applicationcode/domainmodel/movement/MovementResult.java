package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class MovementResult {
  private final Position position;
  private final boolean bounced;

  public MovementResult(Position position, boolean bounced) {
    this.position = position;
    this.bounced = bounced;
  }

  public Position getPosition() {
    return position;
  }

  public boolean isBounced() {
    return bounced;
  }
}
