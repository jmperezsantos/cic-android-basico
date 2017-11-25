package mx.ipn.cic.collectionsexample.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mx.ipn.cic.collectionsexample.R;

/**
 * Created by jmperezsantos on 11/25/17.
 */

public class SongRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;
    public TextView tvArtist;
    public View view;

    public SongRecyclerViewHolder(View itemView) {
        super(itemView);

        this.tvTitle =
                itemView.findViewById(R.id.tvTitle);
        this.tvArtist =
                itemView.findViewById(R.id.tvArtist);

        this.view = itemView;
    }

}
