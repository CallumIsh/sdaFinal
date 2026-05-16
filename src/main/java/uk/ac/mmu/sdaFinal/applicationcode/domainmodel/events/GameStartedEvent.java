package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

import java.util.List;

public class GameStartedEvent extends GameEvent {

  private final GameRules rules;
  private final Board board;
  private final List<Player> players;

  public GameStartedEvent(GameRules rules, Board board, List<Player> players) {
    super(null);
    this.rules = rules;
    this.board = board;
    this.players = players;
  }

  public GameRules getRules() {
    return rules;
  }

  public Board getBoard() {
    return board;
  }

  public List<Player> getPlayers() {
    return players;
  }
}
