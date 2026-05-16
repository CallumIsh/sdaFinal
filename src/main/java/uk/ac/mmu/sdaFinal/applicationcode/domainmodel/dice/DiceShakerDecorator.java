package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice;

public class DiceShakerDecorator implements DiceShaker {
  private final DiceShaker component;
  private final DiceShaker shaker = new RandomSingleDice();

  public DiceShakerDecorator(DiceShaker component) {
    this.component = component;
  }

  @Override
  public DiceRoll shake() {
    int value = shaker.shake().getValue() + component.shake().getValue();

    return new DiceRoll(value);
  }
}
