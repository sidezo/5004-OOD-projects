package questions;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice extends QuestionParent {

    private String[] options;     // string list to store 3-8 options
    private String questionContext;
    private String correctAnswer;

    public MultipleChoice(String questionContext, String correctAnswer, String ... options) {
        super(questionContext);
        this.correctAnswer = correctAnswer;
        if (options.length < 3 || options.length > 8) {  //list use size(); array use length
            throw new IllegalArgumentException("number of options should be larger than 2 and smaller than 9");
        } else {
            this.options = options;
        }
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String answer(String userAnswer) {
        try {
            int answerInt = Integer.parseInt(userAnswer);  //user parse to turn string into integer
            int correctInt = Integer.parseInt(correctAnswer);
            if (answerInt == correctInt) {
                return "Correct";
            } else {
                return "Incorrect";
            }

        } catch (NumberFormatException e) { //if failed to turn string into integer, catch NFM exception
            return "Incorrect";
        }
    }
}
