package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.infrastructure.configuration.GameRulesConfig;

import java.util.List;

public class GameStartedEvent extends GameEvent {

  private final GameRulesConfig rules;
  private final Board board;
  private final List<Player> players;

  public GameStartedEvent(GameRulesConfig rules, Board board, List<Player> players) {
    super(null);
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
}
