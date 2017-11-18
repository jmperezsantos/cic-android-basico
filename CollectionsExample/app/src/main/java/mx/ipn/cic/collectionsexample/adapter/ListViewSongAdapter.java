package mx.ipn.cic.collectionsexample.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.collectionsexample.R;
import mx.ipn.cic.collectionsexample.model.Song;

/**
 * Created by jmperezsantos on 11/18/17.
 */

public class ListViewSongAdapter extends BaseAdapter {

    private List<Song> canciones;

    private ListViewAdapterUpdateListener updateListener;

    public ListViewSongAdapter(List<Song> canciones) {

        this.canciones = canciones;

    }

    public void addSongs(List<Song> moreSongs) {

        this.canciones.addAll(moreSongs);

        this.notifyDataSetChanged();

    }

    public void setUpdateListener(ListViewAdapterUpdateListener updateListener) {
        this.updateListener = updateListener;
    }

    @Override
    public int getCount() {

        return this.canciones.size();

    }

    @Override
    public Song getItem(int position) {

        return this.canciones.get(position);

    }

    @Override
    public long getItemId(int position) {

        return this.getItem(position).hashCode();

    }

    @Override
    public View getView(int position,
                        View reusableView,
                        ViewGroup parent) {

        if (position == this.getCount() - 1
                && this.updateListener != null) {

            Log.i("TAG", "Position: " + position);
            this.updateListener.onUpdateCall(this, this.getCount());

        }

        if (reusableView == null) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            reusableView = inflater.inflate(R.layout.song_item_layout,
                    parent,
                    false);

        }

        TextView tvTitle = reusableView.findViewById(R.id.tvTitle);

        TextView tvArtist = reusableView.findViewById(R.id.tvArtist);

        Song song = this.getItem(position);

        tvTitle.setText(song.getTitle());

        tvArtist.setText(song.getArtist());

        return reusableView;

    }
}
