package com.framgia.soundcloud.ui.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.k.soundcloud.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by K on 5/18/2017.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<SongItem> mSongs;
    private Context mContext;

    public SongAdapter(List<SongItem> songs) {
        mSongs = songs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) mContext = parent.getContext();
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_song, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        SongItem item = mSongs.get(i);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mAlbumArt;
        TextView mTitle;
        TextView mArtist;
        TextView mDuration;

        public ViewHolder(View itemView) {
            super(itemView);
            mAlbumArt = (ImageView) itemView.findViewById(R.id.image_song_art);
            mTitle = (TextView) itemView.findViewById(R.id.text_song_title);
            mArtist = (TextView) itemView.findViewById(R.id.text_song_artist);
            mDuration = (TextView) itemView.findViewById(R.id.text_song_duration);
        }

        public void bindData(SongItem item) {
            if (item != null) {
                mTitle.setText(item.getSongTitle());
                mArtist.setText(item.getUsername());
                mDuration.setText(duration(item.getDuration()));
                Glide.with(mContext)
                    .load(item.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(mAlbumArt);
            }
        }

        public String duration(int millis) {
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            return hms;
        }
    }
}
