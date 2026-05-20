package uk.ac.mmu.sdaFinal.applicationcode.usecase.replay;

public class GameIdGenerator {

  private static int nextId = 1;

  public String generate() {
    return String.valueOf(nextId++);
  }

}
