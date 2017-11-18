package mx.ipn.cic.collectionsexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.collectionsexample.R;
import mx.ipn.cic.collectionsexample.model.Song;

/**
 * Created by jmperezsantos on 11/18/17.
 */

public class GridViewSongAdapter extends BaseAdapter {

    private List<Song> canciones;

    public GridViewSongAdapter(List<Song> canciones) {

        this.canciones = canciones;

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

        if (reusableView == null) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            reusableView = inflater.inflate(R.layout.picture_item_layout,
                    parent,
                    false);

        }

        TextView tvTitle = reusableView.findViewById(R.id.tvTitle);

        TextView tvArtist = reusableView.findViewById(R.id.tvArtist);

        Song song = this.getItem(position);

        tvTitle.setText(song.getTitle());

        tvArtist.setText(song.getArtist());

        ImageView ivDisc = reusableView.findViewById(R.id.ivDisc);

        if (position % 3 == 0) {

            ivDisc.setImageResource(R.drawable.cast1);

        } else if (position % 2 == 0) {

            ivDisc.setImageResource(R.drawable.cast2);

        } else {

            ivDisc.setImageResource(R.drawable.play);

        }

        return reusableView;

    }
}
