package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.*;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.PlayGame;
import uk.ac.mmu.sdaFinal.infrastructure.driving.OutputGameObserver;

public class GameFacade {

  public void playBasicGame() {
    play(new BasicGameFactory());
  }

  public void playDoubleGame() {
    play(new DoubleDiceFactory());
  }

  public void playExactEndGame() {
    play(new ExactEndFactory());
  }

  public void playHitGame() {
    play(new HitRuleFactory());
  }

  public void playWormholeGame() {
    play(new WormholeFactory());
  }

  public void playBigBoardGame() {
    play(new BigBoardFactory());
  }

  public void playAllVariationsGame() {
    play(new AllVariationsFactory());
  }

  public void playTestGame() {
    play(new TestFactory());
  }

  private void play(GameFactory factory) {
    Game game = factory.createGame();
    game.addObserver(new OutputGameObserver());
    PlayGame playGame = new PlayGame(game);
    playGame.playGame();
  }
}
