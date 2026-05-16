package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice;

import java.util.Random;

public class RandomSingleDice implements DiceShaker {
  private final Random random = new Random();

  @Override
  public DiceRoll shake() {
    return new DiceRoll(random.nextInt(6) + 1);
  }
}
