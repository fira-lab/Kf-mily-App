package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mPasswordEditText;
    private Button mUserButton;
    private Button mAdminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the EditText and Button objects
        mNameEditText = findViewById(R.id.name_edittext);
        mPasswordEditText = findViewById(R.id.password_edittext);
        mUserButton = findViewById(R.id.user_button);
        mAdminButton = findViewById(R.id.admin_button);
    }

    public void onUserClicked(View view) {
        String name = mNameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        if (password.equals("JESUS IS THE WAY THE LIFE AND THE TRUTH")) {
            Intent intent=new Intent(MainActivity.this,CircleActivity.class);
            startActivity(intent);
            // User password is correct
            // Do something here
        } else {
            // User password is incorrect
            Toast.makeText(MainActivity.this, "JESUS THE WAY THE LIFE AND THE TRUTH", Toast.LENGTH_SHORT).show();
            // Show an error message here
        }
    }

    public void onAdminClicked(View view) {
        String name = mNameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        if (password.equals("My Jesus")) {
            // Admin password is correct
            // Do something here
        } else {
            // Admin password is incorrect
            // Show an error message here
        }
    }
}