package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Arrays;
import java.util.List;

public class AnnouncementActivity extends AppCompatActivity {

    private TextView mTvAnnouncement;
    private int mIndex = 0;
    private List<String> mAnnouncements = Arrays.asList(
            "The Lord is near to all who call on him, to all who call on him in truth.- Psalm 145:18",
            "In their hearts humans plan their course, but the Lord establishes their steps. - Proverbs 16:9",
            "And we know that in all things God works for the good of those who love him, who have been called according to his purpose. - Romans 8:28",
            // Add more verses here
            "Therefore, if you are offering your gift at the altar and there remember that your brother or sister has something against you, leave your gift there in front of the altar. First go and be reconciled to them; then come and offer your gift. - Matthew 5:23-24"
    );

    private Handler mHandler = new Handler();
    private Runnable mAnnouncementRunnable = new Runnable() {
        @Override
        public void run() {
            updateAnnouncement();
            mHandler.postDelayed(this, 1 * 60 * 60 * 1000); // 24 hours
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        mTvAnnouncement= findViewById(R.id.tv_announcement);

        // Start the announcement runnable
        mHandler.post(mAnnouncementRunnable);
    }

    private void updateAnnouncement() {
        mTvAnnouncement.setText(mAnnouncements.get(mIndex));
        mIndex = (mIndex + 1) % mAnnouncements.size();
    }
}