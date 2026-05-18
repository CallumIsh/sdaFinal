package uk.ac.mmu.sdaFinal.infrastructure.driving;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Provided;

import java.util.List;

@Component
public class GameRunner implements CommandLineRunner, Ordered {

  private final List<Provided> games;

  public GameRunner(List<Provided> games) {
    this.games = games;
  }

  @Override
  public void run(String...args) {
    for (Provided game : games) {
      game.playGame();
    }
  }

  @Override
  public int getOrder() {
    return Ordered.HIGHEST_PRECEDENCE;
  }

}
