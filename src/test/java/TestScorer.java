import Control.GameBuilder;
import Control.Scorer;
import junit.framework.Assert;
import org.junit.Test;

public class TestScorer {
    final static String ROLL1 = "5/5/5/5/5/5/5/5/5/5/5";
    final static String ROLL2 = "9-9-9-9-9-9-9-9-9-9-";
    final static String ROLL3 = "XXXXXXXXXXXX";
    final static String ROLL4 = "--------------------";   //0
    final static String ROLL5 = "1-------------------";  //1
    final static String ROLL6 = "11111111111111111111";  //20*1 = 20
    final static String ROLL7 = "1/1-----------------";  //10+1 +1=12
    final static String ROLL8 = "X11----------------";  //10+1+1  1+1=14



    @Test
    public void createScorerTest() throws Exception{

        {
            GameBuilder testGame = new GameBuilder(ROLL2);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(score, 90);
        }

        {
            GameBuilder testGame = new GameBuilder(ROLL1);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            if(score != 150){
                throw new Exception("Score falsch");
            }
            Assert.assertEquals(150, score);
        }


        {
            GameBuilder testGame = new GameBuilder(ROLL3);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(300, score);
        }

         {
            GameBuilder testGame = new GameBuilder(ROLL4);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(0,score);
        }

         {
            GameBuilder testGame = new GameBuilder(ROLL5);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(1, score);
        }

         {
            GameBuilder testGame = new GameBuilder(ROLL6);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(20, score);
        }

         {
            GameBuilder testGame = new GameBuilder(ROLL7);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(12,score);
        }

         {
            GameBuilder testGame = new GameBuilder(ROLL8);
            Scorer scorer = new Scorer();
            Assert.assertTrue(scorer != null);
            int score = scorer.evaluate(testGame.getLine());
            Assert.assertEquals(14,score);
        }
    }
}
