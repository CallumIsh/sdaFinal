package uk.ac.mmu.sdaFinal.applicationcode.usecase;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;

public class PlayGame {

  private final Game game;

  public PlayGame(Game game) {
    this.game = game;
  }

  public void playGame() {

    //notifyGameStarted();

    while (!game.hasWinner()) {
      game.playTurn();
    }
  }
}
