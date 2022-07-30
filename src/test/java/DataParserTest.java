import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Game;
import dto.Team;
import dto.Tournament;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import util.DataParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class DataParserTest {
@InjectMocks
DataParser parser;
@Mock
ObjectMapper mapper;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    public void checkGoalWithNullValueAreFiltered() throws IOException {
        Tournament nullScoreGame = new Tournament(Arrays.asList(new Game(new Team(WordCupTestConstant.TEAMA,null),new Team(WordCupTestConstant.TEAMB,null),WordCupTestConstant.TEAM1_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE)));
        Mockito.when(mapper.readValue(Mockito.any(InputStream.class),Mockito.any(TypeReference.class))).thenReturn(nullScoreGame);
        Assert.assertEquals(parser.fetchDataForFootball(mapper).games().size(),0);

    }

    @Test
    public void checkGoalWithNegativeValueAreFiltered() throws IOException {
        Tournament nullScoreGame = new Tournament(Arrays.asList(new Game(new Team(WordCupTestConstant.TEAMA,-1),new Team(WordCupTestConstant.TEAMB,null),WordCupTestConstant.TEAM1_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE)));
        Mockito.when(mapper.readValue(Mockito.any(InputStream.class),Mockito.any(TypeReference.class))).thenReturn(nullScoreGame);
        Assert.assertEquals(parser.fetchDataForFootball(mapper).games().size(),0);
    }
}
