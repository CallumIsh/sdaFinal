package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game;

public class GameRules {
  private final String boardType;
  private final int playerCount;

  private final boolean exactEnd;
  private final boolean hitEnabled;
  private final boolean teleportEnabled;

  public GameRules(String boardType, int playerCount, boolean exactEnd, boolean hitEnabled, boolean teleportEnabled) {
    this.boardType = boardType;
    this.playerCount = playerCount;
    this.exactEnd = exactEnd;
    this.hitEnabled = hitEnabled;
    this.teleportEnabled = teleportEnabled;
  }

  public String getBoardType() { return boardType; }
  public int getPlayerCount() { return playerCount; }

  public boolean isExactEnd() { return exactEnd; }
  public boolean isHitEnabled() { return hitEnabled; }
  public boolean isTeleportEnabled() { return teleportEnabled; }
}
