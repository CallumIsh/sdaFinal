package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.observer;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.GameStartedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.GameStateChangedEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.PlayerWonEvent;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.events.TurnCompletedEvent;

public interface GameObserver {
  void onEvent(TurnCompletedEvent event);
  void onEvent(PlayerWonEvent event);
  void onEvent(GameStartedEvent event);
  void onEvent(GameStateChangedEvent event);
}

