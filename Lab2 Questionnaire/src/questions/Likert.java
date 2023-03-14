package questions;

public class Likert extends QuestionParent{

    public Likert(String questionContext){
        super(questionContext);
    }

    @Override
    public String answer(String userAnswer) {
        try{
            int userInt = Integer.parseInt(userAnswer);
            if (userInt >= 1 && userInt <= 5) {
                return "Correct";
            } else {
                return "Incorrect";
            }
        }
        catch (NumberFormatException e){
            return "Incorrect";
        }
    }
}
