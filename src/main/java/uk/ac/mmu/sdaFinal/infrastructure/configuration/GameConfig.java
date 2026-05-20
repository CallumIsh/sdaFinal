package uk.ac.mmu.sdaFinal.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.dice.*;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.wormhole.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.position.Position;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.GameRulesConfig;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.play.PlayGame;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Provided;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.Required;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.GameRepository;
import uk.ac.mmu.sdaFinal.applicationcode.usecase.replay.ReplayGame;
import uk.ac.mmu.sdaFinal.infrastructure.driven.GameAdapter;
import uk.ac.mmu.sdaFinal.infrastructure.driven.InMemoryGameRepository;
import uk.ac.mmu.sdaFinal.infrastructure.driven.JsonGameRepository;

import java.util.List;

@Configuration
public class GameConfig {


  @Bean
  public GameRepository gameRepository() {
    //return new InMemoryGameRepository();
    return new JsonGameRepository();
  }

  @Bean
  public Required gameAdapter() {
    return new GameAdapter();
  }

  @Bean
  public ReplayGame replayGame(GameRepository repository, Required required) {
    return new ReplayGame(repository, required);
  }

  @Bean
  public Provided basicGame(Required required) {
    GameRulesConfig rules =
      new GameRulesConfig(
        2,
        false,
        false,
        false
      );

    DiceShaker dice = new RandomSingleDice();

    GameDefinition definition =
      new GameDefinition(
        rules,
        dice,
        List.of(),
        false
      );

    return new PlayGame(required, definition, gameRepository());
  }

  @Bean
  public Provided doubleGame(Required required) {
    GameRulesConfig rules =
      new GameRulesConfig(
        2,
        false,
        false,
        false
      );

    DiceShaker dice = new DiceShakerDecorator(new RandomSingleDice());

    GameDefinition definition =
      new GameDefinition(
        rules,
        dice,
        List.of(),
        false
      );

    return new PlayGame(required, definition, gameRepository());
  }

  @Bean
  public Provided exactEndGame(Required required) {
    GameRulesConfig rules =
      new GameRulesConfig(
        2,
        true,
        false,
        false
      );

    DiceShaker dice = new FixedDice(List.of(
      new DiceRoll(6),
      new DiceRoll(3),
      new DiceRoll(6),
      new DiceRoll(3),
      new DiceRoll(6),
      new DiceRoll(3),
      new DiceRoll(4),
      new DiceRoll(3),
      new DiceRoll(4),
      new DiceRoll(3),
      new DiceRoll(2)));

    GameDefinition definition =
      new GameDefinition(
        rules,
        dice,
        List.of(),
        false
      );

    return new PlayGame(required, definition, gameRepository());
  }

  @Bean
  public Provided hitGame(Required required) {
    GameRulesConfig rules =
      new GameRulesConfig(
        2,
        false,
        true,
        false
      );

    DiceShaker dice = new FixedDice(List.of(
      new DiceRoll(6),
      new DiceRoll(6),
      new DiceRoll(6),
      new DiceRoll(6),
      new DiceRoll(5),
      new DiceRoll(1),
      new DiceRoll(6),
      new DiceRoll(1),
      new DiceRoll(6),
      new DiceRoll(5),
      new DiceRoll(3)));

    GameDefinition definition =
      new GameDefinition(
        rules,
        dice,
        List.of(),
        false
      );

    return new PlayGame(required, definition, gameRepository());
  }

  @Bean
  public Provided largeBoardGame(Required required){
  GameRulesConfig rules =
    new GameRulesConfig(
      4,
      false,
      false,
      false
    );

    DiceShaker dice = new FixedDice(
      List.of(
        new DiceRoll(4),
        new DiceRoll(3),
        new DiceRoll(5),
        new DiceRoll(2),

        new DiceRoll(6),
        new DiceRoll(4),
        new DiceRoll(3),
        new DiceRoll(5),

        new DiceRoll(2),
        new DiceRoll(6),
        new DiceRoll(4),
        new DiceRoll(3),

        new DiceRoll(5),
        new DiceRoll(2),
        new DiceRoll(6),
        new DiceRoll(4),

        new DiceRoll(5),
        new DiceRoll(6),

        new DiceRoll(4),
        new DiceRoll(5),
        new DiceRoll(3),
        new DiceRoll(6),

        new DiceRoll(2),
        new DiceRoll(4),
        new DiceRoll(5),
        new DiceRoll(6),

        new DiceRoll(3),
        new DiceRoll(2),
        new DiceRoll(6),
        new DiceRoll(5)
      )
    );

  GameDefinition definition =
    new GameDefinition(
      rules,
      dice,
      List.of(),
      false
    );

    return new PlayGame(required, definition, gameRepository());
  }

  @Bean
  public Provided wormholeGame(Required required) {

    GameRulesConfig rules =
      new GameRulesConfig(
        2,
        false,
        false,
        true
      );

    DiceShaker dice = new FixedDice(List.of(
      new DiceRoll(6),
      new DiceRoll(1),
      new DiceRoll(1),
      new DiceRoll(1),
      new DiceRoll(6),
      new DiceRoll(1),
      new DiceRoll(6),
      new DiceRoll(1),
      new DiceRoll(6)));

    List<Wormhole> wormholes = List.of(
      new Wormhole(new Position(8), new Position(11))
    );

    GameDefinition definition =
      new GameDefinition(
        rules,
        dice,
        wormholes,
        false
      );

    return new PlayGame(required, definition, gameRepository());
  }

  @Bean
  public Provided allVariationsGame(Required required) {
    GameRulesConfig rules =
      new GameRulesConfig(
        4,
        true,
        true,
        true
      );

    DiceShaker dice = new DiceShakerDecorator(new RandomSingleDice());

    GameDefinition definition =
      new GameDefinition(
        rules,
        dice,
        List.of(),
        true
      );

    return new PlayGame(required, definition, gameRepository());
  }


}
