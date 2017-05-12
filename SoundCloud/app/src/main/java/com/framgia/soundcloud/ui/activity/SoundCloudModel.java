package com.framgia.soundcloud.ui.activity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K on 5/12/2017.
 */

public class SoundCloudModel {
    @SerializedName("collection")
    private List<Collection> mCollection;
    @SerializedName("total_results")
    private int mTotal;

    public List<Collection> getmCollection() {
        return mCollection;
    }

    public void setmCollection(
        List<Collection> mCollection) {
        this.mCollection = mCollection;
    }

    public List<Collection> getCollection() {
        return mCollection;
    }

    public void setCollection(
        List<Collection> collection) {
        mCollection = collection;
    }

    public int getTotal() {
        return mTotal;
    }

    public void setTotal(int total) {
        mTotal = total;
    }

    public class Collection {
        @SerializedName("kind")
        private String mKind;
        @SerializedName("id")
        private int mId;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("artwork_url")
        private String mArtworkUrl;


        public String getKind() {
            return mKind;
        }

        public void setKind(String kind) {
            mKind = kind;
        }

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getArtworkUrl() {
            return mArtworkUrl;
        }

        public void setArtworkUrl(String artworkUrl) {
            mArtworkUrl = artworkUrl;
        }
    }

}
