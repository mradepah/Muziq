package com.example.muziq;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// Search activity will contain an edit text field so a user can type in song to be searched
//search will automatically fill the view with song that match the parameters of the search items

public class Search_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);
        RelativeLayout closeSearch = findViewById(R.id.searchBackToSongs);
        BottomNavigationView bottomNavigationView = findViewById(R.id.searchBottomNavBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//          Switch statement to determine which navigation button has been clicked and make the necessary intent
                switch (menuItem.getItemId()) {
//                    switch to now playing activity if ow playing button is clicked
                    case R.id.nowplaying:
                        Intent intent = new Intent(Search_Activity.this, NowPlaying_Activity.class);
                        startActivity(intent);
                        break;
//                        switch to library activity if library button is clicked
                    case R.id.library:
                        Intent intent1 = new Intent(Search_Activity.this, MainActivity.class);
                        startActivity(intent1);
                        break;

                }
                return false;
            }
        });
//        closes the search activity
        closeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
