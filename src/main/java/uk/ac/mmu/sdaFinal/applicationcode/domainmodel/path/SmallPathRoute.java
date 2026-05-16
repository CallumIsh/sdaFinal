package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerColour;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.ArrayList;
import java.util.List;

public class SmallPathRoute implements PathRoute {

  @Override
  public Path createPath(PlayerColour colour) {

    return switch (colour) {
      case RED -> new Path(generateRange(1, 25));
      case BLUE -> new Path(generateRange(25, 1));
      default -> throw new IllegalArgumentException();
    };
  }

  private List<Position> generateRange(int start, int end) {
    List<Position> list = new ArrayList<>();

    if (start <= end) {
      for (int i = start; i <= end; i++) {
        list.add(new Position(i));
      }
    }
    else {
      for (int i = start; i >= end; i--) {
        list.add(new Position(i));
      }
    }

    return list;
  }

}
