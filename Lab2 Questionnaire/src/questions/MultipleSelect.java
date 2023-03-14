package questions;

public class MultipleSelect extends QuestionParent{

    private String correctAnswer;
    private String[] options;
    
    public MultipleSelect(String questionContext, String correctAnswer, String option1, String option2, String option3){
        super(questionContext);
        this.correctAnswer = correctAnswer;
        this.options = new String[]{option1,option2,option3};
    }
    public MultipleSelect(String questionContext, String correctAnswer, String option1, String option2, String option3,String option4){
        super(questionContext);
        this.correctAnswer = correctAnswer;
        this.options = new String[]{option1,option2,option3,option4};
    }
    public MultipleSelect(String questionContext, String correctAnswer, String option1, String option2, String option3,String option4,String option5){
        super(questionContext);
        this.correctAnswer = correctAnswer;
        this.options = new String[]{option1,option2,option3,option4,option5};
    }
    public MultipleSelect(String questionContext, String correctAnswer, String option1, String option2, String option3,String option4,String option5,String option6){
        super(questionContext);
        this.correctAnswer = correctAnswer;
        this.options = new String[]{option1,option2,option3,option4,option5,option6};
    }
    public MultipleSelect(String questionContext, String correctAnswer, String option1, String option2, String option3,String option4,String option5,String option6,String option7){
        super(questionContext);
        this.correctAnswer = correctAnswer;
        this.options = new String[]{option1,option2,option3,option4,option5,option6,option7};
    }
    public MultipleSelect(String questionContext, String correctAnswer, String option1, String option2, String option3,String option4,String option5,String option6,String option7,String option8){
        super(questionContext);
        this.correctAnswer = correctAnswer;
        this.options = new String[]{option1,option2,option3,option4,option5,option6,option7,option8};
    }

    @Override
    public String answer(String userAnswer) {
        String[] answerArray = userAnswer.split(" ");
        if (userAnswer.length() != correctAnswer.length()) {
            return "Incorrect";
        }
        else{
            for (String s: answerArray){
                if (correctAnswer.contains(s)){
                    continue;
                } else{
                    return "Incorrect";
                }
            }
            return "Correct";
        }
    }
}
