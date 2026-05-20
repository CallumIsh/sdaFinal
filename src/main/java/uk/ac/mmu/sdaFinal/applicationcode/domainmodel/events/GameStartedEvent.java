package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.GameRulesConfig;

import java.util.List;

public class GameStartedEvent extends GameEvent {

  private final GameRulesConfig rules;
  private final Board board;
  private final List<Player> players;
  private final String gameId;

  public GameStartedEvent(String gameId, GameRulesConfig rules, Board board, List<Player> players) {
    super(null);
    this.gameId = gameId;
    this.rules = rules;
    this.board = board;
    this.players = players;
  }

  public GameRulesConfig getRules() {
    return rules;
  }

  public Board getBoard() {
    return board;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public String getGameId() {
    return gameId;
  }
}
