package com.example.queenb.trivia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.queenb.R;

import java.util.ArrayList;


public class MainTriviaF extends Fragment {
    private static final ArrayList<TriviaQuestion> mTriviaQuestionsPool = new ArrayList<TriviaQuestion>();
    private int cur_question_id = 0;
    private QuestionFragment cur_qf;
    private static enum State {INIT, OPENED_QUESTION, OPENED_ANSWER};
    private State state;
    static {
        mTriviaQuestionsPool.add(new TriviaQuestion("מי מהנשים הבאות עבדה בעברה כמתכנתת?","ביונסה (בגלל סיבה זו נבחר שם העמותה שלנו)", "יונית לוי", "נטע ברזילי", "קרין גורן", "קרין גורן", "היא אמנם ידועה כשפית וקונדיטורית מהמצליחות בארץ "));
        mTriviaQuestionsPool.add(new TriviaQuestion("מה ההגדרה המתאימה לסטארט-אפ?","עסק חדש, כמו מכולת, מסעדה או מעדניה", "חברה שמתחילה עם מעט אנשים וכסף במטרה לממש רעיון או מוצר יחודי וחדשני", "כשבחור מתחיל איתך ב pick-up bar (סטארט עבור מתחיל, וup עבור pick-up)", "כל חברת הייטק, כמו Google, Facebook, Amazon", "חברה שמתחילה עם מעט אנשים וכסף במטרה לממש רעיון או מוצר יחודי וחדשני", "סטארט-אפ (חברת הזנק בעברית) היא חברה קטנה בתחילת דרכה, בעלת רעיון למצור חדשני שיכול לשנות את חייהם של אנשים\n כזה שיכול לגרום לנו לתהות, איך הוא הוא לא היה קודם (למשל, Waze התחיל כך, וגם )\n  כזה שיכול להימכר לחברה גדולה (למשל, את Waze רכשו גוגל בהמון כסף)"));
        mTriviaQuestionsPool.add(new TriviaQuestion("באיזו שפת תכנות כותבת תמר רביניאן, המרגלת-לוחמת-הסייבר אותה מגלמת ניב סולטן בסדרה המצליחה'טהרן'?","Python", "Java", "Assembly", "פרסית", "Python", "אם מתמקדים באחד הפריימים שמראים קוד תכנות בסדרה,\n ניתן להבחין שתמר רביניאן משתמשת בשפת Python"));
    }

    public MainTriviaF() {
        state = State.INIT;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_trivia, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        switch (state)
        {
            case INIT:
                cur_question_id = 0;
                openQuestion(cur_question_id);
                break;
            case OPENED_QUESTION:
                // need to check if answer was right
                openAnswer(cur_question_id);
                break;
            case OPENED_ANSWER:
                ++cur_question_id;
                if (cur_question_id == mTriviaQuestionsPool.size())
                {
                    //meaning, there are no more questions - go to FinalFragment
                    openFinal();
                }
                else
                {
                    openQuestion(cur_question_id);
                }
                break;
        }
    }

    private void openQuestion(int qid)
    {
        state = State.OPENED_QUESTION;
        TriviaQuestion question = mTriviaQuestionsPool.get(qid);
        cur_qf = QuestionFragment.newInstance(question.getQuestion(), question.getOptions());
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cur_qf).addToBackStack(null).commit();
    }

    private void openAnswer(int qid)
    {
        state = State.OPENED_ANSWER;
        TriviaQuestion question = mTriviaQuestionsPool.get(qid);
        boolean isRight = question.getAnswer().equals(cur_qf.getSelectedAnswer());

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                AnswerFragment.newInstance(isRight, question.getDetails())).addToBackStack(null).commit();
    }

    private void openFinal()
    {
        Fragment finalLayout = FinalTrivia.newInstance();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, finalLayout).addToBackStack(null).commit();
    }
}