package Game;

public class Trie {
    char pinsKnockedDown;
    private boolean notThrown;

    public Trie(char pinsKnockedDown) {
        this.pinsKnockedDown = pinsKnockedDown;
    }

    public char getPinsKnockedDown() {
        return pinsKnockedDown;
    }

    public boolean isNotThrown() {
        return notThrown;
    }

    public boolean isSpare() {
        if (pinsKnockedDown == '/') return true;
        else return false;
    }

    public boolean isMiss() {
        if (pinsKnockedDown == '-') return true;
        else return false;
    }

    public boolean isStrike() {
        if (pinsKnockedDown == 'X') return true;
        else return false;
    }
}
