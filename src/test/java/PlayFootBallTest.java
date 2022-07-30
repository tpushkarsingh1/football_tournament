import dto.Game;
import dto.Team;
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
       Assert.assertTrue((playFootBall.beginGame(1)).size()==5);
    }

    @Test
    public void checkBeginGameCheckTopScorer() {
        Assert.assertEquals((playFootBall.beginGame(1)).entrySet().stream().findFirst().get().getValue().gameId(),"UruItl1");
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkBeginGameForInvalidSource() throws Exception {
        playFootBall.beginGame(10);
    }
}
