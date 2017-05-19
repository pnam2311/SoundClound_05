package com.framgia.soundcloud.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ducpm on 16/05/17.
 */
public class SongItem {
    private String mUrl;
    private String mSongTitle;
    private String mArtist;
    private int mDuration;

    public SongItem(String url, String songTitle, String artist, int duration) {
        mUrl = url;
        mSongTitle = songTitle;
        mArtist = artist;
        mDuration = duration;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public void setSongTitle(String songTitle) {
        mSongTitle = songTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }
}
