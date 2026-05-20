package uk.ac.mmu.sdaFinal.applicationcode.usecase.replay;

import java.util.List;
import java.util.Optional;

public interface GameRepository {

  void save(GamePlayed game);

  Optional<GamePlayed> findById(String gameId);

  List<GamePlayed> findAll();

}
