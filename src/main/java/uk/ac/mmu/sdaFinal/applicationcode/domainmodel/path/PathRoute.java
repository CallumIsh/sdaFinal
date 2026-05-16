package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerColour;

public interface PathRoute {
  Path createPath(PlayerColour colour);
}
