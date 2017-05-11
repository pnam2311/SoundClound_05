package com.framgia.soundcloud.ui.activity;

/**
 * Created by K on 5/10/2017.
 */

public class AlbumItem {
    private int mImageResource;
    private String mTitle;

    public AlbumItem(int imageResource, String title) {
        mImageResource = imageResource;
        mTitle = title;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int imageResource) {
        mImageResource = imageResource;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
