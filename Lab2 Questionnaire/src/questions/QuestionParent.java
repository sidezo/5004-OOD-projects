package questions;

abstract public class QuestionParent implements Question{

    private final String questionContext;
    public QuestionParent(String questionContext){
        this.questionContext = questionContext;
    }

    @Override
    public String getText() {
        return questionContext;
    }

    @Override
    abstract public String answer(String userAnswer);

    @Override
    public int compareTo(Question o) {
        int diff = this.getQuestionType() - o.getQuestionType();
        if (diff!=0){
            return diff;
        }
        else{
            return this.getText().compareTo(o.getText()); //this compareTo is method overload of string class compareTo
        }
    }

    @Override
    public int getQuestionType() { //provide order for each question type, smaller the int, near the front of the list
        if (this instanceof Likert){
            return 4;
        } else if (this instanceof MultipleSelect){
            return 3;
        } else if (this instanceof MultipleChoice){
            return 2;
        } else if (this instanceof TrueFalse){
            return 1;
        } else {
            return -1; // meaning object not in Questions
        }
    }
}
