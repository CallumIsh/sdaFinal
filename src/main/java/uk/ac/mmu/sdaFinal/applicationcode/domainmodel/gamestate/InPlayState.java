package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate;

public class InPlayState implements GameState {

  @Override
  public void startGame(GameContext context) {

  }

  @Override
  public void endGame(GameContext context) {
    context.setState(new GameOverState());
  }

  @Override
  public void reset(GameContext context) {

  }

  @Override
  public void nextTurn(GameContext context) {

    if (isGameWon()) {
      endGame(context);
    }
  }

  private boolean isGameWon() {
    return false;
  }

  @Override
  public String toString() {
    return "IN PLAY";
  }

}
