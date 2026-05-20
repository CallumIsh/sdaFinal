package uk.ac.mmu.sdaFinal.infrastructure.driven;

import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameRepository;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GamePlayed;

import java.util.*;

public class InMemoryGameRepository implements GameRepository {

  private final Map<String, GamePlayed> games = new HashMap<>();

  @Override
  public void save(GamePlayed game) {
    games.put(game.getGameId(), game);
    System.out.println("Saved game: " + game.getGameId());
    System.out.println("Total saved games: " + games.size());
  }

  @Override
  public Optional<GamePlayed> findById(String gameId) {
    return Optional.ofNullable(games.get(gameId));
  }

  @Override
  public List<GamePlayed> findAll() {
    return new ArrayList<>(games.values());
  }

}
