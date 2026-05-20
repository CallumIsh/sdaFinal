package uk.ac.mmu.sdaFinal.applicationcode.usecase.replay;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceShaker;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.FixedDice;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Required;
import uk.ac.mmu.sdaFinal.infrastructure.configuration.GameDefinition;
import uk.ac.mmu.sdaFinal.infrastructure.driving.OutputGameObserver;

import java.util.List;

public class ReplayGame {

  private final GameRepository repository;

  private final Required required;

  public ReplayGame(GameRepository repository, Required required) {
    this.repository = repository;
    this.required = required;
  }

  public void replay(String gameId) {

    GamePlayed saved = repository.findById(gameId).orElseThrow();

    List<DiceRoll> rolls = saved.getDiceRolls().stream().map(DiceRoll::new).toList();

    DiceShaker dice = new FixedDice(rolls);

    GameDefinition definition = new GameDefinition(saved.getRules(), dice, saved.getWormholes(), false);

    Game game = required.loadGame(definition);

    game.addObserver(new OutputGameObserver(game, repository, false));

    game.gameStarted();

    while (!game.hasWinner()) {
      game.playTurn();
    }

  }

}
