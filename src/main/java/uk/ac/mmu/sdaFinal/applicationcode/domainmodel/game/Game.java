package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate.GameContext;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.GameStartedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.PlayerWonEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.TurnCompletedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.MovementResult;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.MovementType;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.observer.GameObserver;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerSelector;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.*;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.turn.TurnResult;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.turn.TurnTracker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.GameRulesConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Game {

  private final String gameId;
  private final Board board;
  private final DiceShaker dice;
  private final TurnTracker turnTracker = new TurnTracker();
  private final PlayerSelector turnSelector;
  private final MovementType movementType;
  private final WinCondition winCondition;
  private final List<Player> players;
  private final HitRule hitRule;
  private final TeleportRule teleportRule;
  private final GameRulesConfig rules;
  private final List<GameObserver> observers = new ArrayList<>();
  private final List<DiceRoll> diceHistory = new ArrayList<>();
  private Player winner;
  private final GameContext context;

  public Game(String gameId, Board board, DiceShaker dice, PlayerSelector turnSelector, MovementType movementType,
              WinCondition winCondition, HitRule hitRule, TeleportRule teleportRule, List<Player> players, GameRulesConfig rules, GameContext context) {

    this.gameId = gameId;
    this.board = board;
    this.dice = dice;
    this.turnSelector = turnSelector;
    this.movementType = movementType;
    this.winCondition = winCondition;
    this.hitRule = hitRule;
    this.teleportRule = teleportRule;
    this.players = players;
    this.rules = rules;
    this.context = context;

    this.context.setListener(event -> notifyObservers(o -> o.onEvent(event)));
  }

  public TurnResult playTurn() {

    if (!canPlayTurn()) return null;

    Player current = turnSelector.next();

    turnTracker.recordTurn(current);

    DiceRoll roll = dice.shake();
    diceHistory.add(roll);

    TurnResult result = processMove(current, roll, turnTracker.getPlayerTurns(current));

    notifyObservers(observer -> observer.onEvent(new TurnCompletedEvent(result)));

    if (result.hasWon()) {

      winner = current;
      context.endGame();
      notifyObservers(observer ->
        observer.onEvent(
          new PlayerWonEvent(
            current,
            turnTracker.getPlayerTurns(current),
            turnTracker.getTotalTurns(),
            diceHistory
          )
        )
      );
    }
    return result;
  }

  private TurnResult processMove(Player current, DiceRoll roll, int turnNumber) {
    Position oldPosition = current.getPosition();

    MovementResult result = movementType.move(current.getPosition(), roll, current, this.board);
    Position afterMove = board.applyBounds(result.getPosition());

    TeleportResult teleportResult = teleportRule.apply(afterMove, board);
    Position afterTeleport = teleportResult.getPosition();

    HitResult hitResult = hitRule.apply(current, afterTeleport, players);

    if (hitResult.isHit()) {
      current.setPosition(oldPosition);
    }
    else {
      current.setPosition(afterTeleport);
    }

    boolean won = winCondition.hasWon(current, board);

    return new TurnResult(
      current,
      turnNumber,
      roll,
      oldPosition,
      afterMove,
      current.getPosition(),
      result.isBounced(),
      teleportResult.isTeleported(),
      teleportResult.getFrom(),
      teleportResult.getTo(),
      hitResult.isHit(),
      hitResult.getHitPlayer(),
      won
    );
  }

  public void gameStarted() {
    notifyObservers(observer ->
      observer.onEvent(new GameStartedEvent(gameId, rules, board, players)));
  }

  public int getTotalTurns() {
    return turnTracker.getTotalTurns();
  }

  public List<DiceRoll> getDiceHistory() {
    return List.copyOf(diceHistory);
  }

  public GameRulesConfig getRules() {
    return rules;
  }

  public String getGameId() {
    return gameId;
  }

  public List<Wormhole> getWormholes() {
    return board.getWormholes();
  }

  public GameContext getContext() {
    return context;
  }

  public boolean hasWinner() {
    return winner != null;
  }

  public void addObserver(GameObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(GameObserver observer) {
    observers.remove(observer);
  }

  private boolean canPlayTurn() {
    return context.getStatus().equals("IN PLAY");
  }

  private void notifyObservers(Consumer<GameObserver> action) {
    observers.forEach(action);
  }
}
