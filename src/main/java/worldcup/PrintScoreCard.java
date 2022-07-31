package worldcup;

import dto.ScoreBoard;

import java.util.List;

public class PrintScoreCard {
    public void printResults(List<ScoreBoard> scoreBoard) {

        scoreBoard.forEach(s->
        System.out.printf("""
                %s %s - %s %s
                """,s.homeTeamName(),s.homeTeamScore(),s.awayTeamName(),s.awayTeamScore()));
    }
}
