package mx.ipn.cic.collectionsexample.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mx.ipn.cic.collectionsexample.R;
import mx.ipn.cic.collectionsexample.model.Song;
import mx.ipn.cic.collectionsexample.viewholder.SongRecyclerViewHolder;

/**
 * Created by jmperezsantos on 11/25/17.
 */

public class SongsRecyclerViewAdapter
        extends RecyclerView.Adapter<SongRecyclerViewHolder> {


    private List<Song> songs;

    private SongRecyclerViewOnItemTapListener tapListener;

    public SongsRecyclerViewAdapter(List<Song> songs, SongRecyclerViewOnItemTapListener listener) {
        this.songs = songs;
        this.tapListener = listener;
    }

    @Override
    public int getItemCount() {
        return this.songs.size();
    }

    @Override
    public SongRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = null;
        if (parent instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) parent;

            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

            if (layoutManager instanceof GridLayoutManager) {
                view = inflater.inflate(R.layout.picture_item_layout,
                        parent,
                        false);
            } else if (layoutManager instanceof LinearLayoutManager) {
                view = inflater.inflate(R.layout.song_item_layout,
                        parent,
                        false);
            }

        }

        SongRecyclerViewHolder viewHolder =
                new SongRecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SongRecyclerViewHolder holder,
                                 int position) {

        final Song song = this.getItem(position);

        holder.tvArtist.setText(song.getArtist());
        holder.tvTitle.setText(song.getTitle());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tapListener.onItemTap(song);

            }
        });

    }

    private Song getItem(int position) {

        return this.songs.get(position);

    }


}
