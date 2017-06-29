package P12_6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A ChildTest will get problem and input an answer then either advance or finish with level.
 */
public class ChildTest {

    private String name;
    private int level;
    private int score;
    private Problem mProblem;
    private Level mLevel;

    /**
     * @param name
     */
    public ChildTest(String name){
        this.name = name;
        score = 0;

    }

    /**
     * child will get problems at level 1
     * input his/her answers
     * he/she will get score
     * after he/she get total score of 5, he/she can go to level 2
     * child will get problem at level 2
     * input his/her answers
     * he/she will get score
     * after he/she get total score of 5, he/she can go to level 3
     * child will get problem at level 3
     * input his/her answers
     * he/she will get score
     * after he/she get total score of 5, he/she get accomplishment with level 3 (top level)
     * test end.
     */
    public void goTest(){
        //level 1
        mLevel = new Level(score);
        level = mLevel.getLevel();
        System.out.println();
        System.out.println(name + ", you are now at the level " + level);
        mProblem = new Problem(level);
        setProblem();

        //level 2
        mLevel = new Level(score);
        level = mLevel.getLevel();
        System.out.println();
        System.out.println(name + ", you are now at the level " + level);
        mProblem = new Problem(level);
        setProblem();


        //level 3
        mLevel = new Level(score);
        level = mLevel.getLevel();
        System.out.println();
        System.out.println(name + ", you are now at the level " + level);
        mProblem = new Problem(level);
        setProblem();

        System.out.println();
        System.out.println(name + ", congratulations!. You are at the top level!");

    }

    /**
     * for each level, need to correctly answer 5 questions to advance to next level
     */
    public void setProblem(){
        while (score < level * 5){
            mProblem.generateProblem();
            System.out.println(mProblem.getProblem());
            System.out.println("Please enter your answer (integers): ");
            Scanner in = new Scanner(System.in);
            int input;
            try {
                input = in.nextInt();
                if (input == mProblem.getAnswer()){
                    score += 1;
                }
                else {
                    System.out.println("Wrong answer. Please have your second try (integers): ");
                    input = in.nextInt();
                    if (input == mProblem.getAnswer()){
                        score += 1;
                    }
                    else {
                        System.out.println("Wrong answer again. The correct answer is: " + mProblem.getAnswer() + "." );
                    }

                }

            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input");
                continue;
            }



        }
    }

}
