package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameRulesConfig {

  private final int playerCount;

  private final boolean exactEnd;
  private final boolean hitEnabled;
  private final boolean teleportEnabled;

  public GameRulesConfig(@JsonProperty("playerCount") int playerCount, @JsonProperty("exactEnd") boolean exactEnd, @JsonProperty("hitEnabled") boolean hitEnabled, @JsonProperty("teleportEnabled") boolean teleportEnabled) {

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
