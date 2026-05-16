package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.Path;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.PathRoute;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerColour;

public class PathFactory {

  private final PathRoute route;

  public PathFactory(PathRoute route) {
    this.route = route;
  }

  public Path create(PlayerColour colour) {
    return route.createPath(colour);
  }
}
