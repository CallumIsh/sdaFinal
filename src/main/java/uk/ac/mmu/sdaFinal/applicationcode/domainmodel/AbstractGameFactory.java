package uk.ac.mmu.sdaFinal.applicationcode.domainmodel;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.BasicBoard;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.BasicMovement;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.ExactEndMovement;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement.MovementType;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.PathFactory;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.PathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.*;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractGameFactory implements GameFactory {

  protected Game buildGame(GameRules rules, DiceShaker dice, PathRoute pathRoute, int boardSize, List<Wormhole> wormholes) {
       MovementType movementType = rules.isExactEnd() ? new ExactEndMovement() : new BasicMovement();

       WinCondition winCondition = new BasicWinCondition();

       HitRule hitRule = rules.isHitEnabled() ? new ForfeitHitRule() : new NoHitRule();

       TeleportRule teleportRule = rules.isTeleportEnabled() ? new WormholeTeleportRule() : new NoTeleportRule();

       PathFactory pathFactory = new PathFactory(pathRoute);

       PlayerFactory playerFactory = rules.getPlayerCount() == 2 ? new TwoPlayerFactory(pathFactory) : new FourPlayerFactory(pathFactory);

       List<Player> players = playerFactory.createPlayers();

       Board board;

       if (wormholes != null) {
         board = new BasicBoard(boardSize, wormholes);
       }
       else {
         Set<Integer> invalid = new HashSet<>();

         for (Player p : players) {
           invalid.add(p.getPath().getStart().getValue());
           invalid.add(p.getPath().getEnd().getValue());
         }

         board = new BasicBoard(boardSize, invalid);
       }

       PlayerSelector selector = new ForwardSelector(players);

       return new Game(
         board,
         dice,
         selector,
         movementType,
         winCondition,
         hitRule,
         teleportRule,
         players,
         rules
       );
  }
}
