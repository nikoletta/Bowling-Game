import Control.GameBuilder;
import junit.framework.Assert;
import org.junit.Test;

public class TestGameBuilder {
    static final String TESTGAME1 = "XXXXXXXXXXXX";
    static final String TESTGAME2 = "9-9-9-9-9-9-9-9-9-9-";
    static final String TESTGAME3 = "5/5/5/5/5/5/5/5/5/5/5";

    @Test
    public void createGameBuilderTest() {
        {
            GameBuilder gameBuilder = new GameBuilder(TESTGAME1);

            Assert.assertTrue(gameBuilder.getLine() != null);
            Assert.assertEquals(gameBuilder.getLine().getFrames().size(), 12);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(10).isFinalFrame(), false);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(11).isBonus(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(12).isBonus(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(12).isFinalFrame(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(2).getTrie(1).isStrike(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(2).getTrie(2).isNotThrown(), true);

        }
        {
            GameBuilder gameBuilder = new GameBuilder(TESTGAME2);

            Assert.assertTrue(gameBuilder.getLine() != null);
            Assert.assertEquals(gameBuilder.getLine().getFrames().size(), 10);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(10).isFinalFrame(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(10).isBonus(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(1).getTrie(1).isMiss(), false);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(1).getTrie(2).isMiss(), true);

        }
        {
            GameBuilder gameBuilder = new GameBuilder(TESTGAME3);

            Assert.assertTrue(gameBuilder.getLine() != null);
            Assert.assertEquals(gameBuilder.getLine().getFrames().size(), 11);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(10).isFinalFrame(), false);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(11).isFinalFrame(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(11).isBonus(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(1).getTrie(1).isSpare(), false);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(1).getTrie(2).isSpare(), true);

        }
    }
}
