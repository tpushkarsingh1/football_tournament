package worldcup.impl;

import dto.Game;
import dto.ScoreBoard;
import worldcup.PlayGame;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayFootBall implements PlayGame {

    Map<Integer,ScoreBoard> responseMap = new LinkedHashMap<>();

    @Override
    public Map<Integer, ScoreBoard> beginGame(Integer feedSource) {
        return responseMap;
    }

    private void fetchScoreBoardResponse(Game game) {

    }

    private void printScore(ScoreBoard scoreBoard){

    }
}
