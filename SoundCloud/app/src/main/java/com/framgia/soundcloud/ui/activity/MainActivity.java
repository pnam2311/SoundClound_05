package com.framgia.soundcloud.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.k.soundcloud.R;
import com.framgia.soundcloud.ui.fragment.AlbumListFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlbumListFragment fragment = new AlbumListFragment();
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit();
    }
}


