package com.example.android.quizgameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gobov on 3/23/2017.
 */

public class ScoreActivity extends AppCompatActivity {

    // QUESTION SCORE TEXT VIEWS
    private TextView question1_score, question2_score, question3_score, question4_score, question5_score, question6_score, question7_score;

    // TO STORE THE ANSWER AND MATCH VALUES FROM PREFERENCES FOR FINAL SCORE INT
    private int question1_answer_value, question2_answer_value, question3_answer_value, question4_answer_value, question5_answer_value, question6_answer_value_1, question6_answer_value_2, question6_answer_value, question7_answer_value, finalInt;

    // TO STORE THE NAME VALUE FROM PREFERENCES
    private String nameValue, playerNameToUse;

    // FOR DISPLAYING THE SCORES
    private TextView finalScoreView;

    // FOR EASIER ACCESS OF DATA
    private ArrayList<String> endMessages;

    // TRY AGAIN BUTTON
    private Button tryAgainBtn;

    // TO USE THE VALUES
    SharedPreferences my_preferences;

    // METHOD FOR RESTARTING THE WHOLE APPLICATION
    private void restartApp() {
        Intent reloadMainActivity = new Intent(this, MainActivity.class);
        startActivity(reloadMainActivity);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);


        // GETTING ACCESS TO WRITTEN FILE VALUES FROM SHARED PREFERENCES
        my_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // GETTING THE STORED VALUES FROM SHARED PREFERENCES
        nameValue = my_preferences.getString("name_value", "");

        // FINDING THE TEXT VIEWVS TO DISPLAY THE SCORE
        question1_score = (TextView) findViewById(R.id.answer_value_1);
        question2_score = (TextView) findViewById(R.id.answer_value_2);
        question3_score = (TextView) findViewById(R.id.answer_value_3);
        question4_score = (TextView) findViewById(R.id.answer_value_4);
        question5_score = (TextView) findViewById(R.id.answer_value_5);
        question6_score = (TextView) findViewById(R.id.answer_value_6);
        question7_score = (TextView) findViewById(R.id.answer_value_7);

        // FINDING THE VIEWS TO DISPLAY SCORES AND MASSAGES
        finalScoreView = (TextView) findViewById(R.id.final_final_score_tv);

        // GETTING THE VALUES FOR CORRECT ANSWERS
        question1_answer_value = my_preferences.getInt("value1", 0);
        question2_answer_value = my_preferences.getInt("value2", 0);
        question3_answer_value = my_preferences.getInt("value3", 0);
        question4_answer_value = my_preferences.getInt("value4", 0);
        question5_answer_value = my_preferences.getInt("value5", 0);
        question6_answer_value_1 = my_preferences.getInt("value6_1", 0);
        question6_answer_value_2 = my_preferences.getInt("value6_2", 0);
        question7_answer_value = my_preferences.getInt("text_answer_value", 0);

        question6_answer_value = question6_answer_value_1 + question6_answer_value_2;

        // SETTING THE VALUE OF QUESTION 6 ANSWER VALUE AND CALCULATING THE SCORE
        if (question6_answer_value == 2){
            question6_answer_value = 1;
            // CALCULATING CORRECT AND INCORRECT ANSWERS
            finalInt = question1_answer_value + question2_answer_value + question3_answer_value + question4_answer_value + question5_answer_value + question6_answer_value + question7_answer_value;
        } else {
            question6_answer_value = 0;
            // CALCULATING CORRECT AND INCORRECT ANSWERS
            finalInt = question1_answer_value + question2_answer_value + question3_answer_value + question4_answer_value + question5_answer_value + question6_answer_value + question7_answer_value;
        }

        // SETTING THE TEXT VALUES TO THE TEXT VIEWS
        finalScoreView.setText(finalInt + "/7");


        // CHECKING THE ANSWER VALUES TO SET THE TEXT ON EACH QUESTION SCORE VIEW
        if (question1_answer_value == 1){
            question1_score.setText(getString(R.string.correct));
            question1_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question1_score.setText(getString(R.string.incorrect));
            question1_score.setTextColor(Color.BLACK);
        }

        if (question2_answer_value == 1){
            question2_score.setText(getString(R.string.correct));
            question2_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question2_score.setText(getString(R.string.incorrect));
            question2_score.setTextColor(Color.BLACK);
        }

        if (question3_answer_value == 1){
            question3_score.setText(getString(R.string.correct));
            question3_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question3_score.setText(getString(R.string.incorrect));
            question3_score.setTextColor(Color.BLACK);
        }

        if (question4_answer_value == 1){
            question4_score.setText(getString(R.string.correct));
            question4_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question4_score.setText(getString(R.string.incorrect));
            question4_score.setTextColor(Color.BLACK);
        }

        if (question5_answer_value == 1){
            question5_score.setText(getString(R.string.correct));
            question5_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question5_score.setText(getString(R.string.incorrect));
            question5_score.setTextColor(Color.BLACK);
        }

        if (question6_answer_value == 1){
            question6_score.setText(getString(R.string.correct));
            question6_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question6_score.setText(getString(R.string.incorrect));
            question6_score.setTextColor(Color.BLACK);
        }

        if (question7_answer_value == 1){
            question7_score.setText(getString(R.string.correct));
            question7_score.setTextColor(Color.parseColor("#6695E7"));
        } else {
            question7_score.setText(getString(R.string.incorrect));
            question7_score.setTextColor(Color.BLACK);
        }

        // CHECKING THE NAME VALUE AND STORING IT IN A STRING TO USE IN ARRAY LIST
        if (nameValue.contentEquals("")){
            playerNameToUse = getString(R.string.player);
        } else {
            playerNameToUse = nameValue;
        }

        // CREATING AN ARRAY LIST OF STRINGS AND ADDING MESSAGES TO IT
        endMessages = new ArrayList<String>();
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.bornWrestler) + playerNameToUse + getString(R.string.goldMedalWinner));
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.awesomeMatWork) + playerNameToUse + getString(R.string.proveItsNotLuck));
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.goodJob) + playerNameToUse + getString(R.string.trainMore));
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.decentWrestler) + playerNameToUse + ".");
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.betterNextTime) + playerNameToUse + getString(R.string.practicePerfect));
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.longRoadAhead) + playerNameToUse + "!");
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.morePractice) + playerNameToUse + " ?");
        endMessages.add(getString(R.string.yourScore) + " " + finalInt + "/7. " + getString(R.string.cMon) + playerNameToUse + getString(R.string.didntTry));

        // CHECKING THE VALUES TO DISPLAY END MASSAGES FROM THE LIST
        switch (finalInt){
            case 0:
                Toast toast7 = Toast.makeText(getApplication(), endMessages.get(7), Toast.LENGTH_LONG);
                toast7.setGravity(Gravity.CENTER, 0, 0);
                toast7.show();
                break;

            case 1:
                Toast toast6 = Toast.makeText(getApplication(), endMessages.get(6), Toast.LENGTH_LONG);
                toast6.setGravity(Gravity.CENTER, 0, 0);
                toast6.show();
                break;

            case 2:
                Toast toast5 = Toast.makeText(getApplication(), endMessages.get(5), Toast.LENGTH_LONG);
                toast5.setGravity(Gravity.CENTER, 0, 0);
                toast5.show();
                break;

            case 3:
                Toast toast4 = Toast.makeText(getApplication(), endMessages.get(4), Toast.LENGTH_LONG);
                toast4.setGravity(Gravity.CENTER, 0, 0);
                toast4.show();
                break;

            case 4:
                Toast toast3 = Toast.makeText(getApplication(), endMessages.get(3), Toast.LENGTH_LONG);
                toast3.setGravity(Gravity.CENTER, 0, 0);
                toast3.show();
                break;

            case 5:
                Toast toast2 = Toast.makeText(getApplication(), endMessages.get(2), Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER, 0, 0);
                toast2.show();
                break;

            case 6:
                Toast toast1 = Toast.makeText(getApplication(), endMessages.get(1), Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.CENTER, 0, 0);
                toast1.show();
                break;

            case 7:
                Toast toast0 = Toast.makeText(getApplication(), endMessages.get(0), Toast.LENGTH_LONG);
                toast0.setGravity(Gravity.CENTER, 0, 0);
                toast0.show();
                break;

        }


        /* FINDING THE BUTTON VIEW AND SETTING ON CLICK LISTENER ON IT
        TO RESTART THE WHOLE APP */
        tryAgainBtn = (Button) findViewById(R.id.try_again_btn);
        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartApp();

            }
        });

    }
}
