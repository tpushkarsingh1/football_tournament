package worldcup.impl;

import dto.Game;
import dto.ScoreBoard;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.FeedUtility;
import util.SortUtil;
import worldcup.PlayGame;
import worldcup.PrintScoreCard;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlayFootBall implements PlayGame {

    Logger logger = LoggerFactory.getLogger(PlayFootBall.class);
    Map<String, ScoreBoard> responseMap = new LinkedHashMap<>();

    @Override
    public List<ScoreBoard> beginGame(Integer feedSource) {
        var tournament = getTournamentFeed(feedSource);
        List finalScore = new ArrayList<ScoreBoard>();
        try {
            tournament.games().forEach(s -> fetchScoreBoardResponse(s));
            //sort based on number of goals secured + match which has the latest goal secured
            finalScore = (new SortUtil()).sortScoreBoard(responseMap);
            new PrintScoreCard().printResults(finalScore);
        } catch (Exception e) {
            logger.error("Exception occurred while parsing game data");
        }
        return finalScore;
    }

    public Tournament getTournamentFeed(Integer feedSource) {
        return new FeedUtility().fetchTournamentFeed(feedSource);
    }

    private void fetchScoreBoardResponse(Game game) {
        var homeTeamScore = game.homeTeam().teamScore()>1?1:game.homeTeam().teamScore();
        var awayTeamScore = game.awayTeam().teamScore()>1?1:game.awayTeam().teamScore();
        var response = responseMap.get(game.gameId());
        //remove the last entry and do entry again in map to keep the latest record sequence updated.
        responseMap.remove(game.gameId());
        if (response != null) {
            var awayTeamTotalScore = response.awayTeamScore() + awayTeamScore;
            var homeTeamTotalScore = response.homeTeamScore() + homeTeamScore;
            response = new ScoreBoard(
                    game.homeTeam().teamName(),
                    game.awayTeam().teamName(),
                    homeTeamTotalScore
                    , awayTeamTotalScore
                    , awayTeamTotalScore + homeTeamTotalScore
                    , game.gameId());
        } else {
            response = new ScoreBoard(
                    game.homeTeam().teamName(),
                    game.awayTeam().teamName(),
                    0, 0, 0,
                    game.gameId());
        }
        responseMap.put(game.gameId(), response);
    }
}
