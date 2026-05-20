package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.*;

public class WormholeGenerator {

  private final WormholeValidator validator = new WormholeValidator();

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


      if (end < 1 || end > boardSize) {
        continue;
      }

      Wormhole candidate = new Wormhole(new Position(start), new Position(end));

      if (validator.isValid(candidate, invalidPositions, usedPositions, boardSize)) {
        wormholes.add(candidate);
        usedPositions.add(start);
        usedPositions.add(end);
      }
    }
    return wormholes;
  }
}
