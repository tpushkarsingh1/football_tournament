import dto.Game;
import dto.ScoreBoard;
import dto.Team;
import dto.Tournament;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import worldcup.Starter;
import worldcup.impl.PlayFootBall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(MockitoJUnitRunner.class)
public class PlayFootBallTest {
    @InjectMocks
    @Spy
    PlayFootBall playFootBall;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkBeginGame() {
        Mockito.when(playFootBall.getTournamentFeed(1)).thenReturn(createDummyTournamentFeed());
        Assert.assertTrue((playFootBall.beginGame(1)).size()==4);
    }

    @Test
    public void checkBeginGameCheckTopScorerAndMostRecent() {
        Mockito.when(playFootBall.getTournamentFeed(1)).thenReturn(createDummyTournamentFeed());
        Assert.assertEquals((playFootBall.beginGame(1)).stream().findFirst().get().gameId(),WordCupTestConstant.TEAM4_GAME_ID);
    }
    @Test
    public void checkBeginGameWithNewEntryOfEqualScore() {
        var correctTourData = createDummyTournamentFeed();
        Team newHomeTeamData1 = new Team(WordCupTestConstant.TEAMA,5);
        Team newAwayTeamData1 = new Team(WordCupTestConstant.TEAMD,0);
        Game newGameData1 = new Game(newHomeTeamData1,newAwayTeamData1,WordCupTestConstant.TEAM5_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE);
        List<Game> updatedList = new ArrayList<>(correctTourData.games());
        updatedList.add(newGameData1);

        Mockito.when(playFootBall.getTournamentFeed(1)).thenReturn(new Tournament(updatedList));
        Assert.assertEquals((playFootBall.beginGame(1)).stream().findFirst().get().gameId(),WordCupTestConstant.TEAM5_GAME_ID);
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkBeginGameForInvalidSource() throws Exception {
        playFootBall.beginGame(10);
    }

    @Test
    public void testStarter(){
        Starter.main(null);
    }

    private Tournament createDummyTournamentFeed() {
        Team teamA = new Team(WordCupTestConstant.TEAMA,4);
        Team teamB = new Team(WordCupTestConstant.TEAMB,1);
        Team teamC = new Team(WordCupTestConstant.TEAMC,3);
        Team teamD = new Team(WordCupTestConstant.TEAMD,2);
        Team teamE = new Team(WordCupTestConstant.TEAME,2);
        Team teamF = new Team(WordCupTestConstant.TEAMF,3);
        Team teamG = new Team(WordCupTestConstant.TEAMG,1);
        Team teamH = new Team(WordCupTestConstant.TEAMH,4);
        Game game1 = new Game(teamA,teamB,WordCupTestConstant.TEAM1_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE);
        Game game2 = new Game(teamC,teamD,WordCupTestConstant.TEAM2_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE);
        Game game3 = new Game(teamE,teamF,WordCupTestConstant.TEAM3_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE);
        Game game4 = new Game(teamG,teamH,WordCupTestConstant.TEAM4_GAME_ID,WordCupTestConstant.TEST_MATCH_DATE);
        return new Tournament(Arrays.asList(game1,game2,game3,game4));
    }
}
