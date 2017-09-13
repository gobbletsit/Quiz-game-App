package com.example.android.quizgameapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by gobov on 3/12/2017.
 */

public class ChildFragmAdapter extends FragmentPagerAdapter {

    private Context childContext;

    private QuestionRadioButton questionRadioButton, question2, question3, question4, question5;

    private QuestionCheckBox questionCheckBox;

    private QuestionEditText questionEditText;


    public ChildFragmAdapter(Context context, FragmentManager fm){
        super(fm);
        childContext = context;
    }

    // TO USE WHEN SETTING THE ADAPTER ON VIEW PAGER IN QUIZ APP
    public void setFragments(Context c){
        questionRadioButton = new QuestionRadioButton();
        question2 = new QuestionRadioButton();
        question3 = new QuestionRadioButton();
        question4 = new QuestionRadioButton();
        question5 = new QuestionRadioButton();
        questionCheckBox = new QuestionCheckBox();
        questionEditText = new QuestionEditText();

        /*
        CALLING THE CHANGE METHODS FROM QUESTION 1 FRAGMENT
        */

        // CHANGING THE QUESTION STRINGS FOR EACH FRAGMENT
        questionRadioButton.changeQuestion(childContext.getString(R.string.question_1_string));
        question2.changeQuestion(childContext.getString(R.string.question_2_string));
        question3.changeQuestion(childContext.getString(R.string.question_3_string));
        question4.changeQuestion(childContext.getString(R.string.question_4_string));
        question5.changeQuestion(childContext.getString(R.string.question_5_string));

        // CHANGING THE ANSWER STRINGS FOR EACH FRAGMENT
        questionRadioButton.changeStringArray(childContext.getString(R.string.frag1_answer1), childContext.getString(R.string.frag1_answer2), childContext.getString(R.string.frag1_answer3));
        question2.changeStringArray(childContext.getString(R.string.frag2_answer1), childContext.getString(R.string.frag2_answer2), childContext.getString(R.string.frag2_answer3));
        question3.changeStringArray(childContext.getString(R.string.frag3_answer1), childContext.getString(R.string.frag3_answer2), childContext.getString(R.string.frag3_answer3));
        question4.changeStringArray(childContext.getString(R.string.frag4_answer1), childContext.getString(R.string.frag4_answer2), childContext.getString(R.string.frag4_answer3));
        question5.changeStringArray(childContext.getString(R.string.frag5_answer1), childContext.getString(R.string.frag5_answer2), childContext.getString(R.string.frag5_answer3));

        // CHANGING THE VALUES TO GET FROM SHARED PREFERENCES
        questionRadioButton.changeBooleans(1);
        question2.changeBooleans(2);
        question3.changeBooleans(3);
        question4.changeBooleans(4);
        question5.changeBooleans(5);

        // CHANGING THE LISTENERS FOR EACH FRAGMENT
        questionRadioButton.changeListener(1);
        question2.changeListener(2);
        question3.changeListener(3);
        question4.changeListener(4);
        question5.changeListener(5);
    }

    // GETTING THE FRAGMENTS TO BE PLACED IN THIS POSITIONS IN ADAPTER
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if (position == 0){
            frag = questionRadioButton;
        } else if (position == 1){
            frag = question2;
        } else if (position == 2){
            frag = question3;
        } else if (position == 3){
            frag = question4;
        } else if (position == 4){
            frag = question5;
        } else if (position == 5){
            frag = questionCheckBox;
        } else {
            frag = questionEditText;
        }
        return frag;
    }

    // OVERALL COUNT OF FRAGMENTS
    @Override
    public int getCount() {
        return 7;
    }

    // GETTING THE CHILD TITLES FROM STRING VALUES TO BE PLACED IN THIS POSITION IN INDICATOR
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return childContext.getString(R.string.fragment_question1);
        } else if (position == 1){
            return childContext.getString(R.string.fragment_question2);
        } else if (position == 2){
            return childContext.getString(R.string.fragment_question3);
        } else if (position == 3){
            return childContext.getString(R.string.fragment_question4);
        } else if (position == 4){
            return childContext.getString(R.string.fragment_question5);
        } else if (position == 5){
            return childContext.getString(R.string.fragment_question6);
        } else {
            return childContext.getString(R.string.fragment_question7);
        }
    }
}
