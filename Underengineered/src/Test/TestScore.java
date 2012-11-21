package Test;

import junit.framework.Assert;
import org.junit.Test;

import java.CreateScore;

/**
 * Created by IntelliJ IDEA.
 * User: my
 * Date: 21.11.12
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
public class TestScore {

    @Test
    public void testScore() {

        final String ROLL4 = "--------------------";   //0
        final String ROLL5 = "1-------------------";  //1
        final String ROLL6 = "11111111111111111111";  //20*1 = 20
        final String ROLL7 = "1/1-----------------";  //10+1 +1=12
        final String ROLL8 = "X11----------------";  //10+1+1  1+1=14

        final String ROLL1 = "5/5/5/5/5/5/5/5/5/5/5";
        final String ROLL2 = "9-9-9-9-9-9-9-9-9-9-";
        final String ROLL3 = "XXXXXXXXXXXX";

        CreateScore scorer = new CreateScore();
        Assert.assertTrue("Score von -------------------- falsch.", scorer.createScore(ROLL4) == 0);
        Assert.assertEquals("Score von 1------------------- falsch.", 1, scorer.createScore(ROLL5));
        Assert.assertEquals("Score von 11111111111111111111 falsch.", 20, scorer.createScore(ROLL6));
        Assert.assertEquals("Score von 1/1----------------- falsch.", 12, scorer.createScore(ROLL7));
        Assert.assertEquals("Score von X11---------------- falsch.", 14, scorer.createScore(ROLL8));
        Assert.assertEquals("Score von 5/5/5/5/5/5/5/5/5/5/5 falsch.", 150, scorer.createScore(ROLL1));
        Assert.assertEquals("Score von 9-9-9-9-9-9-9-9-9-9- falsch.", 90, scorer.createScore(ROLL2));
        Assert.assertEquals("Score von XXXXXXXXXXXX falsch.", 300, scorer.createScore(ROLL3));
    }

}
