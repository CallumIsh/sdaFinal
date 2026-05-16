package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.path.Path;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class Player {
  private final PlayerColour colour;
  private final Path path;
  private Position position;

  public Player(PlayerColour colour, Path path) {
    this.colour = colour;
    this.position = path.getStart();
    this.path = path;
  }

  public PlayerColour getColour() {
    return colour;
  }

  public Path getPath() {
    return path;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
