import Game.Line;
import junit.framework.Assert;
import org.junit.Test;

public class TestLine {

    @Test
    public void createLineTest(){
        Line line = new Line();
        Assert.assertTrue(line != null);
    }
}
