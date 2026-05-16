package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShakerDecorator;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.RandomSingleDice;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.SmallPathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class DoubleDiceFactory extends AbstractGameFactory {
  @Override
  public Game createGame() {

    GameRules rules = new GameRules(
      "Small",
      2,
      false,
      false,
      false
    );

    return buildGame(
      rules,
      new DiceShakerDecorator(new RandomSingleDice()),
      new SmallPathRoute(),
      Position.TWENTY_FIVE.getValue(),
      null
    );
  }
}
