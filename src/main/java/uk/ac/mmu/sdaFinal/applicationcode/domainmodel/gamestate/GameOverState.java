package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate;

public class GameOverState implements GameState {

  @Override
  public void startGame(GameContext context) {
    context.reset();
    context.setState(new ReadyState());
  }

  @Override
  public void endGame(GameContext context) {

  }

  @Override
  public void reset(GameContext context) {
    context.setState(new ReadyState());
  }

  @Override
  public void nextTurn(GameContext context) {

  }

  @Override
  public String toString() {
    return "GAME OVER";
  }

}
