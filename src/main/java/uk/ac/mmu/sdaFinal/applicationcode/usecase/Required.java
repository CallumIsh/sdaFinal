package uk.ac.mmu.sdaFinal.applicationcode.usecase;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.infrastructure.configuration.GameDefinition;

public interface Required {
  Game loadGame(GameDefinition definition);
}
