package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

public class GameStateChangedEvent {

  private final String oldState;
  private final String newState;

  public GameStateChangedEvent(String oldState, String newState) {
    this.oldState = oldState;
    this.newState = newState;
  }

  public String getOldState() {
    return oldState;
  }

  public String getNewState() {
    return newState;
  }
}
