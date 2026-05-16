package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerColour;

import java.util.List;

public class FourPlayerFactory implements PlayerFactory {

  private final PathFactory pathFactory;

  public FourPlayerFactory(PathFactory pathFactory) {
    this.pathFactory = pathFactory;
  }

  @Override
  public List<Player> createPlayers() {
    return List.of(
      new Player(PlayerColour.RED, pathFactory.create(PlayerColour.RED)),
      new Player(PlayerColour.BLUE, pathFactory.create(PlayerColour.BLUE)),
      new Player(PlayerColour.YELLOW, pathFactory.create(PlayerColour.YELLOW)),
      new Player(PlayerColour.GREEN, pathFactory.create(PlayerColour.GREEN))
    );
  }
}
