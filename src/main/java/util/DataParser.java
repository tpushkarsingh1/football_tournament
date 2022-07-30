package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Tournament;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataParser {
    Logger logger = LoggerFactory.getLogger(DataParser.class);

    public Tournament fetchDataForFootball(ObjectMapper mapper) {
        logger.info("Inside fetchDataForFootball starting parsing");
        return null;
    }

    private boolean isValidScore(Integer teamScore) {
        boolean isValid = false;
        return isValid;
    }
}
