package com.framgia.soundcloud.ui.activity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ducpm on 16/05/17.
 */
public class SongModel {
    @SerializedName("genre")
    private String mGenre;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("id")
    private String mId;
    @SerializedName("artwork_url")
    private String mArtworkUrl;
    @SerializedName("user")
    private User mUser;
    @SerializedName("duration")
    private int mDuration;

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String genre) {
        mGenre = genre;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public class User {
        // de search user (for later)
        @SerializedName("username")
        private String mUserName;
        @SerializedName("id")
        private String mId;
        @SerializedName("avatar_url")
        private String mUserAvatarUrl;

        public String getUserName() {
            return mUserName;
        }

        public void setUserName(String userName) {
            mUserName = userName;
        }

        public String getId() {
            return mId;
        }

        public void setId(String id) {
            mId = id;
        }

        public String getUserAvatarUrl() {
            return mUserAvatarUrl;
        }

        public void setUserAvatarUrl(String userAvatarUrl) {
            mUserAvatarUrl = userAvatarUrl;
        }
    }
}
