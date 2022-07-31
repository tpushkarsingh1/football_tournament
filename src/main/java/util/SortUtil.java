package util;

import dto.ScoreBoard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortUtil {

    public List<ScoreBoard> sortScoreBoard(Map<String, ScoreBoard> responseMap){
        List<ScoreBoard> responses  = new LinkedList<>();
        responseMap.entrySet().forEach(s->responses.add(s.getValue()));
        Collections.reverse(responses);
        responses.stream().forEach(s->s.totalMatchScore());
        Collections.sort(responses);
        return responses;
    }
}
