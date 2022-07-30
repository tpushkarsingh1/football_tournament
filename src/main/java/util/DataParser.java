package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Game;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class DataParser {
    Logger logger = LoggerFactory.getLogger(DataParser.class);

    public Tournament fetchDataForFootball(ObjectMapper mapper) {
        logger.info("Inside fetchDataForFootball starting parsing");
        Tournament tournament = null;
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("feedData.json")){
            tournament = mapper.readValue(in,new TypeReference<Tournament>(){});
            Predicate<Game> removeNullAndNegativeScore = data ->{
                return (isValidScore(data.homeTeam().teamScore()) &&
                        isValidScore(data.awayTeam().teamScore()));
            };
            return new Tournament(tournament.games().stream().filter(removeNullAndNegativeScore).collect(Collectors.toList()));

        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error parsing Data inside fetchDataFromResources");
        }
        return tournament;
    }

    private boolean isValidScore(Integer teamScore) {
        boolean isValid = false;
        if(teamScore!= null && teamScore>=0){
            isValid = true;
        }
        return isValid;
    }
}
