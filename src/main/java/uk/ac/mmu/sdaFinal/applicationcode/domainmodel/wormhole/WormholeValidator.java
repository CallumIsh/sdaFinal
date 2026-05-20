package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole;

import java.util.Set;

public class WormholeValidator {

  public boolean isValid(Wormhole wormhole, Set<Integer> invalidPositions, Set<Integer> usedPositions, int boardSize) {
    int a = wormhole.getA().getValue();
    int b = wormhole.getB().getValue();

    int min = 2;
    int max = boardSize - 1;

    if (a==b) return false;

    if (a < min || a > max || b < min || b > max) return false;

    if (invalidPositions.contains(a) || invalidPositions.contains(b)) return false;

    if (usedPositions.contains(a) || usedPositions.contains(b)) return false;

    return true;
  }

}
