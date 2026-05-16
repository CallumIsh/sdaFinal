package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.movement;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Board;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.DiceRoll;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.Path;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class ExactEndMovement implements MovementType {

  @Override
  public MovementResult move(Position current, DiceRoll roll, Player player, Board board) {

    Path path = player.getPath();

    int currentIndex = path.indexOf(current);
    int targetIndex = currentIndex + roll.getValue();
    int lastIndex = path.size() - 1;

    boolean bounced = false;

    if (targetIndex > lastIndex) {
      int overshoot = targetIndex - lastIndex;
      targetIndex = lastIndex - overshoot;
      bounced = true;
    }

    return new MovementResult(path.get(targetIndex), bounced);
  }
}
