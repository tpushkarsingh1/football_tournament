package worldcup.impl;

import dto.Game;
import dto.ScoreBoard;
import dto.Team;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.FeedUtility;
import util.SortUtil;
import worldcup.PlayGame;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PlayFootBall implements PlayGame {
    Logger logger = LoggerFactory.getLogger(PlayFootBall.class);
    Map<String,ScoreBoard> responseMap = new LinkedHashMap<>();

    @Override
    public Map<String, ScoreBoard> beginGame(Integer feedSource) {
        return responseMap;
    }

    private void fetchScoreBoardResponse(Game game) {
    }

    private void printScore(ScoreBoard scoreBoard){

    }

}
