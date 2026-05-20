package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate;

public class ReadyState implements GameState {

  @Override
  public void startGame(GameContext context) {
    context.setState(new InPlayState());
  }

  @Override
  public void endGame(GameContext context) {

  }

  @Override
  public void reset(GameContext context) {

  }

  @Override
  public void nextTurn(GameContext context) {

  }

  @Override
  public String toString() {
    return "READY";
  }

}
