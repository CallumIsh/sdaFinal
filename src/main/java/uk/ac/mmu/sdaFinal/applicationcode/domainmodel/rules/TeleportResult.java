package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class TeleportResult {
  private final Position position;
  private final boolean teleported;
  private final Position from;
  private final Position to;

  public TeleportResult(Position position, boolean teleported, Position from, Position to) {
    this.position = position;
    this.teleported = teleported;
    this.from = from;
    this.to = to;
  }

  public Position getPosition() {
    return position;
  }

  public boolean isTeleported() {
    return teleported;
  }

  public Position getFrom() {
    return from;
  }

  public Position getTo() {
    return to;
  }
}
