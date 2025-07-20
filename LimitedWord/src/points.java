// '**' means Ai was used here, '--' is from tutorial or someone else's code, '/m' is my code when or no label is my code
// No AI was used in this file

public class points {

    //takes the length of input and adds to score value depending on length
    public static int getScore(int length){
        int score = 0;

        //length of word determines score, basic scoring system
        //1-3 letters = 1 point, 4-6 letters = 3 points, 7+ letters = 5 points
        if(length >= 7){
            score += 5;
        } else if(length >= 5){
            score += 3;
        } else if(length >= 1){
            score += 1;
        }

        return score;
    }
    
}
