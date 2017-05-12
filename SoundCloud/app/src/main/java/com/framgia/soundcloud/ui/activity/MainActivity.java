package com.framgia.soundcloud.ui.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.k.soundcloud.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String CLIENT_ID = "08f79801a998c381762ec5b15e4914d5";
    private RecyclerView mRecyclerView;
    private AlbumAdapter mAdapter;
    private ArrayList<AlbumItem> mAlbumItems;
    private String mSearchText;
    private int mColNum = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_album_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, mColNum));
        ImageView mSearchButton = (ImageView) findViewById(R.id.image_search_button);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_search_button:
                mSearchText = ((TextView) findViewById(R.id.edit_search_bar)).getText().toString();
                if (!mSearchText.equals("")) getData();
                break;
        }
    }

    public void getData() {
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.show();
        SoundCloudService service = ServiceGenerator.createService(SoundCloudService.class);
        service.getData(CLIENT_ID, mSearchText).enqueue(new Callback<SoundCloudModel>() {
            @Override
            public void onResponse(Call<SoundCloudModel> call, Response<SoundCloudModel> response) {
                if (response != null) {
                    SoundCloudModel model = response.body();
                    mAlbumItems = new ArrayList<>();
                    for (int i = 0; i < model.getmCollection().size(); i++) {
                        if (model.getmCollection().get(i).getKind().equals("user")) continue;
                        mAlbumItems.add(new AlbumItem(model.getmCollection().get(i).getTitle()
                            , model.getmCollection().get(i).getArtworkUrl()));
                    }
                    mAdapter = new AlbumAdapter(mAlbumItems);
                    mRecyclerView.setAdapter(mAdapter);
                }
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<SoundCloudModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


