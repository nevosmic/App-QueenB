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
    private AnswerFragment cur_af;
    private static enum State {INIT, OPENED_QUESTION, OPENED_ANSWER, OPENED_FINAL};
    private State state;
    static {
        mTriviaQuestionsPool.add(new TriviaQuestion("מי מהנשים הבאות עבדה בעברה כמתכנתת?",
                "ביונסה (בגלל סיבה זו נבחר שם העמותה שלנו)",
                "יונית לוי",
                "נטע ברזילי",
                "קרין גורן",
                "קרין גורן",
                "היא אמנם ידועה כשפית וקונדיטורית מהמצליחות בארץ...\n"
                + "אבל מסתבר, שלפני כל זה, קרין גורן למדה הנדסת תוכנה, והיתה מפתחת תוכנה בסטארט אפ!",
                R.drawable.trivia_q1_karin_goren_q,
                R.drawable.trivia_a1_karin));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה ההגדרה המתאימה לסטארט-אפ?",
                "עסק חדש, כמו מכולת, מסעדה או מעדניה",
                "חברה שמתחילה עם מעט אנשים וכסף במטרה לממש רעיון או מוצר יחודי וחדשני",
                "כשבחור מתחיל איתך ב pick-up bar (סטארט עבור מתחיל, וup עבור pick-up)",
                "כל חברת הייטק, כמו Google, Facebook, Amazon",
                "חברה שמתחילה עם מעט אנשים וכסף במטרה לממש רעיון או מוצר יחודי וחדשני",
                "סטארט-אפ היא חברה קטנה בתחילת דרכה, בעלת רעיון למוצר חדשני שיכול לשנות את חייהם של אנשים, " +
                        "כזה שיכול לגרום לנו לתהות, איך הוא הוא לא היה  קיים קודם.\n למשל, Waze הישראלית התחילה כך, " +
                        "ובהמשך נמכרה לGoogle.",
                R.drawable.trivia_q2_startup,
                R.drawable.trivia_a2_waze_google));

        mTriviaQuestionsPool.add(new TriviaQuestion("איזה מוצר מהבאים הוא חדשני ונמצא עכשיו בתהליך פיתוח?",
                "אתר שמקבל מילת חיפוש, ומחזיר דפי אינטרנט רלוונטיים בהם מופיעה המילה",
                "תוכנה שלומדת (בעזרת למידת מכונה) מה עשוי להקל על מחלות כרוניות להן אין תרופה ידועה",
                "תוכנה שלוקחת טוקבקים מאתרי חדשות ומרכיבה אותם לקטעי שירה שלאחר מכן מפרסמים בספרים",
                "תוכנה שמחשבת כמה זה 1+1",
                "תוכנה שלומדת (בעזרת למידת מכונה) מה עשוי להקל על מחלות כרוניות להן אין תרופה ידועה",
                "לצערנו, לא ידועה תרופה לכל מחלה. אם לך היתה מחלה כזו, מה היית עושה?\n" +
                        "אולי היית מנסה למצוא אנשים עם בעיה דומה, ולראות אם יש דברים שעוזרים להם." + "\n" +
                        "זה הרעיון מאחורי Stuff That Works, סטארפ אפ אותו יסדה יעל אליש, שמיצר תוכנה הלומדת מתוך עדויות רבות"+
                        " על מצבים דומים לשלך, מה עשוי להקל עליך. \n",
                R.drawable.trivia_q3_1_plus_1,
                R.drawable.trivia_a3_stuff_that
        ));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה עדיף - מחשב או כסף?",
                "כסף לא פותר את כל הבעיות, מחשב כן",
                "מחשב לא פותר את כל הבעיות, כסף כן",
                "שניהם לא פותרים את כל הבעיות",
                "שניהם פותרים את כל הבעיות",
                "שניהם לא פותרים את כל הבעיות",
                "זה טרם הוכח מדעית, אבל מהסתכלות סביבנו ניתן לראות שלא ניתן לפתור כל דבר בכסף.\n " +
                        "זה כן מוכח מדעית שיש בעיות אותן מחשב, לא משנה כמה מהיר או מתקדם, לעולם לא יוכל לפתור!",
                R.drawable.trivia_q4_money_vs_comp,
                R.drawable.trivia_a4_money_vs_comp));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה זה קומפיילר?",
                "מפלצת שוכנת נהר מסיפורי עם אותם נהוג לספר על העיר בלגרד",
                "צ'יפ מושתל",
                "תוכנה המתרגמת משפת מחשב אחת לשפה אחרת",
                "אמאל'ה!",
                "Python",
                "בגדול, קומפיילר היא תוכנה שממירה משפה תכנות המובנת למתכנת רגיל, " +
                        "לשפה בה מכונות מדברות.\n" +
                        "ובנימה אישית, אם הפחדנו אותך,\n" +
                        " בכל תחום חדש בחיים או שפה חדשה, לומדים מונח אחד כל פעם. " +
                        "ואז, בהדרגה, מה שמפחיד נהיה מוכר ורגיל, ומובן יותר כל הזמן." +
                        "מקוות שהבנת, ושלא תתני לאף אחד לאיים עליך במילים מתוחכמות!",
                R.drawable.trivia_q5_river_monster,
                R.drawable.trivia_a5_monster));

        mTriviaQuestionsPool.add(new TriviaQuestion("כמו שפות אנושיות, יש גם שפות מחשב רבות. באיזו שפת תכנות כותבת תמר רביניאן, " +
                "המרגלת-לוחמת-הסייבר אותה מגלמת ניב סולטן בסדרה המצליחה 'טהרן'?",
                "Python",
                "Java",
                "Assembly",
                "Persian",
                "Python",
                "אם מתמקדים באחד הפריימים שמראים קוד תכנות בסדרה,\n " +
                    "ניתן להבחין שתמר רביניאן משתמשת בשפת Python!",
                R.drawable.trivia_q6_tamer_rab,
                R.drawable.trivia_a6_tamar_rab));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה ההבדל בין עוגיות לעוגה?",
                "עוגיות עושים עם חמאה ועוגה עושים עם סוכר",
                "עוגיות זה מתוק אבל גם בשימוש באינטרנט, עוגה זה רק מתוק",
                "עוגות זה המזון היחידי שעוגיפלצת מוכן לאכול",
                "עוגיות זה עוגה במנות אישיות",
                "עוגיות זה מתוק אבל גם בשימוש באינטרנט, עוגה זה רק מתוק",
                "אולי יצא לך להיתקל בהודעה בנוסח ,'אתר זה עושה שימוש בעוגיות'.\n " +
                        "עוגיות (Cookies) הן אמצעי בו אתרי אינטרנט נעזרים על מנת לזכור דברים שונים שקשורים לשימוש שלך באופן אישי." +
                        "למשל - את תכולת עגלת הקניות שלך באתר כמו Amazon או .ASOS",
                R.drawable.trivia_q7_cookieflezet,
                R.drawable.trivia_a7_cookies));

        mTriviaQuestionsPool.add(new TriviaQuestion("איזה מההישגים הבאים שייך לאישה?",
                "ההבנה שאפשר לקחת מכשיר המבצע חישובים כמו מחשבון, לצורך פעולות מסובכות ושימושיות יותר",
                "המצאת הקרמבו",
                "ייסוד אינסטגרם",
                "כתיבת שיר פופ מצליח המבוסס על פזמון עם מילה שאינה קיימת -'קאוואי'",
                "ההבנה שאפשר לקחת מכשיר המבצע חישובים כמו מחשבון, לצורך פעולות מסובכות ושימושיות יותר",
                "תגידי, הסתכלת פעם על מחשבון וחשבת:\n" +
                        "אפשר לנצל את הפעולות שלו באופן מתוכנן, מסודר וחכם לצורך פעולות כמו...\n" +
                        "שליחת הודעות מקצה אחד של העולם לשני תוך שניות,"+
                        "תכנון מסלול נסיעה" +
                        "או כל שימוש מדהים אחר שניתן לעשות בעזרת מחשב?" + "\n" +
                        "עדה לאבלייס כן, והיא היתה הראשונה לעשות את זה, כבר בראשית המאה ה18! " +
                        "היא נחשבת לראשונה אי-פעם שהבינה את הפוטנציאל של תוכנת מחשב. \n",
                R.drawable.trivia_q8_static_benel,
                R.drawable.trivia_a8_ada_lovelace));


        mTriviaQuestionsPool.add(new TriviaQuestion("למה קוראים לנו QueenB?",
                "המייסדות אוהבות את ביונסה",
                "משמעות המונח באנגלית הוא 'מלכת הדבורים' שהיא נקבה חזקה בטבע, וכביטוי משתמשים בו עבור אישה מובילה וחזקה",
                "הסיומת B נשמעת כמו Be, ולנו חשוב שתהיי את עצמך באופן הכי מלא שאת יכולה להיות, אחת שיודעת שהיא יכולה להיות מה שתבחר להיות",
                "כל התשובות נכונות",
                "כל התשובות נכונות",
                "כל התשובות נכונות! \nמשמעויות רבות וחזקות עבור שם אחד, לא?",
                R.drawable.trivia_q9_queenb,
                R.drawable.trivia_a9_queenb));
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
            case OPENED_FINAL:
                getActivity().getSupportFragmentManager().popBackStack();
                break;

        }
    }

    private void openQuestion(int qid)
    {
        state = State.OPENED_QUESTION;
        TriviaQuestion question = mTriviaQuestionsPool.get(qid);

        if (cur_af == null)
        {
            cur_qf = QuestionFragment.newInstance(question.getQuestion(), question.getOptions(), question.getQuestionIm());
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cur_qf).addToBackStack(null).commit();
        }
        else
        {
            boolean isBack = cur_af.getIsBack();
            if (isBack == true)
            {
                // Back button pressed
                getActivity().getSupportFragmentManager().popBackStack();
            }
            else
            {
                cur_qf = QuestionFragment.newInstance(question.getQuestion(), question.getOptions(), question.getQuestionIm());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cur_qf).addToBackStack(null).commit();
            }
        }

    }

    private void openAnswer(int qid)
    {
        state = State.OPENED_ANSWER;
        TriviaQuestion question = mTriviaQuestionsPool.get(qid);

        String selectedAnswer = cur_qf.getSelectedAnswer();
        if (selectedAnswer == null)
        {
            // Back button pressed
            getActivity().getSupportFragmentManager().popBackStack();
        } else
        {
            boolean isRight = question.getAnswer().equals(selectedAnswer);
            cur_af = AnswerFragment.newInstance(isRight, question.getDetails(), question.getAnswerIm());
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cur_af).addToBackStack(null).commit();
        }

    }

    private void openFinal()
    {
        state = State.OPENED_FINAL;
        Fragment finalLayout = FinalTrivia.newInstance();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, finalLayout).addToBackStack(null).commit();
    }
}