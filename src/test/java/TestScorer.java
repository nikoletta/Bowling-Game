import Control.GameBuilder;
import Control.Scorer;
import junit.framework.Assert;
import org.junit.Test;

public class TestScorer {
    final static String ROLL1 = "5/5/5/5/5/5/5/5/5/5/5";
    final static String ROLL2 = "9-9-9-9-9-9-9-9-9-9-";
    final static String ROLL3 = "XXXXXXXXXXXX";

    @Test
    public void createScorerTest() throws Exception{

        {
            GameBuilder testGame = new GameBuilder(ROLL1);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            if(score != 150){
                throw new Exception("Score falsch");
            }
            Assert.assertEquals(score, 150);
        }

        {
            GameBuilder testGame = new GameBuilder(ROLL2);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(score, 90);
        }

        {
            GameBuilder testGame = new GameBuilder(ROLL3);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(score, 300);
        }
    }
}
