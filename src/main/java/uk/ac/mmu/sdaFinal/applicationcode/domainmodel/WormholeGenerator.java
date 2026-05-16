package uk.ac.mmu.sdaFinal.applicationcode.domainmodel;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.*;

public class WormholeGenerator {
  public List<Wormhole> generate(int boardSize, Set<Integer> invalidPositions) {
    Random random = new Random();
    List<Wormhole> wormholes = new ArrayList<>();
    Set<Integer> usedPositions = new HashSet<>();

    int count = random.nextInt(3) + 1;

    int min = 2;
    int max = boardSize - 1;

    while (wormholes.size() < count) {

      int start = random.nextInt(max - min + 1) + min;

      int offset = random.nextInt(4) + 2;
      int end = start + (random.nextBoolean() ? offset : -offset);

      boolean valid =
        end >= min && end <= max && start != end
        && !usedPositions.contains(start) &&
        !usedPositions.contains(end) &&
        !invalidPositions.contains(start) &&
        !invalidPositions.contains(end);

      if (valid) {
        wormholes.add(new Wormhole(
          new Position(start), new Position(end)


        ));
        usedPositions.add(start);
        usedPositions.add(end);
      }
    }
    return wormholes;
  }
}
