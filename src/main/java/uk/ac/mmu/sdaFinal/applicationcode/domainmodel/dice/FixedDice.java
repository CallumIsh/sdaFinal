package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice;

import java.util.List;

public class FixedDice implements DiceShaker {

  private final List<DiceRoll> rolls;
  private int index = 0;

  public FixedDice(List<DiceRoll> rolls) {
    this.rolls = rolls;
  }

  @Override
  public DiceRoll shake() {
    if (index >= rolls.size()) {
      throw new IllegalStateException("No more fixed dice rolls available.");
    }

    return rolls.get(index++);
  }

}
