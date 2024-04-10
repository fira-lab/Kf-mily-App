package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // Display text and videos about Jesus and provide a field for the user to write their thoughts
        // ...

        // Find the button for sending the message and add a click listener
        Button sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's information (name, phone number, and message)
                EditText nameEditText = findViewById(R.id.name_edit_text);
                String name = nameEditText.getText().toString();

                EditText phoneEditText = findViewById(R.id.phone_edit_text);
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
                Toast.makeText(NewActivity.this, "your message will be sent wheneever you are online.You will be contacted very soon", Toast.LENGTH_SHORT).show();
            }
        });

        // Find the VideoView objects for the YouTube videos
        VideoView video1 = findViewById(R.id.video1);
        VideoView video2 = findViewById(R.id.video2);
        VideoView video3 = findViewById(R.id.video3);
        VideoView video4 = findViewById(R.id.video4);
        VideoView video5 = findViewById(R.id.video5);

        // Load and play the first YouTube video
        String video1Url = "https://www.youtube.com/watch?v=8WSEjKzXnTs";
        Uri video1Uri = Uri.parse(video1Url);
        video1.setVideoURI(video1Uri);
        video1.start();

        // Load and play the second YouTube video
        String video2Url = "https://www.youtube.com/watch?v=p4MkiGc6dLs";
        Uri video2Uri = Uri.parse(video2Url);
        video2.setVideoURI(video2Uri);
        video2.start();

        // Load and play the third YouTube video
        String video3Url = "https://www.youtube.com/watch?v=h8WuDtMvRGc";
        Uri video3Uri = Uri.parse(video3Url);
        video3.setVideoURI(video3Uri);
        video3.start();

        // Load and play the fourth YouTube video
        String video4Url = "https://www.youtube.com/watch?v=BweE4h0ZVK4";
        Uri video4Uri = Uri.parse(video4Url);
        video4.setVideoURI(video4Uri);
        video4.start();

        // Load and play the fifth YouTube video
        String video5Url = "https://www.youtube.com/watch?v=eKyY8zfjBMQ";
        Uri video5Uri = Uri.parse(video5Url);
        video5.setVideoURI(video5Uri);
        video5.start();
    }
}