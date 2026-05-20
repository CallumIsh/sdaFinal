package uk.ac.mmu.sdaFinal.infrastructure.driving;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.GameStartedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.GameStateChangedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.PlayerWonEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.TurnCompletedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.observer.GameObserver;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.turn.TurnResult;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.GameRulesConfig;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GamePlayed;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameRepository;

import java.util.stream.Collectors;

public class OutputGameObserver implements GameObserver {

  private final Game game;
  private final GameRepository repository;
  private final boolean saveEnabled;

  public OutputGameObserver(Game game, GameRepository repository, Boolean saveEnabled) {
    this.game = game;
    this.repository = repository;
    this.saveEnabled = saveEnabled;
  }

  @Override
  public void onEvent(TurnCompletedEvent event) {

    TurnResult result = event.getResult();

    String player = result.getPlayer().getColour().colouredName();

    System.out.println(
      player + " turn " +
        result.getTurnNumber() +
        " rolls " +
        result.getRoll() + "."
    );
    delay(100);

    if (result.isBounced()) {
      System.out.println(player + " overshoots end.");
    }
    delay(100);

    System.out.println(
      player + " moves from position " +
        result.getOldPosition() + " to position " +
        result.getAttemptedPosition() + "."
    );
    delay(100);

    if (result.isHit()) {

      System.out.println(
        player + " hit " +
          result.getHitPlayer().getColour().name() +
          " at position " +
          result.getAttemptedPosition() + "."
      );
      delay(100);

      System.out.println(
        player + " moves from position " +
          result.getAttemptedPosition() +
          " to position " +
          result.getOldPosition() + "."
      );
      delay(100);
    }

    if (result.isTeleported()) {

      System.out.println(player + " is teleported.");
      delay(100);

      System.out.println(
        player + " moves from position " +
          result.getTeleportFrom() +
          " to position " +
          result.getTeleportTo() + "."
      );
      delay(100);
    }

  }

  @Override
  public void onEvent(PlayerWonEvent event) {
    String rolls = event.getDiceRolls().stream().map(DiceRoll::toString).collect(Collectors.joining(", "));

    System.out.println(
      event.getPlayer().getColour().colouredName() + " wins in " + event.getTurns() + " turns."
    );
    delay(500);

    System.out.println("Total turns: " + event.getTotalTurns() + ".");
    System.out.println("Dice rolls: {" + rolls + "}");
    delay(300);

    if (saveEnabled) {

      GamePlayed gamePlayed = new GamePlayed(
        game.getGameId(),
        game.getRules(),
        game.getDiceHistory().stream().map(DiceRoll::getValue).toList(),
        game.getWormholes()
      );

      repository.save(gamePlayed);

      System.out.println("Game Id: " + game.getGameId() + " saved.");
      delay(500);
    }
  }

  @Override
  public void onEvent(GameStartedEvent event) {

    GameRulesConfig rules = event.getRules();
    Board board = event.getBoard();

    String boardType = rules.getPlayerCount() == 2 ? "Small" : "Large";

    String wormholes = board.getWormholes().isEmpty() ? "None"
    : board.getWormholes().stream()
    .map(w -> w.getA() + " and " + w.getB()).collect(Collectors.joining(", "));

    System.out.println(
      "Board: " + boardType +
        ", Players: " + rules.getPlayerCount() +
        ", Exact End: " + (rules.isExactEnd()
        ? "Player must land exactly on the END position to win else the player bounces back"
        : "Player can land on or overshoot the END position to win") +
        ", Hit: " + (rules.isHitEnabled()
        ? "Player's turn is forfeit if the player would HIT another player"
        : "HITS are ignored, multiple players can occupy the same position") +
        ", Teleport: " + (rules.isTeleportEnabled()
        ? "Player is teleported to the other end of the wormhole"
        : "Wormholes are ignored") +
        ", Wormholes: " + wormholes
    );
    delay(500);

    for (Player player : event.getPlayers()) {
      String path = player.getPath().getPositions().stream()
        .map(Position::toString)
        .collect(Collectors.joining(" -> "));

      System.out.println(player.getColour().colouredName() + " path: " + path);
    }
    delay(500);
  }

  @Override
  public void onEvent(GameStateChangedEvent event) {

    System.out.println(
      "Game State: " +
        event.getOldState() +
        " -> " +
        event.getNewState()
    );

    delay(500);

  }

  private void delay(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

}
