package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player.Player;

import java.util.List;

public interface PlayerFactory {
  List<Player> createPlayers();
}
