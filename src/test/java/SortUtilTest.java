import dto.ScoreBoard;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import util.SortUtil;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SortUtilTest {

    @InjectMocks
    SortUtil sortUtil = new SortUtil();
    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void checkCorrectSorting(){
        ScoreBoard score1 = new ScoreBoard(WordCupTestConstant.TEAMA,WordCupTestConstant.TEAMB,3,2,5,WordCupTestConstant.TEAMA);
        ScoreBoard score2 = new ScoreBoard(WordCupTestConstant.TEAMC,WordCupTestConstant.TEAMD,0,1,1,WordCupTestConstant.TEAMC);
        ScoreBoard score3 = new ScoreBoard(WordCupTestConstant.TEAME,WordCupTestConstant.TEAMF,2,2,4,WordCupTestConstant.TEAME);
        ScoreBoard score4 = new ScoreBoard(WordCupTestConstant.TEAME,WordCupTestConstant.TEAMF,2,2,4,WordCupTestConstant.TEAMG);
        Map<String,ScoreBoard> dataMap = new HashMap<>();
        dataMap.put(score1.gameId(),score1);
        dataMap.put(score2.gameId(),score2);
        dataMap.put(score3.gameId(),score3);
        dataMap.put(score4.gameId(),score4);
        List<String> expectedResultGameId = Arrays.asList(score1.gameId(),score4.gameId(),score3.gameId(),score2.gameId());
        sortUtil.sortScoreBoard(dataMap);
        while (dataMap.size()>0) {
            String actualTopScorer = dataMap.entrySet().stream().findFirst().get().getValue().gameId();
            Optional<String> expectedTopScorer = expectedResultGameId.stream().findFirst();
            assertEquals(actualTopScorer, expectedTopScorer.get());
            dataMap.remove(actualTopScorer);
            expectedResultGameId.remove(expectedTopScorer);
        }


        }
}
