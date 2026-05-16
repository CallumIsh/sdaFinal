package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

import java.util.List;

public class PlayerWonEvent extends GameEvent {

  private final int turns;
  private final int totalTurns;
  private final List<DiceRoll> diceRolls;

  public PlayerWonEvent(Player player, int turns, int totalTurns, List<DiceRoll> diceRolls) {
    super(player);
    this.turns = turns;
    this.totalTurns = totalTurns;
    this.diceRolls = List.copyOf(diceRolls);
  }

  public List<DiceRoll> getDiceRolls() {
    return diceRolls;
  }

  public int getTurns() {
    return turns;
  }

  public int getTotalTurns() {
    return totalTurns;
  }
}
