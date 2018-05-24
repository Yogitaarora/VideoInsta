package samples.tech.com.sampleproject;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import java.util.ArrayList;
import java.util.HashMap;


import im.ene.toro.ToroPlayer;
import im.ene.toro.ToroUtil;
import im.ene.toro.exoplayer.SimpleExoPlayerViewHelper;
import im.ene.toro.media.PlaybackInfo;
import im.ene.toro.widget.Container;

/**
 * Created by android on 23/5/18.
 */

public class SimpleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    Context context;

    public SimpleAdapter(MainActivity mainActivity, ArrayList<HashMap<String, String>> dataDetails) {
        this.context = mainActivity;
        this.dataList = dataDetails;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 1:
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_holder_exoplayer_basic, parent, false);
                return new SimplePlayerViewHolder(itemView);
            case 2:
                itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_holder_image, parent, false);
                return new ViewHolderImage(itemView);

        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap = dataList.get(position);
        String file = hashMap.get("file");
        String photoUrl = hashMap.get("photoUrl");
        String type = hashMap.get("type");
/*  viewHolder.bind(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));*/
        Log.e("url", "" + photoUrl);
        switch (holder.getItemViewType()) {
            case 1:
                SimplePlayerViewHolder viewHolder = (SimplePlayerViewHolder) holder;
                viewHolder.bind(Uri.parse("http://18.220.29.159/salniazi-app/uploads/" + file));
                break;
            case 2:
                ViewHolderImage viewHolderImage = (ViewHolderImage) holder;
               /* Glide.with(context)
                        .load("http://18.220.29.159/salniazi-app/uploads/" + photoUrl)
                        .into(viewHolderImage.ivImage);*/
                Glide.with(context)
                        .load("https://i.stack.imgur.com/Agz87.png")
                        .into(viewHolderImage.ivImage);

                break;


        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap = dataList.get(position);
        int ty = 0;
        String type = hashMap.get("type");
        if (type.equals("video")) {
            return 1;
        } else if (type.equals("image")) {
            return 2;
        }
        return ty;


    }

    public static class ViewHolderImage extends RecyclerView.ViewHolder {
        ImageView ivImage;

        public ViewHolderImage(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);


        }
    }

    public class SimplePlayerViewHolder extends RecyclerView.ViewHolder implements ToroPlayer, ToroPlayer.EventListener {

        SimpleExoPlayerView playerView;
        SimpleExoPlayerViewHelper helper;
        ProgressBar progress;
        Uri mediaUri;

        public SimplePlayerViewHolder(View itemView) {
            super(itemView);
            playerView = (SimpleExoPlayerView) itemView.findViewById(R.id.player);
            progress = (ProgressBar) itemView.findViewById(R.id.progress);
        }

        @NonNull
        @Override
        public View getPlayerView() {
            return playerView;
        }

        @NonNull
        @Override
        public PlaybackInfo getCurrentPlaybackInfo() {
            return helper != null ? helper.getLatestPlaybackInfo() : new PlaybackInfo();
        }

        @Override
        public void initialize(@NonNull Container container, PlaybackInfo playbackInfo) {
            if (helper == null) {
                helper = new SimpleExoPlayerViewHelper(container, this, mediaUri);
            }
            helper.initialize(playbackInfo);
            helper.addPlayerEventListener(this);

        }

        @Override
        public void play() {
            if (helper != null)
                helper.play();
        }

        @Override
        public void pause() {
            if (helper != null) helper.pause();
        }

        @Override
        public boolean isPlaying() {
            return helper != null && helper.isPlaying();
        }

        @Override
        public void release() {
            if (helper != null) {
                helper.release();
                helper = null;
            }
        }

        @Override
        public boolean wantsToPlay() {
            return ToroUtil.visibleAreaOffset(this, itemView.getParent()) >= 0.85;
        }

        @Override
        public int getPlayerOrder() {
            return getAdapterPosition();
        }

        @Override
        public void onSettled(Container container) {

        }

        void bind(Uri media) {
            this.mediaUri = media;
        }

        @Override
        public void onBuffering() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPlaying() {
            progress.setVisibility(View.GONE);
        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onCompleted() {
            progress.setVisibility(View.GONE);

        }
    }

}