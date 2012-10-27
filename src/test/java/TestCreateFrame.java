import Game.Frame;
import org.junit.Assert;
import org.junit.Test;


public class TestCreateFrame {

    @Test
    public void testCreateFrame(){
        Frame frame = new Frame();

        Assert.assertTrue(frame != null);


    }

}
