package uk.ac.mmu.sdaFinal.applicationcode.usecase.play;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Provided;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Required;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameRepository;
import uk.ac.mmu.sdaFinal.infrastructure.configuration.GameDefinition;
import uk.ac.mmu.sdaFinal.infrastructure.driving.OutputGameObserver;

public class PlayGame implements Provided {

  private final GameDefinition definition;
  private final Required required;
  private final GameRepository repository;

  public PlayGame(Required required, GameDefinition definition, GameRepository repository) {
    this.required = required;
    this.definition = definition;
    this.repository = repository;
  }

  public void playGame() {
    Game game = required.loadGame(definition);

    game.addObserver(new OutputGameObserver(game, repository, true));

    game.gameStarted();
    game.getContext().startGame();

    while (!game.hasWinner()) {
      game.playTurn();

      if (game.getTotalTurns() > 200) {
        System.out.println("Game Terminated: too many turns.");
      }
    }

    game.getContext().endGame();
  }
}
