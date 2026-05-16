package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.PlayerColour;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.ArrayList;
import java.util.List;

public class LargePathRoute implements PathRoute {

  @Override
  public Path createPath(PlayerColour colour) {

    return switch (colour) {
      case RED -> new Path(generateRange(1, 36));

      case BLUE -> new Path(List.of(
        p(31), p(32), p(33), p(34), p(35), p(36),
        p(25), p(26), p(27), p(28), p(29), p(30),
        p(19), p(20), p(21), p(22), p(23), p(24),
        p(13), p(14), p(15), p(16), p(17), p(18),
        p(7), p(8), p(9), p(10), p(11), p(12),
        p(1), p(2), p(3), p(4), p(5), p(6)
      ));

      case YELLOW -> new Path(generateRange(36, 1));

      case GREEN -> new Path(List.of(p(6), p(5), p(4), p(3), p(2), p(1),
        p(12), p(11), p(10), p(9), p(8), p(7),
        p(18), p(17), p(16), p(15), p(14), p(13),
        p(24), p(23), p(22), p(21), p(20), p(19),
        p(30), p(29), p(28), p(27), p(26), p(25),
        p(36), p(35), p(34), p(33), p(32), p(31)
      ));
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

  private Position p(int v) {
    return new Position(v);
  }
}
