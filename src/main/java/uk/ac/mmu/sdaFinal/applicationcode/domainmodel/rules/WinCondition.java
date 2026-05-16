package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

public interface WinCondition {
  boolean hasWon(Player player, Board board);
}
