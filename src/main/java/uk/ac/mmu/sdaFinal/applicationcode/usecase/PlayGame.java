package uk.ac.mmu.sdaFinal.applicationcode.usecase;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.infrastructure.configuration.GameDefinition;
import uk.ac.mmu.sdaFinal.infrastructure.driving.OutputGameObserver;

public class PlayGame implements Provided {

  private final GameDefinition definition;
  private final Required required;

  public PlayGame(Required required, GameDefinition definition) {
    this.required = required;
    this.definition = definition;
  }

  public void playGame() {
    Game game = required.loadGame(definition);

    game.addObserver(new OutputGameObserver());

    game.gameStarted();

    while (!game.hasWinner()) {
      game.playTurn();
    }
  }
}
