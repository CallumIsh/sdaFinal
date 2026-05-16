package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path;

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
