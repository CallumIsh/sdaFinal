package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.PathFactory;

import java.util.List;

public class TwoPlayerFactory implements PlayerFactory {

  private final PathFactory pathFactory;

  public TwoPlayerFactory(PathFactory pathFactory) {
    this.pathFactory = pathFactory;
  }


  @Override
  public List<Player> createPlayers() {
    return List.of(
      new Player(PlayerColour.RED, pathFactory.create(PlayerColour.RED)),
      new Player(PlayerColour.BLUE, pathFactory.create(PlayerColour.BLUE))
    );
  }
}
