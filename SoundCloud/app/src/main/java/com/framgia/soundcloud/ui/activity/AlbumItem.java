package com.framgia.soundcloud.ui.activity;

/**
 * Created by K on 5/10/2017.
 */

public class AlbumItem {
    private String mTitle;
    private String mUrl;

    public AlbumItem(String title, String url) {
        mTitle = title;
        mUrl = url;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
