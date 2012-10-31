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
        frame3 = frameIterator.next();

        //Frames 1-10
        while (frameIterator.hasNext()) {
            score += getScore(frame1, frame2, frame3);

            frame1 = frame2;
            frame2 = frame3;
        }
        //Frame 11

        //Frame 12

        return score;
    }

    private int getScore(Frame thisFrame, Frame nextFrame, Frame overNextFrame) {
        int pinsThisFrame = totalPinsInFrame(thisFrame);
        if (pinsThisFrame < 12) {
            return pinsThisFrame;
        } else {
            if (thisFrame.isSpare()) {
                return 10 + totalPinsInFrame(nextFrame);
            } else if (thisFrame.isStrike()) {
                return 10 + totalPinsInFrame(nextFrame) + totalPinsInFrame(overNextFrame);
            }

        }

    }

    private int totalPinsInFrame(Frame frame) {
        int pins = 0;

        for (Trie trie : frame.getTries()) {

            if (trie.getPinsKnockedDown() == '/') {
                return 12;
            } else if (trie.getPinsKnockedDown() == '-') {
                //keine Punkte
            } else if (trie.getPinsKnockedDown() == 'X') {
                return 12;
            } else {
                pins += trie.getPinsKnockedDown();
            }
        }
        return pins;
    }


}

