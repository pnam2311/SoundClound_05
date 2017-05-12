package com.framgia.soundcloud.ui.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.k.soundcloud.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private int colNum = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_album_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, colNum));
    }
}
