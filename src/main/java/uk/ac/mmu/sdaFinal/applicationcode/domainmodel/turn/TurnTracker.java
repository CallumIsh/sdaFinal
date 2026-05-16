package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.turn;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

import java.util.HashMap;
import java.util.Map;

public class TurnTracker {
  private int totalTurns = 0;
  private final Map<Player, Integer> playerTurns = new HashMap<>();

  public void recordTurn(Player player) {
    totalTurns++;
    playerTurns.put(player, playerTurns.getOrDefault(player, 0) + 1);
  }

  public int getPlayerTurns(Player player) {
    return playerTurns.getOrDefault(player, 0);
  }

  public int getTotalTurns() {
    return totalTurns;
  }
}
