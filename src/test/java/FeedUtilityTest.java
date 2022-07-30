import dto.Game;
import dto.Team;
import dto.Tournament;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import util.FeedUtility;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class FeedUtilityTest {
@InjectMocks
FeedUtility feedUtility;

@Rule
public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
    @Test
    public void fetchTournamentFeedForSource1() {
        Tournament nullScoreGame = new Tournament(Arrays.asList(new Game(new Team(WordCupTestConstant.TEAMA,null),new Team(WordCupTestConstant.TEAMB,null),WordCupTestConstant.TEAM1_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE)));
        Tournament tournament = feedUtility.fetchTournamentFeed(1);
        Assert.assertEquals(tournament!=null,true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fetchTournamentFeedForInvalidSource() {
        Tournament tournament = feedUtility.fetchTournamentFeed(10);
        Assert.assertEquals(tournament,null);
    }
}
