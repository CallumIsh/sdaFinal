package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

public abstract class GameEvent {
  private final Player player;

  protected GameEvent(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }
}