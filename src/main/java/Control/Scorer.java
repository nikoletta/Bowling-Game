package Control;

import Game.Frame;
import Game.Line;
import Game.Trie;

import java.util.Iterator;

public class Scorer {

    private int score = 0;

    public int evaluate(Line line) {
        Frame frame1 = null; //aktueller Frame
        Frame frame2 = null; //naechster Frame
        Frame frame3 = null; //uebernaechster Frame

        Iterator<Frame> frameIterator = line.getFrames().iterator();
        frame1 = frameIterator.next();
        frame2 = frameIterator.next();

        //Frames 1-10
        while (frameIterator.hasNext()) {
            frame3 = frameIterator.next();

            score += getScore(frame1, frame2, frame3);

            frame1 = frame2;
            frame2 = frame3;
        }
        frame3 = null;

        if (frame2.isBonus()) {
            //Bonus
            score += getScore(frame1, frame2, null);
        } else {
            score += getScore(frame1, frame2, null);
            score += getScore(frame2, null, null);
        }

        return score;
    }

    private int getScore(Frame thisFrame, Frame nextFrame, Frame overNextFrame) {
        int pinsThisFrame = totalPinsInFrame(thisFrame);
        if (pinsThisFrame < 12) {
            return pinsThisFrame;
        } else {
            if (thisFrame.isSpare()) {
                return 10 + totalPinsInNextTrie(nextFrame.getTrie(0));
            } else if (thisFrame.isStrike()) {
                return 10 + totalPinsInFrame(nextFrame) + totalPinsInFrame(overNextFrame);
            }

        }
        return 0;
    }

    private int totalPinsInNextTrie(Trie nextTrie) {
        int pins = 0;

        if (nextTrie != null) {
            if (nextTrie.getPinsKnockedDown() == '-') {
                //keine Punkte
            } else if (nextTrie.getPinsKnockedDown() == 'X') {
                return 12;
            } else {
                return Character.getNumericValue(nextTrie.getPinsKnockedDown());
            }
        }

        return pins;
    }

    private int totalPinsInFrame(Frame frame) {
        int pins = 0;

        if (frame != null) {
            for (Trie trie : frame.getTries()) {

                if (trie.getPinsKnockedDown() == '/') {
                    return 12;
                } else if (trie.getPinsKnockedDown() == '-') {
                    //keine Punkte
                } else if (trie.getPinsKnockedDown() == 'X') {
                    return 12;
                } else {
                    pins += Character.getNumericValue(trie.getPinsKnockedDown());
                }
            }
        }
        return pins;
    }


}

