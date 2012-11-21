import Game.Frame;
import Game.Trie;
import org.junit.Assert;
import org.junit.Test;


public class TestCreateFrame {
    private Trie trie1 = new Trie('1');
    private Trie trie2 = new Trie('1');
    private Trie trie3 = new Trie('X');
    private Trie trie4 = new Trie('2');
    private Trie trie5 = new Trie('-');
    private Trie trie6 = new Trie('/');


    @Test
    public void testCreateFrame() {

        {
            Frame frame = new Frame(trie1, trie2);
            Assert.assertTrue(frame != null);
//            Assert.assertEquals(frame.getScore(), 3);
//        }
//
//        {
//            Frame frame = new Frame(trie3);
//            Assert.assertEquals(frame.getScore(), 10);
//        }
//
//        {
//            Frame frame = new Frame(trie4, trie5);
//            Assert.assertEquals(frame.getScore(), 2);
//        }
//
//        {
//            Frame frameSpare = new Frame(trie4, trie6);
//            Frame frameNext = new Frame(trie1, trie2);
//            Assert.assertEquals(frameSpare.getScore(), 10 + frameNext.getScore());
//            Assert.assertEquals(frameSpare.getScore(),12);
//
        }

    }

}
