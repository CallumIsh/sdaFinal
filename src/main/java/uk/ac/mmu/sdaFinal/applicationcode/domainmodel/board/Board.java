package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.List;

public interface Board {
  Position getEndPosition();

  Position getStartPosition();

  Position applyBounds(Position position);

  List<Wormhole> getWormholes();
}
