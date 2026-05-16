package uk.ac.mmu.sdaFinal.applicationcode.domainmodel;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.FixedDice;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.SmallPathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.List;

public class TestFactory extends AbstractGameFactory {
  @Override
  public Game createGame() {

    GameRules rules = new GameRules(
      "Test",
      2,
      false,
      true,
      true
    );

    DiceShaker dice = new FixedDice(List.of(new DiceRoll(10), new DiceRoll(7), new DiceRoll(3), new DiceRoll(5), new DiceRoll(2), new DiceRoll(6), new DiceRoll(4), new DiceRoll(3)));

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
