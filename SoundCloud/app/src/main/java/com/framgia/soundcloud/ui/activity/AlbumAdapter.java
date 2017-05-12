package com.framgia.soundcloud.ui.activity;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.k.soundcloud.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K on 5/10/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private List<AlbumItem> mAlbums;
    private Context mContext;

    public AlbumAdapter(ArrayList<AlbumItem> albumItems) {
        mAlbums = albumItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) mContext = parent.getContext();
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_album, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        AlbumItem item = mAlbums.get(i);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_album_title);
            mImageView = (ImageView) itemView.findViewById(R.id.image_album_art);
        }

        public void bindData(AlbumItem item) {
            if (item != null) {
                mTextView.setText(item.getTitle());
                Glide.with(mContext)
                    .load(item.getUrl())
                    .skipMemoryCache(true)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(mImageView);
            }
        }
    }
}
