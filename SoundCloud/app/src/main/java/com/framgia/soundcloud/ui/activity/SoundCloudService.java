package com.framgia.soundcloud.ui.activity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by K on 5/12/2017.
 */

public interface SoundCloudService {
    @GET("search/")
    Call<SoundCloudModel> getData(@Query("client_id") String client_id
                                , @Query("q") String name);
}
