package P12_6;

import java.util.Random;

/**
 * A Problem is generated according to Level.
 */
public class Problem {
    private int level;
    private int answer;
    private String problem;
    private int num;
    /**
     * @param level
     * Construct a problem for a given level
     */

    public Problem(int level){
        /**
         * Sets the current level
         * initialize the problem as "" (empty string)
         * initialize answer as 0
         */
        this.level = level;
        this.answer = 0;
        this.problem = "";
    }

    /**
     * method to add a digit, update the problem output and answer
     * @param dig
     */
    public void Add(int dig){
        answer += dig;
        problem = problem + " + " + dig;

    }

    /**
     * method to substract a digit, update the problem output and answer
     * @param dig
     */
    public void Subtract(int dig){
        answer -= dig;
        problem = problem + " - " + dig;

    }

    /**
     * method to generate the problem according to level
     */
    public void generateProblem(){
        answer = 0;
        problem = "";
        Random random = new Random();

        int dig= 1 + (int) (Math.random() * 8);
        answer = dig;
        problem = "" + dig;

        //if level is 1, the addition should include only randomly generated one-digit and the result needs to be less than 10
        if (level == 1){

            dig = 1 + (int) (Math.random() * (9 - dig));
            Add(dig);
            while (answer < 10 && random.nextBoolean()){
                dig = 1 + (int) (Math.random() * (9 - answer));
                if (dig + answer < 10){
                    Add(dig);
                    random= new Random();
                }
                else {
                    break;
                }

            }


        }

        //if level is 2, the addition should include only randomly generated one-digit
        else if (level == 2){
            dig = 1 + (int) (Math.random() * 9);
            Add(dig);
            while (random.nextBoolean()) {
                dig = 1 + (int) (Math.random() * 9);
                Add(dig);
                random = new Random();
            }

        }

        //if level is 3, the subtraction should include only randomly generated one-digit and result need to be non-negative
        else{
            dig = 1+ (int) (Math.random() * dig);
            Subtract(dig);
            while (answer > 0 && random.nextBoolean()){
                dig = 1+ (int) (Math.random() * answer);
                if (answer - dig >= 0){
                    Subtract(dig);
                    random= new Random();
                }
                else {
                    break;
                }

            }


        }

    }


    public String getProblem(){
        problem = problem + " = ";
        return problem;
    }

    public int getAnswer(){

        return answer;
    }

}
