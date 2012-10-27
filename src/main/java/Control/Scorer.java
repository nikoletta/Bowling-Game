package Control;

public class Scorer {

    public int evaluate(String roll) {

        return 0;
    }

    boolean isSpare(char c){
        if(c == '/') return true;
        else return false;
    }

    boolean isMiss(char c){
        if(c=='-') return true;
        else return false;
    }
    boolean isStrike(char c){
        if(c=='X') return true;
        else return false;
    }


}

