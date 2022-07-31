package dto;

public record  ScoreBoard(String homeTeamName,String awayTeamName,Integer homeTeamScore,Integer awayTeamScore,Integer totalMatchScore,String gameId) implements Comparable {

    @Override
    public int compareTo(Object o) {
        ScoreBoard s = (ScoreBoard)o;
        if(this.totalMatchScore == s.totalMatchScore())
            return 0;
        else if(this.totalMatchScore<s.totalMatchScore)
            return 1;
        else
            return -1;
    }
}
