package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Display text and images about the app's history
        // ...

        // Display the images with a fade in animation
        LinearLayout imagesLayout = findViewById(R.id.images_layout);
        imagesLayout.setVisibility(View.VISIBLE);
        for (int i = 0; i < imagesLayout.getChildCount(); i++) {
            View image = imagesLayout.getChildAt(i);
            image.setAlpha(0f);
            image.animate().alpha(1f).setDuration(2000).setStartDelay(1000 * i);
        }

        // Display the phone number the user can call
        TextView phoneTextView = findViewById(R.id.phone_text_view);
        phoneTextView.setText("Call us at 0982293746!");
    }
}
