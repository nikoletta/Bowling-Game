package Game;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Frame> frames;

    public Line (){
        frames = new ArrayList<Frame>();
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
