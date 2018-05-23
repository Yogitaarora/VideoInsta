package samples.tech.com.sampleproject;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import java.util.ArrayList;
import java.util.List;

import im.ene.toro.ToroPlayer;
import im.ene.toro.ToroUtil;
import im.ene.toro.exoplayer.SimpleExoPlayerViewHelper;
import im.ene.toro.media.PlaybackInfo;
import im.ene.toro.widget.Container;

/**
 * Created by android on 23/5/18.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimplePlayerViewHolder> {
    List<String> mediaList = new ArrayList<>();

    @Override
    public SimplePlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_exoplayer_basic, parent, false);
        return new SimplePlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimplePlayerViewHolder holder, int position) {
        holder.bind(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
    }

    @Override
    public int getItemCount() {
        return 8;
    }


    @Override
    public int getItemViewType(int position) {
        return position;

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
            return helper != null && helper.isPlaying();}

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