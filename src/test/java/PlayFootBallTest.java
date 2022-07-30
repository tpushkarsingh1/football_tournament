import dto.Game;
import dto.Team;
import exceptions.InvalidDataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import worldcup.impl.PlayFootBall;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("jdk.internal.reflect.*")
public class PlayFootBallTest {

    @InjectMocks
    PlayFootBall playFootBall;

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
