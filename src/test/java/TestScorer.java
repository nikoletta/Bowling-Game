import Control.Scorer;
import junit.framework.Assert;
import org.junit.Test;

public class TestScorer {
    final static String ROLL1 = "5/5/5/5/5/5/5/5/5/5/5";
    final static String ROLL2 = "9-9-9-9-9-9-9-9-9-9-";
    final static String ROLL3 = "XXXXXXXXXXXX";

    @Test
    public void createScorerTest(){
        Scorer scorer = new Scorer();

        Assert.assertTrue(scorer != null);

        Assert.assertEquals(scorer.evaluate(ROLL1), 150);
        Assert.assertEquals(scorer.evaluate(ROLL2), 90);
        Assert.assertEquals(scorer.evaluate(ROLL3), 300);
    }
}
