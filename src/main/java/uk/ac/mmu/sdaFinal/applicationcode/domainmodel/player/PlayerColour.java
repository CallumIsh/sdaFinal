package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player;

public enum PlayerColour {
  RED("\u001B[31m"), BLUE("\u001B[34m"), GREEN("\u001B[32m"), YELLOW("\u001B[33m");

  private static final String RESET = "\u001B[0m";

  private final String ansiCode;

  PlayerColour(String ansiCode) {
    this.ansiCode = ansiCode;
  }

  public String colouredName() {
    return ansiCode + name() + RESET;
  }

}
