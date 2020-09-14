package com.example.queenb;

import androidx.fragment.app.Fragment;

public class TriviaQuestion
{
    private String question;
    private String opA;
    private String opB;
    private String opC;
    private String opD;
    private String answer;

    //class constructor
    public TriviaQuestion(String question, String op_a, String op_b, String op_c, String op_d, String ans)
    {
        this.question = question;
        this.opA = op_a;
        this.opB = op_b;
        this.opC = op_c;
        this.opD = op_d;
        this.answer = ans;
    }

    public TriviaQuestion() {
        this.question = "";
        this.opA = "";
        this.opB = "";
        this.opC = "";
        this.opD = "";
        this.answer = "";
    }

    public String getQuestion() {
        return this.question;
    }

    public String getOptA() {
        return this.opA;
    }

    public String getOptB() {
        return this.opB;
    }

    public String getOptC() {
        return this.opC;
    }

    public String getOptD() {
        return this.opD;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setQuestion(String q1) {
        this.question = q1;
    }

    public void setOptA(String o1) {
        this.opA = o1;
    }

    public void setOptB(String o2) {
        this.opB = o2;
    }

    public void setOptC(String o3) {
        this.opC = o3;
    }

    public void setOptD(String o4) {
        this.opD = o4;
    }

    public void setAnswer(String ans) {
        this.answer = ans;
    }


}
