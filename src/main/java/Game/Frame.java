package Game;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    int score;
    private List<Trie> tries = new ArrayList<Trie>();

    public Frame(Trie trie) {
        tries.add(trie);
    }

    public Frame(Trie trie1, Trie trie2) {
        tries.add(trie1);
        tries.add(trie2);
    }

    public Frame() {

    }

    public int getScore() {
        return score;
    }

    public Trie getTrie(int i) {
        return tries.get(i);
    }

    public List<Trie> getTries() {
        return tries;
    }
}
