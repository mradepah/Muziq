package com.example.muziq;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.nowplaying:
                        Intent intent = new Intent(MainActivity.this, NowPlaying_Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.search:
                        Intent intent1 = new Intent(MainActivity.this, Search_Activity.class);
                        startActivity(intent1);
                        break;

                }
                return false;
            }
        });

        TextView Artist = findViewById(R.id.artist);
        Artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Artist_Activity.class);
                startActivity(intent);
            }
        });

        TextView Albums = findViewById(R.id.album);
        Albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Album_Activity.class);
                startActivity(intent);
            }
        });

        TextView Songs = findViewById(R.id.songs);
        Songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Songs_Activity.class);
                startActivity(intent);
            }
        });
    }


}

