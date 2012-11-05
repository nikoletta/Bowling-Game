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

        int counterFrames = 0;
        int counterTries = 0;
        for (char t : tries) {
            if (counterTries == 0) {
                frame = new Frame();
                line.getFrames().add(frame);

                counterFrames++;
                if(counterFrames > 10){
                    frame.setBonus(true);
                }
            }

            Trie trie = new Trie(t);
            frame.getTries().add(trie);

            if (t != 'X') {
                if (counterTries == 0) {
                    counterTries++;
                } else {
                    counterTries = 0;
                }

            } else {
                Trie emptyTrie = new Trie('0');
                frame.getTries().add(emptyTrie);
                counterTries = 0;
            }
        }
    }


    public Line getLine() {
        return line;
    }
}
