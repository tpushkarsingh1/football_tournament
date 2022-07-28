import dto.Game;
import dto.Team;
import dto.Tournament;
import exceptions.InvalidDataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import util.FeedUtility;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class FeedUtilityTest {

@InjectMocks
FeedUtility feedUtility = new FeedUtility();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void fetchTournamentFeedForSource1() {
        Tournament tournament = feedUtility.fetchTournamentFeed(1);
        Assert.assertEquals(tournament!=null,true);
    }

    @Test
    public void fetchTournamentFeedForInvalidSource() {
        Tournament tournament = feedUtility.fetchTournamentFeed(10);
        Assert.assertEquals(tournament,null);
    }

    @Test(expected = InvalidDataException.class)
    public void checkGoalWithNullValue(){
        Throwable e = null;
        Tournament nullScoreGame = new Tournament(Arrays.asList(new Game(new Team(WordCupTestConstant.TEAMA),new Team(WordCupTestConstant.TEAMB),WordCupTestConstant.TEAM1_GAME_ID,null)));
        Mockito.when(feedUtility.fetchDataForFootball()).thenReturn(nullScoreGame);
        feedUtility.fetchTournamentFeed(1);
    }

    @Test(expected = InvalidDataException.class)
    public void checkGoalWithNegativeValue(){
        Throwable e = null;
        Tournament nullScoreGame = new Tournament(Arrays.asList(new Game(new Team(WordCupTestConstant.TEAMA),new Team(WordCupTestConstant.TEAMB),WordCupTestConstant.TEAM1_GAME_ID,-1)));
        Mockito.when(feedUtility.fetchDataForFootball()).thenReturn(nullScoreGame);
        feedUtility.fetchTournamentFeed(1);
    }

}
