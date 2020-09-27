package com.example.queenb.trivia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.queenb.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ISRIGHT = "isRight";
    private static final String ARG_DETAILS = "details";
    private static final String A_IMAGE = "image";

    private boolean mIsRight;
    private String mDetails;
    private int aImage;
    private boolean isBack = true;

    public AnswerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Answer_fragment.
     */

    public static AnswerFragment newInstance(boolean isRight, String details, int aImage) {
        AnswerFragment fragment = new AnswerFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_ISRIGHT, isRight);
        args.putString(ARG_DETAILS, details);
        args.putInt(A_IMAGE, aImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIsRight = getArguments().getBoolean(ARG_ISRIGHT);
            mDetails = getArguments().getString(ARG_DETAILS);
            aImage = getArguments().getInt(A_IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_answer_fragment, container, false);
        TextView lblIsRight = (TextView) v.findViewById(R.id.lblIsRight);
        if (mIsRight)
        {
            lblIsRight.setText("נכון מאוד! (◠‿◠)");
        } else
        {
            lblIsRight.setText("אופס... טעות (*_*)");
        }

        ImageView questionImage = v.findViewById(R.id.aIm);
        if(aImage != 0) {
            questionImage.setImageResource(aImage);
        }

        TextView lblDetails = (TextView) v.findViewById(R.id.lblDetails);
        lblDetails.setText(mDetails);
        Button nextBtn = (Button) v.findViewById(R.id.btnNext);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                setIsBack(false);
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        return v;
    }
    public boolean getIsBack() {
        return isBack;
    }
    public void setIsBack(boolean isBack) {
        this.isBack = isBack;
    }
}