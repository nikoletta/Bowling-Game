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

        //Frames
        while (frameIterator.hasNext()) {
            frame3 = frameIterator.next();
            if (!frame3.isBonus()) {
                score += getScore(frame1, frame2, frame3);
                if (!frameIterator.hasNext()) {
                    score += getScore(frame1, frame2, null);
                    score += getScore(frame1, null, null);
                }

            } else {
                if (!frame2.isBonus()) {
                    score += getScore(frame1, frame2, frame3);
                    score += getScore(frame1, frame2, null);
                }else{
                    score += totalScoreInFrame(frame3);
                }
            }
            frame1 = frame2;
            frame2 = frame3;
            frame3 = null;
        }


        return score;
    }

    private int getScore(Frame thisFrame, Frame nextFrame, Frame overNextFrame) {
        int scoreThisFrame = totalScoreInFrame(thisFrame);
        if (scoreThisFrame < 10) {
            return scoreThisFrame;
        } else {
            if (thisFrame.isSpare()) {
                return 10 + totalScoreInNextTrie(nextFrame.getTrie(0));
            } else if (thisFrame.isStrike()) {
                return 10 + totalScoreInFrame(nextFrame) + totalScoreInFrame(overNextFrame);
            }

        }
        return 0;
    }

    private int totalScoreInNextTrie(Trie nextTrie) {
        int pins = 0;

        if (nextTrie != null) {
            if (nextTrie.getPinsKnockedDown() == '-') {
                //keine Punkte
            } else if (nextTrie.getPinsKnockedDown() == 'X') {
                return 10;
            } else {
                return Character.getNumericValue(nextTrie.getPinsKnockedDown());
            }
        }

        return pins;
    }

    private int totalScoreInFrame(Frame frame) {
        int score = 0;

        if (frame != null) {
            for (Trie trie : frame.getTries()) {

                if (trie.getPinsKnockedDown() == '/') {
                    return 10;
                } else if (trie.getPinsKnockedDown() == '-') {
                    //keine Punkte
                } else if (trie.getPinsKnockedDown() == 'X') {
                    return 10;
                } else {
                    score += Character.getNumericValue(trie.getPinsKnockedDown());
                }
            }
        }
        return score;
    }


}

