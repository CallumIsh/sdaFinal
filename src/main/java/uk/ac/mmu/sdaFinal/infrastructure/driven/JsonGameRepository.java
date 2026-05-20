package uk.ac.mmu.sdaFinal.infrastructure.driven;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameRepository;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GamePlayed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonGameRepository implements GameRepository {

  private final ObjectMapper mapper = new ObjectMapper();

  private final File folder;

  public JsonGameRepository() {
    String home = System.getProperty("user.home");

    folder = new File(home, "sda-games");

    if (!folder.exists()) {
      folder.mkdirs();
    }

    if (folder.exists()) {
      File[] files = folder.listFiles();

      if (files != null) {
        for (File file : files) {
          file.delete();
        }
      }
    }
  }

  @Override
  public void save(GamePlayed game) {

    File file = new File(folder, game.getGameId() + ".json");

    try {
      mapper.writeValue(file, game);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public Optional<GamePlayed> findById(String gameId) {

    File file = new File(folder, gameId + ".json");

    if (!file.exists()) {
      return Optional.empty();
    }

    try {
      GamePlayed game = mapper.readValue(file, GamePlayed.class);

      return Optional.of(game);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public List<GamePlayed> findAll() {

    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

    if (files == null) return List.of();

    List<GamePlayed> games = new ArrayList<>();

    for (File file : files) {
      try {
        games.add(mapper.readValue(file, GamePlayed.class));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    return games;

  }

}
