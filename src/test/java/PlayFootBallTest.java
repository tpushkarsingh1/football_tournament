import dto.Game;
import dto.Team;
import exceptions.InvalidDataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import worldcup.impl.PlayFootBall;

@RunWith(MockitoJUnitRunner.class)
public class PlayFootBallTest {

    @InjectMocks
    PlayFootBall playFootBall = new PlayFootBall();

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
        return new Game(new Team(WordCupTestConstant.TEAMA),new Team(WordCupTestConstant.TEAMB),WordCupTestConstant.TEAM1_GAME_ID,WordCupTestConstant.TEST_SCORE);
    }
}
