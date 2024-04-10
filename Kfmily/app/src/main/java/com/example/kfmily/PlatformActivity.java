package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class PlatformActivity extends AppCompatActivity {

    private ImageView mIvYoutube, mIvFacebook, mIvTelegram, mIvTikTok;
    private TextView mTvYoutube, mTvFacebook, mTvTelegram, mTvTikTok;
    private String youtubeLink = "https://youtube.com/@amuecsf";
    private String facebookLink = "https://www.facebook.com";
    private String telegramLink = "https://www.telegram.org";
    private String tiktokLink = "https://www.tiktok.com";
    private int initialY = -100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform);

        mIvYoutube = findViewById(R.id.iv_youtube);
        mIvFacebook = findViewById(R.id.iv_facebook);
        mIvTelegram = findViewById(R.id.iv_telegram);
        mIvTikTok = findViewById(R.id.iv_tiktok);

        mTvYoutube = findViewById(R.id.tv_youtube);
        mTvFacebook = findViewById(R.id.tv_facebook);
        mTvTelegram = findViewById(R.id.tv_telegram);
        mTvTikTok = findViewById(R.id.tv_tiktok);

        // Set initial y-position for the first platform
        mIvYoutube.setY(initialY);

        // Start drop animation for each platform with a difference of 48dp
        dropAndBounce(mIvYoutube, mTvYoutube, 0, youtubeLink);
        dropAndBounce(mIvFacebook, mTvFacebook, 200, facebookLink);
        dropAndBounce(mIvTelegram, mTvTelegram, 400, telegramLink);
        dropAndBounce(mIvTikTok, mTvTikTok, 600, tiktokLink);
    }

    // Method to animate dropping and bouncing and launch website
    private void dropAndBounce(View view, TextView textView, long delay, final String websiteLink) {
        float finalY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                textView.getY() - view.getHeight() - 50f + delay, getResources().getDisplayMetrics());

        // Drop animation
        ObjectAnimator dropAnimator = ObjectAnimator.ofFloat(view, "y",
                initialY, finalY);
        dropAnimator.setDuration(1200);
        dropAnimator.setInterpolator(new AccelerateInterpolator());

        // Bounce animation
        ObjectAnimator bounceAnimator = ObjectAnimator.ofFloat(view, "y",
                finalY, finalY + TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48,
                        getResources().getDisplayMetrics()));
        bounceAnimator.setDuration(500);
        bounceAnimator.setInterpolator(new BounceInterpolator());

        // Play animations with delay and launch website when ImageView is clicked
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(dropAnimator, bounceAnimator);
        animatorSet.setStartDelay(delay);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(websiteLink);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        animatorSet.start();
        initialY += TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48,
                getResources().getDisplayMetrics());
    }
}