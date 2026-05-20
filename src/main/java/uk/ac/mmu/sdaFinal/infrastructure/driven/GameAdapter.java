package uk.ac.mmu.sdaFinal.infrastructure.driven;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Required;
import uk.ac.mmu.sdaFinal.infrastructure.configuration.GameDefinition;

public class GameAdapter implements Required {

  @Override
  public Game loadGame(GameDefinition definition) {
    return definition.build();
  }

}
