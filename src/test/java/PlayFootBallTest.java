import dto.Game;
import dto.Team;
import exceptions.InvalidDataException;
import org.junit.Assert;
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
import worldcup.impl.PlayFootBall;


@RunWith(MockitoJUnitRunner.class)
public class PlayFootBallTest {

    @InjectMocks
    PlayFootBall playFootBall;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkBeginGame() {
       Assert.assertTrue((playFootBall.beginGame(1)).size()>1);
    }


    @Test(expected = InvalidDataException.class)
    public void checkBeginGameForInvalidSource() {
        playFootBall.beginGame(10);
    }
    private Game createGame(){
        return new Game(new Team(WordCupTestConstant.TEAMA,WordCupTestConstant.TEST_SCORE_0),new Team(WordCupTestConstant.TEAMB,WordCupTestConstant.TEST_SCORE_1),WordCupTestConstant.TEAM1_GAME_ID, WordCupTestConstant.TEST_MATCH_DATE);
    }
}
