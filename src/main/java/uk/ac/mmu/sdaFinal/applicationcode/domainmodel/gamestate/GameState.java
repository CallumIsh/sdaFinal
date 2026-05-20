package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate;

public interface GameState {
  void startGame(GameContext context);
  void endGame(GameContext context);
  void reset(GameContext context);
  void nextTurn(GameContext context);
}
