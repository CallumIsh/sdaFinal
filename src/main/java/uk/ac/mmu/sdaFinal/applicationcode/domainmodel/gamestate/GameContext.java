package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.gamestate;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.GameStateChangedEvent;

import java.util.function.Consumer;

public class GameContext {

  private GameState state = new ReadyState();
  private Consumer<GameStateChangedEvent> listener;

  public void setState(GameState state) {

    if (listener != null) {
      listener.accept(
        new GameStateChangedEvent(
          this.state.toString(),
          state.toString()
        )
      );
    }

    this.state = state;
  }

  public void startGame() {
    state.startGame(this);
  }

  public void endGame() {
    state.endGame(this);
  }

  public void reset() {
    state.reset(this);
  }

  public void nextTurn() {
    state.nextTurn(this);
  }

  public String getStatus() {
    return state.toString();
  }

  public void setListener(Consumer<GameStateChangedEvent> listener) {
    this.listener = listener;
  }

}
