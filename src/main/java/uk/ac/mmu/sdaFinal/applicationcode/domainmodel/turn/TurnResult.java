package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.turn;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

public class TurnResult {

  private final Player player;
  private final DiceRoll roll;

  private final Position oldPosition;
  private final Position attemptedPosition;
  private final Position finalPosition;

  private final boolean bounced;

  private final boolean teleported;
  private final Position teleportFrom;
  private final Position teleportTo;

  private final boolean hit;
  private final Player hitPlayer;

  private final boolean won;

  private final int turnNumber;

  public TurnResult(
    Player player,
    int turnNumber,
    DiceRoll roll,
    Position oldPosition,
    Position attemptedPosition,
    Position finalPosition,
    boolean bounced,
    boolean teleported,
    Position teleportFrom,
    Position teleportTo,
    boolean hit,
    Player hitPlayer,
    boolean won
  ) {
    this.player = player;
    this.turnNumber = turnNumber;
    this.roll = roll;
    this.oldPosition = oldPosition;
    this.attemptedPosition = attemptedPosition;
    this.finalPosition = finalPosition;
    this.bounced = bounced;
    this.teleported = teleported;
    this.teleportFrom = teleportFrom;
    this.teleportTo = teleportTo;
    this.hit = hit;
    this.hitPlayer = hitPlayer;
    this.won = won;
  }

  public Player getPlayer() {
    return player;
  }

  public int getTurnNumber() {
    return turnNumber;
  }

  public DiceRoll getRoll() {
    return roll;
  }

  public Position getOldPosition() {
    return oldPosition;
  }

  public Position getAttemptedPosition() {
    return attemptedPosition;
  }

  public Position getFinalPosition() {
    return finalPosition;
  }

  public boolean isBounced() {
    return bounced;
  }

  public boolean isTeleported() {
    return teleported;
  }

  public Position getTeleportFrom() {
    return teleportFrom;
  }

  public Position getTeleportTo() {
    return teleportTo;
  }

  public boolean isHit() {
    return hit;
  }

  public Player getHitPlayer() {
    return hitPlayer;
  }

  public boolean hasWon() {
    return won;
  }
}
