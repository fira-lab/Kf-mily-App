package com.example.kfmily;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class CircleActivity extends AppCompatActivity {

    private Button btnAnnouncement, btnDepartment, btnCouncil, btnPlatform, btnGuest;
    private View.OnClickListener clickListener;
    private List<Button> buttonList;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        // declaration and initialization of buttons and clickListener
        buttonList = new ArrayList<>();
        btnAnnouncement = findViewById(R.id.btnAnnouncement);
        btnDepartment = findViewById(R.id.btnDepartment);
        btnCouncil = findViewById(R.id.btnCouncil);
        btnPlatform = findViewById(R.id.btnPlatform);
        btnGuest = findViewById(R.id.btnGuest); // newly added button

        // adding buttons to the buttonList
        buttonList.add(btnAnnouncement);
        buttonList.add(btnDepartment);
        buttonList.add(btnCouncil);
        buttonList.add(btnPlatform);
        buttonList.add(btnGuest); // newly added button

        // setting alpha to 0 for certain buttons
        btnDepartment.setAlpha(0);
        btnCouncil.setAlpha(0);
        btnPlatform.setAlpha(0);
        btnGuest.setAlpha(0); // newly added button

        // clickListener implementation
        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAnnouncement:
                        currentIndex = 0;
                        Intent announcementIntent = new Intent(CircleActivity.this, AnnouncementActivity.class);
                        startActivity(announcementIntent);
                        break;
                    case R.id.btnDepartment:
                        currentIndex = 1;
                        Intent departmentIntent = new Intent(CircleActivity.this, DepartmentActivity.class);
                        startActivity(departmentIntent);
                        break;
                    case R.id.btnCouncil:
                        currentIndex = 2;
                        Intent councilIntent = new Intent(CircleActivity.this, CouncilActivity.class);
                        startActivity(councilIntent);
                        break;
                    case R.id.btnPlatform:
                        currentIndex = 3;
                        Intent platformIntent = new Intent(CircleActivity.this, PlatformActivity.class);
                        startActivity(platformIntent);
                        break;
                    case R.id.btnGuest:
                        currentIndex = 4;
                        Intent guestIntent = new Intent(CircleActivity.this, GuestActivity.class);
                        startActivity(guestIntent);
                        break;
                    default:
                        break;
                }
                fadeIn();
            }
        };
        btnAnnouncement.setOnClickListener(clickListener);
        btnDepartment.setOnClickListener(clickListener);
        btnCouncil.setOnClickListener(clickListener);
        btnPlatform.setOnClickListener(clickListener);
        btnGuest.setOnClickListener(clickListener); // newly added button
    }
    private void fadeIn() {
        if (currentIndex < buttonList.size()) {
            Button currentButton = buttonList.get(currentIndex);
            currentButton.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    currentIndex++;
                    fadeIn();
                }
            }).start();
        }
    }
}