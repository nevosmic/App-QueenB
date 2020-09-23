package com.example.queenb.trivia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.queenb.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment
{
    private static final String ARG_QUESTION = "question";
    private static final String ARG_ANSWERS = "answers";

    private String mQuestion;
    private ArrayList<String> mAnswers;
    private String mSelectedAnswer = null;
    private View mView = null;
    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(String question, ArrayList<String> answers)
    {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question);
        args.putStringArrayList(ARG_ANSWERS, answers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mQuestion = getArguments().getString(ARG_QUESTION);
            mAnswers = getArguments().getStringArrayList(ARG_ANSWERS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        TextView lblQuestion = (TextView) view.findViewById(R.id.lblQuestion);
        lblQuestion.setText(mQuestion);
        RadioButton radioBtn = (RadioButton) view.findViewById(R.id.radioBtnAns1);
        radioBtn.setText(mAnswers.get(0));
        radioBtn = (RadioButton) view.findViewById(R.id.radioBtnAns2);
        radioBtn.setText(mAnswers.get(1));
        radioBtn = (RadioButton) view.findViewById(R.id.radioBtnAns3);
        radioBtn.setText(mAnswers.get(2));
        radioBtn = (RadioButton) view.findViewById(R.id.radioBtnAns4);
        radioBtn.setText(mAnswers.get(3));
        Button submitBtn = (Button) view.findViewById(R.id.btnSubmit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                RadioGroup radioGroup = (RadioGroup) mView.findViewById(R.id.radioGroupAnswers);

                int radioButtonID = radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
                mSelectedAnswer = (String) radioButton.getText();
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        mView = view;
        return view;
    }

    public String getSelectedAnswer() {
        return mSelectedAnswer;
    }
}