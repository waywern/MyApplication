package com.waywern.myapplication;

/**
 * Created by Home on 9/10/2016.
 */
public class TrueFalse {
    private int question;
    private boolean answer;

            public int getQuestion() {
            return question;
        }

            public boolean isAnswer() {
            return answer;
        }

            public void setQuestion(int question) {
            this.question = question;
        }

            public void setAnswer(boolean answer) {
            this.answer = answer;
        }

            public TrueFalse(int question, boolean answer)
    {
            this.question = question;
            this.answer = answer;
        }
}