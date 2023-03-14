package questions;

public class TrueFalse extends QuestionParent {

    private String correctAnswer;
    private String questionContext;

    public TrueFalse(String questionContext, String correctAnswer){
        super(questionContext);
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String answer(String userAnswer ) {
        if (userAnswer.equals("True") || userAnswer.equals("False")) {
            if (userAnswer.equals(correctAnswer) ) {
                return "Correct";
            }
            else {
                return "Incorrect";
            }
        }
        else{   // case for invalid input
            return "Incorrect";
        }
    }
}
