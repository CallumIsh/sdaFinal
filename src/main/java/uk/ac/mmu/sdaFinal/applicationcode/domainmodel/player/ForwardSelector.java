package uk.ac.mmu.sdaFinal.applicationcode.domainmodel.player;

import java.util.List;

public class ForwardSelector implements PlayerSelector {
  private final List<Player> players;
  private int index = 0;

  public ForwardSelector(List<Player> players) {
    this.players = players;
  }

  @Override
  public Player next() {

    Player current = players.get(index);

    index++;

    if (index >= players.size()) {
      index = 0;
    }

    return current;
  }
}
