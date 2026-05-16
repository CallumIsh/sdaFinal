package uk.ac.mmu.sdaFinal.applicationcode.domainmodel;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShakerDecorator;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.RandomSingleDice;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameRules;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.LargePathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class AllVariationsFactory extends AbstractGameFactory {

  @Override
  public Game createGame() {

    GameRules rules = new GameRules(
      "Large",
      4,
      true,
      true,
      true
    );

    return buildGame(
      rules,
      new DiceShakerDecorator(new RandomSingleDice()),
      new LargePathRoute(),
      Position.THIRTY_SIX.getValue(),
      null
    );
  }

}
