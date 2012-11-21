import junit.framework.Assert;
import org.junit.Test;

public class CreateScore {

    @Test
    public void testScore() {

        final String ROLL4 = "--------------------";   //0
        final String ROLL5 = "1-------------------";  //1
        final String ROLL6 = "11111111111111111111";  //20*1 = 20
        final String ROLL7 = "1/1-----------------";  //10+1 +1=12
        final String ROLL8 = "X11----------------";  //10+1+1  1+1=14

        final String ROLL1 = "5/5/5/5/5/5/5/5/5/5/5";
        final String ROLL2 = "9-9-9-9-9-9-9-9-9-9-";
        final String ROLL3 = "XXXXXXXXXXXX";

        Assert.assertTrue("Score von -------------------- falsch.", createScore(ROLL4) == 0);
        Assert.assertEquals("Score von 1------------------- falsch.", 1, createScore(ROLL5));
        Assert.assertEquals("Score von 11111111111111111111 falsch.", 20, createScore(ROLL6));
        Assert.assertEquals("Score von 1/1----------------- falsch.", 12, createScore(ROLL7));
        Assert.assertEquals("Score von X11---------------- falsch.", 14, createScore(ROLL8));
        Assert.assertEquals("Score von 5/5/5/5/5/5/5/5/5/5/5 falsch.", 150, createScore(ROLL1));
        Assert.assertEquals("Score von 9-9-9-9-9-9-9-9-9-9- falsch.", 90, createScore(ROLL2));
        Assert.assertEquals("Score von XXXXXXXXXXXX falsch.", 300, createScore(ROLL3));
    }

    public int createScore(String roll) {
        char[] game = roll.toCharArray();
        char roll1 = '0';
        char roll2 = '0';
        char roll3 = '0';

        int score = 0;

        for (int i = 0; i < game.length; i += 2) {
            if (game.length > i + 3) {

                roll1 = game[i];
                roll2 = game[i + 1];
                roll3 = game[i + 2];

                if(roll1 == 'X') i--;

                score += doScore(roll1, roll2, roll3);
            }

        }

        char roll18 = roll1;
        char roll19 = roll2;
        char roll20 = roll3;

        score += doScore(roll18, roll19, roll20);

        return score;
    }

    private int doScore(char roll1, char roll2, char roll3) {
       if(roll1 == 'X'){
           return 10 + getPins(roll2)+ getPins(roll3);
       }
       else{
           if(roll2 == '/'){
               return 10 + getPins(roll3);
           }else{
               return getPins(roll1) + getPins(roll2);
           }
       }
    }

    private int getPins(char roll) {
        switch (roll) {
            case 'X' :
                return 10;
            case '/':
                return 10;
            case '-':
                return 0;
            default:
                return Character.getNumericValue(roll);
        }
    }
}
