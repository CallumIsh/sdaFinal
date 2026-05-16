package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice;

import java.util.Objects;

public final class DiceRoll {

  private final int value;

  public DiceRoll(int value) {
    if (value < 1) {
      throw new IllegalArgumentException("Invalid dice roll:" + value);
    }
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiceRoll diceRoll = (DiceRoll) o;
    return value == diceRoll.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.format("%d", value);
  }
}
