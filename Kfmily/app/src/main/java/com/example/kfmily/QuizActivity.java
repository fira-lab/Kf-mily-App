package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class QuizActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String[] questions = {
            "1,What is the default value of byte variable?",
            "2,What is the size of long variable?",
            "3,What is the default value of int variable?",
            "4,What is the default value of short variable?",
            "5,What is the default value of double variable?",
            "6,What is the default value of float variable?",
            "7,What is the default value of char variable?",
            "8,What is the default value of boolean variable?",
            "9,What is the default value of object variable?",
            "10,Which two method(s) must be implemented by all threads?",
            "11,What is the difference between ArrayList and Vector class?",
            "12,What is a package in Java?",
            "13,What are wrapper classes?",
            "14,What is the purpose of the finally block?",
            "15,What is the purpose of the try block?",
            "16,What is an interface in Java?",
            "17,Can you make a constructor final?",
            "18,What is the keyword used for the inheritance of a class in Java?",
            "19,What is the difference between list and set interface?",
            "20,What is the difference between Array and ArrayList in Java?",
            "21,What is the purpose of the finalize() method?",
            "22,What is the public static void main()?",
            "23,What is the difference between method overloading and overriding in Java?",
            "24,What is a class in Java?",
            "25,What is an object in Java?",
            "26,What is a constructor in Java?",
            "27,What is the difference between method and a constructor?",
            "28,What is the difference between private and protected access modifiers?",
            "29,What is the difference between == and equals() method in Java?",
            "30,Can we declare main() method as private?",
            "31,What is an abstract class in Java?",
            "32,What is the difference between interface and abstract class in Java?",
            "33,What is the purpose of super keyword in Java?",

            // add more questions here if needed
    };
    String[][] opts = {
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},
            {"Very good", "Good", "Medium", "Low"},


            // add more options here if needed
    };
    int[] values = {4, 3, 2, 1}; // values of each option in order (very good, good, medium, low)

    String[] groupNames = {
            "Prayer",
            "Natanim",
            "Choir",
            "Education",
            "Lecture",
            "Teaching",
            "Conseling",
            "Evangelsim",
            "Fundraising",
            "Love sharing",
            "Charity"
    };

    int[][] groups = {
            {1, 4, 6},
            {7, 13, 17},
            {19, 21, 23},
            {9, 12, 18},
            {2, 25, 31},
            {8, 14, 28},
            {5, 10, 33},
            {3, 11, 27},
            {15, 20, 30},
            {22, 26, 32},
            {16, 24, 29} // group 1 questions
            // add more groups here if needed
    };
    int flag = 0;
    int[] responses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tv = findViewById(R.id.tvque);
        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        submitbutton = findViewById(R.id.button3);
        quitbutton = findViewById(R.id.buttonquit);

        responses = new int[questions.length];
        displayQuestion(flag);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedOptionIndex = getSelectedOptionIndex();
                responses[flag] = values[selectedOptionIndex];
                flag++;

                if (flag < questions.length) {
                    displayQuestion(flag);
                } else {
                    displayResult();
                    finish();
                }
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void displayQuestion(int index) {
        if (index >= 0 && index < questions.length) {
            tv.setText(questions[index]);
            rb1.setText(opts[index][0]);
            rb2.setText(opts[index][1]);
            rb3.setText(opts[index][2]);
            rb4.setText(opts[index][3]);
            radio_g.clearCheck();
        } else {
            // handle invalid index
            Toast.makeText(this, "Invalid question index", Toast.LENGTH_SHORT).show();
        }
    }

    private int getSelectedOptionIndex() {
        switch (radio_g.getCheckedRadioButtonId()) {
            case R.id.radioButton:
                return 0;
            case R.id.radioButton2:
                return 1;
            case R.id.radioButton3:
                return 2;
            case R.id.radioButton4:
                return 3;
            default:
                return -1;
        }
    }

    private void displayResult() {
        int[] groupScores = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            int groupScore = 0;
            for (int j = 0; j < groups[i].length; j++) {
                groupScore += responses[groups[i][j] - 1];
            }
            groupScores[i] = groupScore;
        }

        int maxGroupIndex = getMaxGroupIndex(groupScores);
        int maxGroupScore = groupScores[maxGroupIndex];

        // check if there are multiple highest groups
        boolean multipleMaxGroups = false;
        for (int i = 0; i < groupScores.length; i++) {
            if (i != maxGroupIndex && groupScores[i] == maxGroupScore) {
                multipleMaxGroups = true;
                break;
            }
        }

        if (multipleMaxGroups) {
            Toast.makeText(getApplicationContext(), "Multiple department occurrence. Please retake the test.", Toast.LENGTH_LONG).show();
        } else {
            String groupName = groupNames[maxGroupIndex];
            String resultMessage = "Your Department is " + groupName + ". This is based on your answers.";

            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("result", resultMessage);
            startActivity(intent);
        }
    }

    private int getMaxGroupIndex(int[] scores) {
        int maxIndex = 0;for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}

