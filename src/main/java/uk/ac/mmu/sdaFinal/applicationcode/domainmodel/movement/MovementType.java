package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;

public interface MovementType {
  MovementResult move(Position current, DiceRoll roll, Player player, Board board);
}

