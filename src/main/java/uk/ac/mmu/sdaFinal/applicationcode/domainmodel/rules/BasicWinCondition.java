package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

public class BasicWinCondition implements WinCondition {

  @Override
  public boolean hasWon(Player player, Board board) {
    return player.getPosition().equals(player.getPath().getEnd());
  }

}



