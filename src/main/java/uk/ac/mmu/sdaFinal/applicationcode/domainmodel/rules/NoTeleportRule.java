package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;

public class NoTeleportRule implements TeleportRule {
  @Override
  public TeleportResult apply(Position position, Board board) {
    return new TeleportResult(position, false, null, null);
  }
}
