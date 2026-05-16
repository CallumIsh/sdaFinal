package uk.ac.mmu.sdaFinal.applicationcode.domainmodel;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.FixedDice;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.LargePathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.List;

public class BigBoardFactory extends AbstractGameFactory {
  @Override
  public Game createGame() {

    GameRules rules = new GameRules(
      "Large",
      4,
      false,
      false,
      false
    );

    DiceShaker dice = new FixedDice(
      List.of(
        new DiceRoll(4),
        new DiceRoll(3),
        new DiceRoll(5),
        new DiceRoll(2),

        new DiceRoll(6),
        new DiceRoll(4),
        new DiceRoll(3),
        new DiceRoll(5),

        new DiceRoll(2),
        new DiceRoll(6),
        new DiceRoll(4),
        new DiceRoll(3),

        new DiceRoll(5),
        new DiceRoll(2),
        new DiceRoll(6),
        new DiceRoll(4),

        new DiceRoll(5),
        new DiceRoll(6),

        new DiceRoll(4),
        new DiceRoll(5),
        new DiceRoll(3),
        new DiceRoll(6),

        new DiceRoll(2),
        new DiceRoll(4),
        new DiceRoll(5),
        new DiceRoll(6),

        new DiceRoll(3),
        new DiceRoll(2),
        new DiceRoll(6),
        new DiceRoll(5)
      )
    );

    return buildGame(
      rules,
      dice,
      new LargePathRoute(),
      Position.THIRTY_SIX.getValue(),
      null
    );
  }
}
