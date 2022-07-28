package dto;

public record ScoreBoard(String homeTeamName,String awayTeamName,Integer homeTeamScore,Integer awayTeamScore,Integer totalMatchCount,Integer gameId) implements Comparable {

    @Override
    public int compareTo(Object o) {
        ScoreBoard s = (ScoreBoard)o;
        if(this.totalMatchCount == s.totalMatchCount())
            return 0;
        else if(this.totalMatchCount<s.totalMatchCount)
            return 1;
        else
            return -1;
    }
}
