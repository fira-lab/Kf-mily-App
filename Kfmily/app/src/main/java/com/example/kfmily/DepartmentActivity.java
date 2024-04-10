package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;



public class DepartmentActivity extends AppCompatActivity {

    LinearLayout panel1, panel2, panel3,panel4, panel5, panel6,panel7, panel8, panel9,panel10, panel11; // Add more panels as needed
    EditText passwordField;
    Button submitButton;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        panel1 = findViewById(R.id.panel1);
        panel2 = findViewById(R.id.panel2);
        panel3 = findViewById(R.id.panel3);
        panel4 = findViewById(R.id.panel4);
        panel5 = findViewById(R.id.panel5);
        panel6 = findViewById(R.id.panel6);
        panel7 = findViewById(R.id.panel7);
        panel8 = findViewById(R.id.panel8);
        panel9 = findViewById(R.id.panel9);
        panel10 = findViewById(R.id.panel10);
        panel11 = findViewById(R.id.panel11);

        // Add more panels as needed

        passwordField = findViewById(R.id.password_field);
        submitButton = findViewById(R.id.submit_button);

        scrollView = findViewById(R.id.scroll_view);

        // Hide panels by default
        panel1.setVisibility(View.VISIBLE);
        panel2.setVisibility(View.VISIBLE);
        panel3.setVisibility(View.VISIBLE);
        panel4.setVisibility(View.VISIBLE);
        panel5.setVisibility(View.VISIBLE);
        panel6.setVisibility(View.VISIBLE);
        panel7.setVisibility(View.VISIBLE);
        panel8.setVisibility(View.VISIBLE);
        panel9.setVisibility(View.VISIBLE);
        panel10.setVisibility(View.VISIBLE);
        panel11.setVisibility(View.VISIBLE);

        // Hide more panels as needed

        // Set click listeners for panel headers
        findViewById(R.id.panel1_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel1);
            }
        });

        findViewById(R.id.panel2_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel2);
            }
        });

        findViewById(R.id.panel3_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel3);
            }
        });
        findViewById(R.id.panel4_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel1);
            }
        });

        findViewById(R.id.panel5_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel2);
            }
        });

        findViewById(R.id.panel6_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel3);
            }
        });
        findViewById(R.id.panel7_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel1);
            }
        });

        findViewById(R.id.panel8_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel2);
            }
        });

        findViewById(R.id.panel9_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel3);
            }
        }); findViewById(R.id.panel10_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel1);
            }
        });

        findViewById(R.id.panel11_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePanel(panel2);
            }
        });




        // Set click listener for submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordField.getText().toString();
                if(passwordField.getText().toString().equals("DetailsMatter")) {
                    // Open Teacher Activity
                    Intent teacherIntent = new Intent(DepartmentActivity.this, QuizActivity.class);
                    startActivity(teacherIntent);
                } else {
                    Toast.makeText(DepartmentActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Helper method for expanding/collapsing panels
    private void togglePanel(View panel) {
        if (panel.getVisibility() == View.VISIBLE) {
            panel.setVisibility(View.GONE
);
        } else {
            panel.setVisibility(View.VISIBLE);
            scrollView.smoothScrollTo(0, panel.getTop());
        }
    }
}