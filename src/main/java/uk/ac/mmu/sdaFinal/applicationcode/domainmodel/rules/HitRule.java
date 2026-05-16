package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

import java.util.List;

public interface HitRule {
  HitResult apply(Player current, Position target, List<Player> players);
}
