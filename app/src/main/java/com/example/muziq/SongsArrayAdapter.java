package com.example.muziq;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongsArrayAdapter extends ArrayAdapter<Songs> {

    public SongsArrayAdapter(Activity context, ArrayList<Songs> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the listitems.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.listitems, parent, false);
        }

        Songs currentSong = getItem(position);

        // Find the TextView  with the appropriate ID
        //Gets the getter element  from the Song class and sets it to the appropriate text view
//            in this case song title is set to the song title text view, image is set to the image text view
//            duration is set to the duration text convertView and artist name is set toString() the artist name text view
        TextView SongTextView = listViewItem.findViewById(R.id.songtitle);
        SongTextView.setText(currentSong.getSongTitle());
        TextView durationTextView = listViewItem.findViewById(R.id.songduration);
        int duration = currentSong.getSongDuration();
        durationTextView.setText(String.valueOf(duration));
        TextView artistname = listViewItem.findViewById(R.id.artistName);
        artistname.setText(currentSong.getArtistName());
        ImageView songCover = listViewItem.findViewById(R.id.songCover);
        songCover.setImageResource(currentSong.getImageResourceId());

        // Return the whole listitems item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listViewItem;
    }


}
