package com.example.muziq;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

// song activity contains a list on songs for a user to choose from
//the activity is called from the main activity and and populated with a song adapter
public class Songs_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_);

        RelativeLayout backToLibrary = findViewById(R.id.backToLibrary);
        backToLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Songs_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        bottom navigation panel for moving between activities
        BottomNavigationView bottomNavigationView = findViewById(R.id.songsBottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//Switch statement to determine which navigation button has been clicked and make the necessary intent
                switch (menuItem.getItemId()) {
//                    switch to now playing activity if ow playing button is clicked
                    case R.id.nowplaying:
                        Intent intent = new Intent(Songs_Activity.this, NowPlaying_Activity.class);
                        startActivity(intent);
                        break;
//                        switch to search activity if search button is clicked
                    case R.id.search:
                        Intent intent1 = new Intent(Songs_Activity.this, Search_Activity.class);
                        startActivity(intent1);
                        break;
//                        switch to library activity if library button is clicked
                    case R.id.library:
                        Intent intent2 = new Intent(Songs_Activity.this, MainActivity.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });
//        songs array list for populating the song activity list view
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("Empty street", "Westlife", 325, R.drawable.cover1));
        songs.add(new Songs("Mylove", "VileCity", 243, R.drawable.cover2));
        songs.add(new Songs("Journey to the West", "John Crouch", 243, R.drawable.cover6));
        songs.add(new Songs("A place called home", "JeansMaker", 243, R.drawable.cover4));
        songs.add(new Songs("Laziness", "Slipo", 243, R.drawable.cover5));
        songs.add(new Songs("The robot with dreams", "Magneto", 243, R.drawable.cover6));
        songs.add(new Songs("I believe", "Novisu", 243, R.drawable.cover7));
        songs.add(new Songs("None Like you", "Gapoha", 243, R.drawable.cover8));
        songs.add(new Songs("Do you remember", "Crimpton Lincoln", 243, R.drawable.cover9));
        songs.add(new Songs("A star struck", "Celine Dion", 243, R.drawable.cover5));
        songs.add(new Songs("Be Still", "Caleb Grundy", 243, R.drawable.cover6));
        songs.add(new Songs("Step up", "Spint Vixeon", 243, R.drawable.cover1));
        songs.add(new Songs("Count on me", "Visioneer", 243, R.drawable.cover5));
        songs.add(new Songs("Always in Love", "Crowd Pleaser", 243, R.drawable.cover4));
        songs.add(new Songs("Demascot", "Holy Nation", 243, R.drawable.cover8));
        songs.add(new Songs("Only you can heal", "Beatle Police", 243, R.drawable.cover2));
        songs.add(new Songs("Healing Rain", "Johny vincent", 243, R.drawable.cover9));
        songs.add(new Songs("Queen", "Freddy Mur", 243, R.drawable.cover5));


        ListView listView = findViewById(R.id.main_songs_list);
        SongsArrayAdapter itemsAdapter = new SongsArrayAdapter(this, songs);

//        set onclick listeners to each list view to send an intent to the nowplaying activity with some data to display
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                when a song is clicked all the following attributes of the song are passed in an intent to the now playing activity
//                @song name, @duration, @ artist, @cover art
                Songs clickedSong = (Songs) parent.getItemAtPosition(position);
                Intent intent = new Intent(Songs_Activity.this, NowPlaying_Activity.class);
                intent.putExtra("song_name", clickedSong.getSongTitle());
                intent.putExtra("duration", clickedSong.getSongDuration());
                intent.putExtra("artist", clickedSong.getArtistName());
                intent.putExtra("image", clickedSong.getImageResourceId());

                startActivity(intent);
            }
        });

    }
}
