package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Required;

public class GameAdapter implements Required {

  @Override
  public Game loadGame(GameDefinition definition) {
    return definition.build();
  }

}
