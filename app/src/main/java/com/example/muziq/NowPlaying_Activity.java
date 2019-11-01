package com.example.muziq;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NowPlaying_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing_);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nowPlayingBottomNavBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//Switch statement to determine which navigation button has been clicked and make the necessary intent
                switch (menuItem.getItemId()) {
//
//                        switch to search activity if search button is clicked
                    case R.id.search:
                        Intent intent = new Intent(NowPlaying_Activity.this, Search_Activity.class);
                        startActivity(intent);
                        break;
//                        switch to library activity if library button is clicked
                    case R.id.library:
                        Intent intent1 = new Intent(NowPlaying_Activity.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                }
                return false;
            }
        });
    }
}
