package com.framgia.soundcloud.ui.activity.service;

import com.framgia.soundcloud.ui.activity.SearchResponse;
import com.framgia.soundcloud.ui.activity.SongModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by K on 5/12/2017.
 */
public interface SoundCloudService {
    @GET("search/")
    Call<SearchResponse> getSearch(@Query("client_id") String client_id
                             , @Query("q") String name
                             , @Query("limit") int limit
                             , @Query("offset") int offset);
    @GET("tracks/{id}")
    Call<SongModel> getTrack(@Path("id") int id
                           , @Query("client_id") String client_id);
    @GET("playlist/{id}")
    Call<SearchResponse> getAlbum(@Path("id") int id
                            , @Query("client_id") String client_id);
}

