package uk.ac.mmu.sdaFinal.applicationcode.usecase.replay;

import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.board.Wormhole;
import uk.ac.mmu.sdaFinal.applicationcode.domainmodel.rules.GameRulesConfig;

import java.util.List;

public class GamePlayed {

  private String gameId;

  private GameRulesConfig rules;

  private List<Integer> diceRolls;

  private List<Wormhole> wormholes;

  public GamePlayed() {
  }

  public GamePlayed(String gameId, GameRulesConfig rules, List<Integer> diceRolls, List<Wormhole> wormholes) {
    this.gameId = gameId;
    this.rules = rules;
    this.diceRolls = diceRolls;
    this.wormholes = wormholes;
  }

  public String getGameId() {
    return gameId;
  }

  public void setGameId(String gameId) {
    this.gameId = gameId;
  }

  public GameRulesConfig getRules() {
    return rules;
  }

  public void setRules(GameRulesConfig rules) {
    this.rules = rules;
  }

  public List<Integer> getDiceRolls() {
    return diceRolls;
  }

  public void setDiceRolls(List<Integer> diceRolls) {
    this.diceRolls = diceRolls;
  }

  public List<Wormhole> getWormholes() {
    return wormholes;
  }

  public void setWormholes(List<Wormhole> wormholes) {
    this.wormholes = wormholes;
  }
}
