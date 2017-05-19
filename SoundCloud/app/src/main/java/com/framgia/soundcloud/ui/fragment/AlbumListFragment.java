package com.framgia.soundcloud.ui.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.k.soundcloud.R;
import com.framgia.soundcloud.ui.activity.AlbumAdapter;
import com.framgia.soundcloud.ui.activity.AlbumItem;
import com.framgia.soundcloud.ui.activity.service.ServiceGenerator;
import com.framgia.soundcloud.ui.activity.SearchResponse;
import com.framgia.soundcloud.ui.activity.service.SoundCloudService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by K on 5/19/2017.
 */
public class AlbumListFragment extends Fragment implements View.OnClickListener {
    private static final String CLIENT_ID = "08f79801a998c381762ec5b15e4914d5";
    private static final int mLimit = 50;

    private RecyclerView mRecyclerView;
    private AlbumAdapter mAdapter;
    private ImageView mSearchButton;
    private EditText mSearch;
    private ArrayList<AlbumItem> mAlbumItems;
    private String mSearchText;
    private int mColNum = 3;
    private int mOffset = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_album_list, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_album_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), mColNum));

        mSearch = (EditText) v.findViewById(R.id.edit_search_bar);
        mSearchButton = (ImageView) v.findViewById(R.id.image_search_button);
        mSearchButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_search_button:
                mSearchText = mSearch.getText().toString();
                if (!mSearchText.equals("")) getData();
                break;
        }
    }

    public void getData() {
        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.show();
        SoundCloudService service = ServiceGenerator.createService(SoundCloudService.class);
        service.getSearch(CLIENT_ID, mSearchText, mLimit, mOffset).enqueue(new Callback<SearchResponse>
            () {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response != null) {
                    SearchResponse model = response.body();
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
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}