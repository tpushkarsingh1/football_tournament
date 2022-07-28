package worldcup;

import dto.Game;
import dto.ScoreBoard;

import java.util.Map;

public interface PlayGame {
    Map<Integer, ScoreBoard> beginGame(Integer feedSource);
}
