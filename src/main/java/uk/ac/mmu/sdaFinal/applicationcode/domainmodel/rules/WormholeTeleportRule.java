package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;

public class WormholeTeleportRule implements TeleportRule {
  @Override
  public TeleportResult apply(Position position, Board board) {
    for (Wormhole w : board.getWormholes()) {
      if (w.connects(position)) {
        Position destination = w.otherEnd(position);

        return new TeleportResult(
          destination,
          true,
          position,
          destination
        );
      }
    }
    return new TeleportResult(position, false, null, null);
  }
}
