package com.example.muziq;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Album_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_);

        BottomNavigationView bottomNavigationView = findViewById(R.id.albumBottomNavBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//Switch statement to determine which navigation button has been clicked and make the necessary intent
                switch (menuItem.getItemId()) {
//                    switch to now playiing activity if ow playing button is clicked
                    case R.id.nowplaying:
                        Intent intent = new Intent(Album_Activity.this, NowPlaying_Activity.class);
                        startActivity(intent);
                        break;
//                        switch to search activity if search button is clicked
                    case R.id.search:
                        Intent intent1 = new Intent(Album_Activity.this, Search_Activity.class);
                        startActivity(intent1);
                        break;
//                        switch to library activity if library button is clicked
                    case R.id.library:
                        Intent intent2 = new Intent(Album_Activity.this, MainActivity.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });
    }
}
