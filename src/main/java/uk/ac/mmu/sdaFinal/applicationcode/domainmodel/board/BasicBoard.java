package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.WormholeGenerator;

import java.util.List;
import java.util.Set;

public class BasicBoard implements Board {

  private final Position endPosition;
  private final Position startPosition;
  private final List<Wormhole> wormholes;

  public BasicBoard(int size, Set<Integer> invalidPositions) {
    this.endPosition = new Position(size);
    this.startPosition = Position.ONE;
    this.wormholes = new WormholeGenerator().generate(size, invalidPositions);
  }

  public BasicBoard(int size, List<Wormhole> wormholes) {
    this.endPosition = new Position(size);
    this.startPosition = Position.ONE;
    this.wormholes = wormholes;
  }

  @Override
  public List<Wormhole> getWormholes() {
    return wormholes;
  }

  @Override
  public Position getEndPosition() {
    return endPosition;
  }

  @Override
  public Position getStartPosition() {
    return startPosition;
  }

  @Override
  public Position applyBounds(Position position) {
    if (position.isLessThanOrEqual(startPosition)) {
      return startPosition;
    }

    if (position.isGreaterThanOrEqual(endPosition)) {
      return endPosition;
    }

    return position;
  }
}
