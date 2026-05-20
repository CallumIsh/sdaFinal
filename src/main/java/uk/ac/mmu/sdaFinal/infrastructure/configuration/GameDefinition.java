package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate.GameContext;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.WormholeGenerator;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.WormholeValidator;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.BasicBoard;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.BasicMovement;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.ExactEndMovement;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.MovementType;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.LargePathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.PathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.SmallPathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.ForwardSelector;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerSelector;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.*;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameIdGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameDefinition {

  private final GameRulesConfig config;
  private final DiceShaker dice;
  private final boolean randomWormholes;
  private final List<Wormhole> wormholes;

  private final WormholeGenerator wormholeGenerator = new WormholeGenerator();
  private final WormholeValidator wormholeValidator = new WormholeValidator();

  public GameDefinition(GameRulesConfig config, DiceShaker dice, List<Wormhole> wormholes, Boolean randomWormholes) {
    this.config = config;
    this.dice = dice;
    this.wormholes = wormholes;
    this.randomWormholes = randomWormholes;
  }

  public Game build() {

    MovementType movementType = config.isExactEnd()
      ? new ExactEndMovement()
      : new BasicMovement();

    WinCondition winCondition = new BasicWinCondition();

    HitRule hitRule = config.isHitEnabled()
      ? new ForfeitHitRule()
      : new NoHitRule();

    TeleportRule teleportRule = config.isTeleportEnabled()
      ? new WormholeTeleportRule()
      : new NoTeleportRule();


    int playerCount = config.getPlayerCount();

    PathRoute pathRoute = (playerCount == 2) ? new SmallPathRoute() : new LargePathRoute();

    PathFactory pathFactory = new PathFactory(pathRoute);

    PlayerFactory playerFactory = (playerCount == 2) ? new TwoPlayerFactory(pathFactory) : new FourPlayerFactory(pathFactory);

    List<Player> players = playerFactory.createPlayers();

    int boardSize = (playerCount == 2) ? 25 : 36;

    PlayerSelector selector = new ForwardSelector(players);

    Set<Integer> invalidPositions = new HashSet<>();

    if (randomWormholes && !wormholes.isEmpty()) {
      throw new IllegalStateException(
        "Cannot use fixed and random wormholes together."
      );
    }

    for (Player p : players) {
      invalidPositions.add(p.getPath().getStart().getValue());
      invalidPositions.add(p.getPath().getEnd().getValue());
    }

    List<Wormhole> finalWormholes;

    if (randomWormholes) {
      finalWormholes = wormholeGenerator.generate(boardSize, invalidPositions);
    }
    else {
      finalWormholes = new ArrayList<>();

      Set<Integer> used = new HashSet<>();

      for (Wormhole w : wormholes) {
        if (!wormholeValidator.isValid(w, invalidPositions, used, boardSize)) {
          throw new IllegalStateException(
            "Invalid wormhole: " + w.getA() + "->" + w.getB()
          );
        }
          finalWormholes.add(w);
          used.add(w.getA().getValue());
          used.add(w.getB().getValue());
        }
      }
    Board board = new BasicBoard(boardSize, finalWormholes);

    String gameId = new GameIdGenerator().generate();

    GameContext context = new GameContext();

    return new Game(
      gameId,
      board,
      dice,
      selector,
      movementType,
      winCondition,
      hitRule,
      teleportRule,
      players,
      config,
      context
    );
  }
}
