package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole;

import com.fasterxml.jackson.annotation.JsonProperty;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;

public class Wormhole {
  private final Position a;
  private final Position b;

  public Wormhole(@JsonProperty("a") Position a, @JsonProperty("b") Position b) {
    if (a.equals(b)) {
      throw new IllegalArgumentException("Wormhole must connect two different positions.");
    }
    this.a = a;
    this.b = b;
  }

  public boolean connects(Position p) {
    return p.equals(a) || p.equals(b);
  }

  public Position otherEnd(Position p) {
    if (p.equals(a)) return b;
    if (p.equals(b)) return a;
    return p;
  }

  public Position getA() {
    return a;
  }

  public Position getB() {
    return b;
  }
}
