package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.se.omapi.Session;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class CouncilActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText phoneNumberEditText;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_council);

        fullNameEditText = findViewById(R.id.full_name_edit_text);
        phoneNumberEditText = findViewById(R.id.phone_number_edit_text);
        messageEditText = findViewById(R.id.message_edit_text);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's information (name, phone number, and message)
                EditText nameEditText = findViewById(R.id.full_name_edit_text);
                String name = nameEditText.getText().toString();

                EditText phoneEditText = findViewById(R.id.phone_number_edit_text);
                String phone = phoneEditText.getText().toString();

                EditText messageEditText = findViewById(R.id.message_edit_text);
                String message = messageEditText.getText().toString();

                // Send the information to the email address
                String emailString = "mailto:terefefiraol423@gmail.com" +
                        "?subject=Message from " + name +
                        "&body=" + message + "\n\n" + phone;

                Uri emailUri = Uri.parse(emailString);
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, emailUri);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                Toast.makeText(CouncilActivity.this, "your message will be sent wheneever you are online.You will be contacted very soon", Toast.LENGTH_SHORT).show();
            }
        });}}