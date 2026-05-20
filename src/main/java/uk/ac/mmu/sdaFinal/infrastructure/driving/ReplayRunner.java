package uk.ac.mmu.sdaFinal.infrastructure.driving;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GamePlayed;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameRepository;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.ReplayGame;

import java.util.List;
import java.util.Scanner;

@Component
public class ReplayRunner implements CommandLineRunner, Ordered {

  private final ReplayGame replayGame;
  private final GameRepository repository;

  public ReplayRunner(ReplayGame replayGame, GameRepository repository) {
    this.replayGame = replayGame;
    this.repository = repository;
  }

  @Override
  public void run(String... args) {
    List<GamePlayed> games = repository.findAll();

    if (games.isEmpty()) {
      System.out.println("No saved games to replay.");
      return;
    }

    System.out.println("\nSaved Games: ");

    for (GamePlayed g : games) {
      System.out.println("- " + g.getGameId());
    }

    String id;

    Scanner scanner = new Scanner(System.in);

    while (true) {

      System.out.println("\nEnter Game ID to replay:");

      String inputId = scanner.nextLine().trim();

      boolean exists = games.stream().anyMatch(g -> g.getGameId().equals(inputId));

      if (exists) {
        id = inputId;
        break;
      }

      System.out.println("Invalid game Id. Try again.");
    }

    System.out.println("\nReplaying game: " + id);

    replayGame.replay(id);

    System.exit(0);

  }

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }

}
