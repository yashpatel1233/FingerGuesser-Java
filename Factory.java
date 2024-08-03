package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Factory {

  public static Difficulties createHandStrategy(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        return new EasyDifficulty();

      case MEDIUM:
        return new MediumDifficulty();

      case HARD:
        return new HardDifficulty();

      case MASTER:
        return new MasterDifficulty();

      default:
        return null; // should never happen
    }
  }
}
