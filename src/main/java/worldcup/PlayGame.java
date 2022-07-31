package worldcup;

import dto.ScoreBoard;

import java.util.List;

public interface PlayGame {
    List<ScoreBoard> beginGame(Integer feedSource);
}
