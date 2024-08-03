package nz.ac.auckland.se281;

import java.util.ArrayList;

public class StrategySystem {

  private Strategy strategy;

  public StrategySystem(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getSum(int fingers, ArrayList fingersplayed) {
    return strategy.getStrategySum(fingers, fingersplayed);
  }
}
