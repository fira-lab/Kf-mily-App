package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        // Find the button for "Yes" and add a click listener
        Button yesButton = findViewById(R.id.yes_button);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Take the user to the HistoryActivity if they select "Yes"
                Intent intent = new Intent(GuestActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        // Find the button for "No" and add a click listener
        Button noButton = findViewById(R.id.no_button);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Take the user to the NewActivity if they select "No"
                Intent intent = new Intent(GuestActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
    }
}