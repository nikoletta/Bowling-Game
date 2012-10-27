import Control.GameBuilder;
import Control.Scorer;
import junit.framework.Assert;
import org.junit.Test;

public class TestScorer {
    final static String ROLL1 = "5/5/5/5/5/5/5/5/5/5/5";
    final static String ROLL2 = "9-9-9-9-9-9-9-9-9-9-";
    final static String ROLL3 = "XXXXXXXXXXXX";

    @Test
    public void createScorerTest() {

        {
            GameBuilder testGame = new GameBuilder(ROLL1);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            Assert.assertEquals(scorer.evaluate(testGame.getLine()), 150);
        }

        {
            GameBuilder testGame = new GameBuilder(ROLL2);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            Assert.assertEquals(scorer.evaluate(testGame.getLine()), 90);
        }

        {
            GameBuilder testGame = new GameBuilder(ROLL3);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            Assert.assertEquals(scorer.evaluate(testGame.getLine()), 300);
        }
    }
}
