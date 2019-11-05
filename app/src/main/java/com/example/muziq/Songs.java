package com.example.muziq;

public class Songs {
    //    declaring member variables
    private String mArtistName;
    private String mSongTitle;
    private int mSongDuration;
    private int mImageResourceId;

    // Constructors
    public Songs(String songTitle, String songArtist, int songDuration, int coverArt) {

//      assigning constructor variables to member variables
        mArtistName = songArtist;
        mSongDuration = songDuration;
        mSongTitle = songTitle;
        mImageResourceId = coverArt;
    }

    //        Getters
    public String getSongTitle() {
        return mSongTitle;
    }

    public int getSongDuration() {
        return mSongDuration;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getArtistName() {
        return mArtistName;
    }


}
