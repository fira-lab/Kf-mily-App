package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private EditText nameEditText, phoneEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize views
        nameEditText = findViewById(R.id.name_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        resultTextView = findViewById(R.id.result_text);

        // Retrieve result message from MainActivity and display it
        String resultString = getIntent().getStringExtra("result");
        resultTextView.setText(resultString);

        // Set button click listener to send email
        Button sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipient = "terefefiraol423@gmail.com";
                String subject = "Test Result for " + nameEditText.getText().toString();
                String messageBody = "Name: " + nameEditText.getText().toString() + "\n"
                        + "Phone Number: " + phoneEditText.getText().toString() + "\n"
                        + "Result: " + resultString;

                // Create intent to send email
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, messageBody);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
                Toast.makeText(ResultActivity.this, "your message will be sent wheneever you are online.You will be contacted very soon", Toast.LENGTH_SHORT).show();
            }
        });
    }
}