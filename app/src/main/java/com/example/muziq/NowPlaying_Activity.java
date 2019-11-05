package com.example.muziq;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NowPlaying_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing_);

//        declare and initialise all views
        TextView songName = findViewById(R.id.now_playing_song_name);
        ImageView image = findViewById(R.id.now_playing_song_image);
        TextView durationtv = findViewById(R.id.duration);
        RelativeLayout backToSongs = findViewById(R.id.backToSongs);
        ImageButton playSong = findViewById(R.id.playButton);
        ImageButton nextSong = findViewById(R.id.nextButton);
        ImageButton previousSong = findViewById(R.id.prevButton);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nowPlayingBottomNavBar);

//        Set on item click listener on my button navigation items

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
//        onclick listener for the entire back to songs layout
        backToSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlaying_Activity.this, Songs_Activity.class);
                startActivity(intent);
            }
        });

//        onclick listener for previous button when pressed
        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                do Something when previous button is clicked
            }
        });
//        onclick listener for play button on now playing view  when pressed
        playSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            do something when play button is pressed
            }
        });

//        onclick listener for next button when pressed
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                do something when next button is pressed
            }
        });

//        receives intent and sets all variables accordingly
        Intent intent = getIntent();
        songName.setText(intent.getStringExtra("song_name"));
        image.setImageResource(intent.getIntExtra("image", R.drawable.muc));
        int totalDuration = intent.getIntExtra("duration", 5 * 60);

//        structures and displays the time in a proper format
        String remainSeconds = totalDuration % 60 > 10 ?
                String.valueOf(totalDuration % 60) : String.format("0" + totalDuration % 60);
        String duration = (totalDuration / 60) + ":" + remainSeconds;
        durationtv.setText(duration);
    }
}
