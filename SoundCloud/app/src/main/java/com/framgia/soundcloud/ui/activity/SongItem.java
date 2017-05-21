package com.framgia.soundcloud.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.framgia.soundcloud.ui.activity.model.SongModel;

/**
 * Created by ducpm on 16/05/17.
 */
public class SongItem {
    private String mUrl;
    private String mSongTitle;
    private String mUsername;
    private int mDuration;

    public SongItem(SongModel model){
        mUrl = model.getArtworkUrl();
        mSongTitle = model.getTitle();
        mUsername = model.getUser().getUsername();
        mDuration = model.getDuration();
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

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

}