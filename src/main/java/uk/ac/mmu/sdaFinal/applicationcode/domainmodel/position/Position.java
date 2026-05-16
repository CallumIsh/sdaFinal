package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position;

import java.util.Objects;

public final class Position {

  public static final Position ONE = new Position(1);
  public static final Position SIX = new Position(6);
  public static final Position TWENTY_FIVE = new Position(25);
  public static final Position THIRTY_ONE = new Position(31);
  public static final Position THIRTY_SIX = new Position(36);

  private final int value;

  public Position(int value) {
    if (value < 1) {
      throw new IllegalArgumentException("Position must be >=1");
    }
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
   if (this == o) {
     return true;
   }
   if (o == null || getClass() != o.getClass()) {
     return false;
   }
   Position position  = (Position) o;
   return value == position.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return String.format("%d", value);
  }

  public boolean isGreaterThanOrEqual(Position other) {
    return value >= other.value;
  }

  public boolean isLessThanOrEqual(Position other) {
    return value <= other.value;
  }

  public Position add(int amount) {
    int newValue = value + amount;

    if (newValue < 1) {
      newValue = 1;
    }

    return new Position(newValue);
  }

  public int getValue() {
    return value;
  }
}
