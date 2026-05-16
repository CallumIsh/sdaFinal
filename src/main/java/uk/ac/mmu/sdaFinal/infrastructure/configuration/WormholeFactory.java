package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.FixedDice;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.SmallPathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.List;

public class WormholeFactory extends AbstractGameFactory {
  @Override
  public Game createGame() {

    GameRules rules = new GameRules(
      "Small",
      2,
      false,
      false,
      true
    );

    DiceShaker dice = new FixedDice(List.of(new DiceRoll(6), new DiceRoll(1), new DiceRoll(1), new DiceRoll(1), new DiceRoll(6), new DiceRoll(1), new DiceRoll(6), new DiceRoll(1), new DiceRoll(6)));

    List<Wormhole> wormholes = List.of(new Wormhole(new Position(8), new Position(11)));

    return buildGame(
      rules,
      dice,
      new SmallPathRoute(),
      Position.TWENTY_FIVE.getValue(),
      wormholes
    );
  }
}
