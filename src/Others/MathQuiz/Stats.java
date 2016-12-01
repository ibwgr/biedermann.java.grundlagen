package Others.MathQuiz;

import java.util.ArrayList;

/**
 * Created by dieterbiedermann on 29.08.16.
 */
public class Stats {
    int score;
    ArrayList<Calc> calcList = new ArrayList<>();

    Stats() {
        score = 0;
    }

    public void addScore(int score) {
        setScore(getScore() + score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addCalcList(Calc calcObj) {
        this.calcList.add(calcObj);
    }

}
