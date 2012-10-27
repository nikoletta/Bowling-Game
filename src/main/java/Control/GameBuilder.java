package Control;

import Game.Frame;
import Game.Line;
import Game.Trie;

public class GameBuilder {

    private Line line;

    public GameBuilder(String game) {
        line = new Line();
        setUpGame(game);
    }

    private void setUpGame(String game) {
        Frame frame = new Frame();
        char[] tries = game.toCharArray();

        int counter = 0;
        for (char t : tries) {
            if (counter == 0) {
                frame = new Frame();
                line.getFrames().add(frame);
            }

            Trie trie = new Trie(t);
            frame.getTries().add(trie);

            if (t != 'X') {
                if (counter == 0) {
                    counter++;
                } else {
                    counter = 0;
                }

            } else {
                Trie emptyTrie = new Trie('0');
                frame.getTries().add(emptyTrie);
                counter = 0;
            }
        }
    }


    public Line getLine() {
        return line;
    }
}
