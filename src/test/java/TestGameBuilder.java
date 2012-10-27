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
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(1).getTrie(0).isStrike(), true);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(1).getTrie(1).isNotThrown(), true);

        }
        {
            GameBuilder gameBuilder = new GameBuilder(TESTGAME2);

            Assert.assertTrue(gameBuilder.getLine() != null);
            Assert.assertEquals(gameBuilder.getLine().getFrames().size(), 10);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(0).getTrie(0).isMiss(), false);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(0).getTrie(1).isMiss(), true);

        }
        {
            GameBuilder gameBuilder = new GameBuilder(TESTGAME3);

            Assert.assertTrue(gameBuilder.getLine() != null);
            Assert.assertEquals(gameBuilder.getLine().getFrames().size(), 11);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(0).getTrie(0).isSpare(), false);
            Assert.assertEquals(gameBuilder.getLine().getFrames().get(0).getTrie(1).isSpare(), true);

        }
    }
}
