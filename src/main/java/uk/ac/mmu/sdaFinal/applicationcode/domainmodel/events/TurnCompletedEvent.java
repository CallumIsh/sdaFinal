package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.turn.TurnResult;

public class TurnCompletedEvent extends GameEvent {
  private final TurnResult result;

  public TurnCompletedEvent(TurnResult result) {
    super(result.getPlayer());
    this.result = result;
  }

  public TurnResult getResult() {
    return result;
  }
}
