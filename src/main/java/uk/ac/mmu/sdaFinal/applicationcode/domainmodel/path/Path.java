package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

import java.util.List;

public class Path {

  private final List<Position> positions;

  public Path(List<Position> positions) {
    this.positions = positions;
  }

  public Position getStart() {
    return positions.get(0);
  }

  public Position getEnd() {
    return positions.get(positions.size() - 1);
  }

  public int indexOf(Position position) {
    return  positions.indexOf(position);
  }

  public Position get(int index) {
    return positions.get(index);
  }

  public int size() {
    return positions.size();
  }

  public Position move(Position current, int steps) {
    int index = indexOf(current);
    int target = index + steps;

    if (target >= positions.size()) {
      return getEnd();
    }

    return positions.get(target);
  }

  public List<Position> getPositions() {
    return List.copyOf(positions);
  }
}
