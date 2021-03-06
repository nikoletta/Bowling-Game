package main;

public class CreateScore {


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

        roll1=game[game.length-3];
        roll2=game[game.length-2];
        roll3=game[game.length-1];

        score += doScore(roll1, roll2, roll3);

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
