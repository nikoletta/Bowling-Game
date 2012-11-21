package Game;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Trie> tries = new ArrayList<Trie>();
    private boolean isBonus= false;

    public Frame(){

    }

    public Frame(Trie trie) {
        tries.add(trie);
    }

    public Frame(Trie trie1, Trie trie2) {
        tries.add(trie1);
        tries.add(trie2);
    }

    public Trie getTrie(int i) {
        return tries.get(i);
    }

    public List<Trie> getTries() {
        return tries;
    }

    public boolean isSpare() {
         return tries.get(1).isSpare();
    }

    public boolean isStrike() {
        return tries.get(0).isStrike();
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean b) {
        isBonus = b;
    }
}
