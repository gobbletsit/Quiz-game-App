package com.example.android.quizgameapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionEditText extends Fragment {

    private TextView questionTextView7;

    private EditText answerInput;

    private String correctAnswer;

    private Button submitScore;


    public QuestionEditText() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        setRetainInstance(true);
        super.onResume();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView7 = inflater.inflate(R.layout.fragment_question_edit_text, container, false);

        //setRetainInstance(true);

        // FINDING THE TEXT VIEW TO DISPLAY THE ASSIGNED QUESTION
        questionTextView7 = (TextView) rootView7.findViewById(R.id.question_text_view_7);
        questionTextView7.setText(getString(R.string.question_7_string));

        // USING PREFERENCE MANAGER TO WRITE TO THE FILE
        final SharedPreferences my_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // CREATING AN EDITOR TO USE FOR STORING VALUES
        final SharedPreferences.Editor editorEditText = my_preferences.edit();

        // TO GET THE USER EDIT TEXT ANSWER AND TO STORE THE VALUE
        answerInput = (EditText) rootView7.findViewById(R.id.answer_edit_text);
        answerInput.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
        answerInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    correctAnswer = getString(R.string.frag7_answer);
                    if (answerInput.getText().toString().equals(correctAnswer)) {
                        editorEditText.putInt("text_answer_value", 1);
                    }
                    editorEditText.apply();

                    //QuestionEditText.this.startActivity(toScoreActivity);
                }
                return false;
            }
        });

        submitScore = (Button) rootView7.findViewById(R.id.submit_score_button);
        submitScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toScoreActivity = new Intent(getActivity(), ScoreActivity.class);
                startActivity(toScoreActivity);
            }
        });

        return rootView7;

    }

}