package P12_6;

/**
 * A Level is determined by totalScore.
 */
public class Level {
    private int level;
    private int score;

    /**
     * @param totalScore
     * Construct a level initializing at 1
     */
    public Level(int totalScore){
        /**
         * sets current score
         *
         */
        score = totalScore;
    }

    /**
     * method to getLevel according to the score.
     * @return
     */
    public int getLevel(){
        if (score < 5){
            level = 1;
        }
        else if (score < 10){
            level = 2;
        }
        else {
            level = 3;
        }
        return level;
    }


}
