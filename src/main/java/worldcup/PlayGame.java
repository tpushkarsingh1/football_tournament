package worldcup;

import dto.ScoreBoard;

import java.util.Map;

public interface PlayGame {
    Map<String, ScoreBoard> beginGame(Integer feedSource);
}
