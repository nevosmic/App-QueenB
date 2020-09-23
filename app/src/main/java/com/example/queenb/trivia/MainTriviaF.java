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
        mTriviaQuestionsPool.add(new TriviaQuestion("מי מהנשים הבאות עבדה בעברה כמתכנתת?",
                "ביונסה (בגלל סיבה זו נבחר שם העמותה שלנו)",
                "יונית לוי",
                "נטע ברזילי",
                "קרין גורן",
                "קרין גורן",
                "היא אמנם ידועה כשפית וקונדיטורית מהמצליחות בארץ\n"
                + "אבל מסתבר, שלפני כל זה, קרין גורן למדה הנדסת תוכנה, והיתה מפתחת תוכנה בסטארט אפ!"));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה ההגדרה המתאימה לסטארט-אפ?",
                "עסק חדש, כמו מכולת, מסעדה או מעדניה",
                "חברה שמתחילה עם מעט אנשים וכסף במטרה לממש רעיון או מוצר יחודי וחדשני",
                "כשבחור מתחיל איתך ב pick-up bar (סטארט עבור מתחיל, וup עבור pick-up)",
                "כל חברת הייטק, כמו Google, Facebook, Amazon",
                "חברה שמתחילה עם מעט אנשים וכסף במטרה לממש רעיון או מוצר יחודי וחדשני",
                "סטארט-אפ היא חברה קטנה בתחילת דרכה, בעלת רעיון למוצר חדשני שיכול לשנות את חייהם של אנשים\n " +
                        "כזה שיכול לגרום לנו לתהות, איך הוא הוא לא היה קודם (למשל, Waze הישראלית התחילה כך)\n " +
                        " וכזה שיכול להימכר לחברה גדולה בהמשך (למשל, את Waze רכשו גוגל)"));

        mTriviaQuestionsPool.add(new TriviaQuestion("איזה מוצר מהבאים הוא חדשני ונמצא עכשיו בתהליך פיתוח?",
                "אתר שמקבל מילת חיפוש, ומחזיר דפי אינטרנט רלוונטיים בהם מופיעה המילה",
                "תוכנה שלומדת (בעזרת למידת מכונה) מה עשוי להקל על מחלות כרוניות להן אין תרופה ידועה",
                "תוכנה שלוקחת טוקבקים מאתרי חדשות ומרכיבה אותם לקטעי שירה שלאחר מכן מפרסמים בספרים",
                "תוכנה שמחשבת כמה זה 1+1",
                "תוכנה שלומדת (בעזרת למידת מכונה) מה עשוי להקל על מחלות כרוניות להן אין תרופה ידועה",
                "לצערנו, לא ידועה תרופה לכל מחלה. אם היה לך מחלה כזו, מה היית עושה?\n" +
                        "אולי היית מנסה למצוא אנשים עם בעיה דומה, ולראות אם יש דברים שעוזרים להם." + "\n" +
                        "זה הרעיון מאחורי Stuff That Works, סטארפ אפ שמיצר תוכנה הלומדת מתוך עדויות רבות"+
                        " על מצבים דומים לשלך, מה עשוי להקל עליך. \n" +
                        "(מעניין לדעת שלא רק רופאים וכימאים יכולים לגלות תרופות, לא?)\n" +
                        "וגם - המייסדת היא אישה, יעל אליש, לה היה תפקיד משמעותי מאוד בWaze.\n"
        ));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה עדיף - מחשב או כסף?",
                "כסף לא פותר את כל הבעיות, מחשב כן",
                "מחשב לא פותר את כל הבעיות, כסף כן",
                "שניהם לא פותרים את כל הבעיות",
                "שניהם פותרים את כל הבעיות",
                "שניהם לא פותרים את כל הבעיות",
                "זה טרם הוכח מדעית, אבל אנחנו מכירים מהחיים שלא ניתן לפתור כל דבר בכסף.\n " +
                        "זה כן מוכח מדעית שיש בעיות אותן מחשב, לא משנה כמה מהיר או מתקדם, לעולם לא יוכל לפתור!"));

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
                        "ואז, בהדרגה, ומה שמפחיד נהיה מוכר ורגיל, ומובן יותר כל הזמן.\n" +
                        "מקוות שהבנת, ושלא תתני לאף אחד לאיים עליך במילים מתוחכמות!"
        ));

        mTriviaQuestionsPool.add(new TriviaQuestion("כמו שפות אנושיות, יש גם שפות מחשב רבות. באיזו שפת תכנות כותבת תמר רביניאן, " +
                "המרגלת-לוחמת-הסייבר אותה מגלמת ניב סולטן בסדרה המצליחה 'טהרן'?",
                "Python",
                "Java",
                "Assembly",
                "Persian",
                "Python",
                "אם מתמקדים באחד הפריימים שמראים קוד תכנות בסדרה,\n " +
                "ניתן להבחין שתמר רביניאן משתמשת בשפת Python!"));

        mTriviaQuestionsPool.add(new TriviaQuestion("מה ההבדל בין עוגיות לעוגה?",
                "עוגיות עושים עם חמאה ועוגה עושים עם סוכר",
                "עוגיות זה מתוק אבל גם בשימוש באינטרנט, עוגה זה רק מתוק",
                "עוגות זה המזון היחידי שעוגיפלצת מוכן לאכול",
                "עוגיות זה עוגה במנות אישיות",
                "עוגיות זה מתוק אבל גם בשימוש באינטרנט, עוגה זה רק מתוק",
                "אולי יצא לך להיתקל בהודעה בנוסח ,'אתר זה עושה שימוש בעוגיות'\n " +
                        "עוגיות (Cookies) הן אמצעי בו אתרי אינטרנט נעזרים על מנת לזכור דברים שונים שקשורים לשימוש שלך באופן אישי.\n" +
                        "למשל - את תכולת עגלת הקניות שלך באתר כמו Amazon או ASOS"));

        mTriviaQuestionsPool.add(new TriviaQuestion("איזה מההישגים הבאים שייך לאישה?",
                "ההבנה שאפשר לקחת מכשיר המבצע חישובים כמו מחשבון, לצורך פעולות מסובכות ושימושיות יותר",
                "המצאת הקרמבו",
                "ייסוד אינסטגרם",
                "כתיבת שיר פופ מצליח המבוסס על פזמון עם מילה שאינה קיימת -'קאוואי'",
                "ההבנה שאפשר לקחת מכשיר המבצע חישובים כמו מחשבון, לצורך פעולות מסובכות ושימושיות יותר",
                "תגידי, הסתכלת פעם על מחשבון וחשבת:\n" +
                        "אפשר לנצל את הפעולות שלו באופן מתוכנן, מסודר וחכם לצורך פעולות כמו...\n" +
                        "צפייה בסרטים,\n" +
                        "שליחת הודעות מקצה אחד של העולם לשני תוך שניות,\n"+
                        "תכנון מסלול נסיעה\n" +
                        "או כל שימוש מדהים אחר שניתן לעשות בעזרת מחשב?\n" + "\n" +
                        "עדה לאבלייס כן, והיא היתה הראשונה לעשות את זה, כבר בראשית המאה ה18! " +
                        "היא נחשבת לראשונה אי-פעם שהבינה את הפוטנציאל של תוכנת מחשב. \n"));


        mTriviaQuestionsPool.add(new TriviaQuestion("למה קוראים לנו QueenB?",
                "המייסדות אוהבות את ביונסה",
                "משמעות המונח באנגלית הוא 'מלכת הדבורים' שהיא נקבה חזקה בטבע, וכביטוי משתמשים בו עבור אישה מובילה וחזקה",
                "הסיומת B נשמעת כמו Be, ולנו חשוב שתהיי את עצמך באופן הכי מלא שאת יכולה להיות, אחת שיודעת שהיא יכולה להיות מה שתבחר להיות",
                "כל התשובות נכונות",
                "כל התשובות נכונות",
                "שם אחד והרבה משמעויות יפות וחזקות, לא?"));
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