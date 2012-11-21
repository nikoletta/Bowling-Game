import Game.Trie;
import org.junit.Assert;
import org.junit.Test;

public class TestCreateTrie {
    final static char pins1 = '1';
    final static char pins2 = 'X';
    final static char pins3 = '-';
    final static char pins4 = '/';

    @Test
    public void testCreateTrie() {

        {
            Trie trie = new Trie(pins1);
            Assert.assertTrue(trie != null);
            Assert.assertEquals(trie.getPinsKnockedDown(),pins1);
            Assert.assertFalse(trie.isStrike());
            Assert.assertFalse(trie.isNotThrown());
            Assert.assertFalse(trie.isMiss());
            Assert.assertFalse(trie.isSpare());
        }

        {
            Trie trie = new Trie(pins2);
            Assert.assertTrue(trie != null);
            Assert.assertEquals(trie.getPinsKnockedDown(),pins2);
            Assert.assertTrue(trie.isStrike());
            Assert.assertFalse(trie.isNotThrown());
            Assert.assertFalse(trie.isMiss());
            Assert.assertFalse(trie.isSpare());
        }

        {
            Trie trie = new Trie(pins3);
            Assert.assertTrue(trie != null);
            Assert.assertEquals(trie.getPinsKnockedDown(),pins3);
            Assert.assertFalse(trie.isStrike());
            Assert.assertFalse(trie.isNotThrown());
            Assert.assertTrue(trie.isMiss());
            Assert.assertFalse(trie.isSpare());
        }

        {
            Trie trie = new Trie(pins4);
            Assert.assertTrue(trie != null);
            Assert.assertEquals(trie.getPinsKnockedDown(),pins4);
            Assert.assertFalse(trie.isStrike());
            Assert.assertFalse(trie.isNotThrown());
            Assert.assertFalse(trie.isMiss());
            Assert.assertTrue(trie.isSpare());
        }
    }
}
