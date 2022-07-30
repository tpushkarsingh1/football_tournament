import dto.ScoreBoard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import util.SortUtil;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class SortUtilTest {

    @InjectMocks
    SortUtil sortUtil = new SortUtil();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void checkCorrectSorting(){
        ScoreBoard score1 = new ScoreBoard(WordCupTestConstant.TEAMA,WordCupTestConstant.TEAMB,3,2,5,1);
        ScoreBoard score2 = new ScoreBoard(WordCupTestConstant.TEAMC,WordCupTestConstant.TEAMD,0,1,1,2);
        ScoreBoard score3 = new ScoreBoard(WordCupTestConstant.TEAME,WordCupTestConstant.TEAMF,2,2,4,3);
        ScoreBoard score4 = new ScoreBoard(WordCupTestConstant.TEAME,WordCupTestConstant.TEAMF,2,2,4,4);
        Map<Integer,ScoreBoard> dataMap = new HashMap<>();
        dataMap.put(score1.gameId(),score1);
        dataMap.put(score2.gameId(),score2);
        dataMap.put(score3.gameId(),score3);
        dataMap.put(score4.gameId(),score4);
        List<Integer> expectedResultGameId = Arrays.asList(score1.gameId(),score4.gameId(),score3.gameId(),score2.gameId());
        sortUtil.sortScoreBoard(dataMap);
        while (dataMap.size()>0) {
            Integer actualTopScorer = dataMap.entrySet().stream().findFirst().get().getValue().gameId();
            Optional<Integer> expectedTopScorer = expectedResultGameId.stream().findFirst();
            assertEquals(actualTopScorer, expectedTopScorer.get());
            dataMap.remove(actualTopScorer);
            expectedResultGameId.remove(expectedTopScorer);
        }


        }
}
