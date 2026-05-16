package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

import java.util.List;

public class ForfeitHitRule implements HitRule {

  @Override
  public HitResult apply(Player current, Position target, List<Player> players) {

    for (Player p : players) {
      if (p != current && p.getPosition().equals(target)) {
        return new HitResult(current.getPosition(), p);
      }
    }

    return new HitResult(target, null);
  }
}
