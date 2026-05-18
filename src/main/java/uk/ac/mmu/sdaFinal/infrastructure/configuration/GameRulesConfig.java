package uk.ac.mmu.sdaFinal.infrastructure.configuration;

public class GameRulesConfig {

  private final int playerCount;

  private final boolean exactEnd;
  private final boolean hitEnabled;
  private final boolean teleportEnabled;

  public GameRulesConfig(int playerCount, boolean exactEnd, boolean hitEnabled, boolean teleportEnabled) {

    if (playerCount != 2 && playerCount != 4) {
      throw new IllegalArgumentException(
        "Player count must be 2 or 4"
      );
    }

    this.playerCount = playerCount;
    this.exactEnd = exactEnd;
    this.hitEnabled = hitEnabled;
    this.teleportEnabled = teleportEnabled;
  }

  public int getPlayerCount() {
    return playerCount;
  }

  public boolean isExactEnd() {
    return exactEnd;
  }

  public boolean isHitEnabled() {
    return hitEnabled;
  }

  public boolean isTeleportEnabled() {
    return teleportEnabled;
  }
}
