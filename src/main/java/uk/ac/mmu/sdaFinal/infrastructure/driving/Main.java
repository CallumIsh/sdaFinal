package uk.ac.mmu.sdaFinal.infrastructure.driving;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.GameFacade;

public class

Main {

  public static void main(String[] args) {

    GameFacade facade = new GameFacade();

    facade.playBasicGame();

    facade.playDoubleGame();

    facade.playExactEndGame();

    facade.playWormholeGame();

    facade.playHitGame();

    facade.playBigBoardGame();

    facade.playAllVariationsGame();
  }
}
