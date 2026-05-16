package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.game.Game;

@Configuration
public class GameConfig {

  @Bean
  public GameFactory gameFactory() {
    return new BasicGameFactory();
  }

  @Bean
  public Game game(GameFactory factory) {
    return factory.createGame();
  }
}
