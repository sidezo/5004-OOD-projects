package questions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionTest {

    @org.junit.Test
    public void testTrueFalse() {
        Question a = new TrueFalse("Does 1+1 = 3?", "False");
        //Question b = new TrueFalse("Can you self study 5004?","Yes");
        assertEquals("Does 1+1 = 3?", a.getText());
        assertEquals("Incorrect",a.answer("True"));
        assertEquals("Incorrect",a.answer("FLSE"));
        assertEquals("Incorrect",a.answer("FALSE"));
    }

    @org.junit.Test
    public void testLikert() {
        Question b = new Likert("Rate your study experience in America from a scale from 1 to 5");
        assertEquals("Rate your study experience in America from a scale from 1 to 5", b.getText());
        assertEquals("Incorrect",b.answer("Agree"));
        assertEquals("Incorrect",b.answer("8"));
        assertEquals("Correct",b.answer("2"));
    }

    @org.junit.Test
    public void testMultipleSelect() {
        Question c = new MultipleSelect("Assume (a+1)^2 = 9, what is a?", "1 2","-4",
                "2","100");
        Question d = new MultipleSelect("What are the odd numbers provided", "1 2 3",
                "3" , "7","17","2","18","222","78","0");
        assertEquals("Assume (a+1)^2 = 9, what is a?",c.getText());
        assertEquals("What are the odd numbers provided",d.getText());
        assertEquals("Correct",c.answer("1 2"));
        assertEquals("Correct",c.answer("2 1"));
        assertEquals("Incorrect",c.answer("12"));
        assertEquals("Incorrect",c.answer("2 1 3"));
        assertEquals("Incorrect",c.answer("2 1 3 4"));
        assertEquals("Correct",d.answer("1 2 3"));
        assertEquals("Correct",d.answer("2 1 3"));
        assertEquals("Incorrect",d.answer("123"));
        assertEquals("Incorrect",d.answer("5 7 9"));
        assertEquals("Incorrect",d.answer("2 1 3 4"));


    }

    @org.junit.Test
    public void testMultipleChoice() {
        Question e = new MultipleChoice("Assume (a+1)^2 = 9, what is a?", "1","-4",
                "26","100");
        Question f = new MultipleChoice("What are the odd numbers provided", "3",
                "30" , "70","17","2","18","222","78","0");
        assertEquals("Assume (a+1)^2 = 9, what is a?",e.getText());
        assertEquals("What are the odd numbers provided",f.getText());
        assertEquals("Correct",e.answer("1"));
        assertEquals("Incorrect",e.answer("12"));
        assertEquals("Correct",f.answer("3"));
        assertEquals("Incorrect",f.answer("123"));
        assertEquals("Incorrect",f.answer("2 1 3 4"));
    }

    @org.junit.Test
    public void testOrdering() {
        Question a = new Likert("On a scale of 1-5, how do you like the fried chicken I just made");
        Question b = new MultipleSelect("Assume (a+1)^2 = 9, what is a?", "1 2","-4",
                "2","100");
        Question c = new TrueFalse("Is 4 a negative number?", "False");
        Question d = new MultipleChoice("Assume a = 4 and b = 4, what is a*b?", "16",
                "2", "1", "16", "8", "-2");

        List<Question> questionnaire = new ArrayList<>();
        questionnaire.add(a);
        questionnaire.add(b);
        questionnaire.add(c);
        questionnaire.add(d);
        Question[] correctOrder = {c, d, b, a};
        Collections.sort(questionnaire);
        for (int i = 0; i < questionnaire.size(); i++) {
            assertEquals(correctOrder[i], questionnaire.get(i));
        }
    }
}