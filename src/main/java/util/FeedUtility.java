package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Game;
import dto.Team;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FeedUtility {
ObjectMapper mapper = new ObjectMapper();
    public Tournament fetchTournamentFeed(Integer feedSource) {
        Tournament tournament = switch (feedSource) {
            case 1 ->  new DataParser().fetchDataForFootball(mapper);
            default ->  throw new IllegalArgumentException("Please provide correct source. Supported Sources is 1.");
        };
        return tournament;
    }
}
