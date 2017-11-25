package mx.ipn.cic.collectionsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.collectionsexample.adapter.SongRecyclerViewOnItemTapListener;
import mx.ipn.cic.collectionsexample.adapter.SongsRecyclerViewAdapter;
import mx.ipn.cic.collectionsexample.model.Song;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main4);

        final SongsRecyclerViewAdapter adapter =
                new SongsRecyclerViewAdapter(this.generateDummyList(30),
                        new SongRecyclerViewOnItemTapListener() {
                            @Override
                            public void onItemTap(Song song) {

                                Toast.makeText(Main4Activity.this,
                                        "La Disquera es: " + song.getDisquera(),
                                        Toast.LENGTH_LONG).show();

                            }
                        });

        final RecyclerView rvSongs = this.findViewById(R.id.rvSongs);

        rvSongs.setLayoutManager(new LinearLayoutManager(this));
        rvSongs.setAdapter(adapter);

        ImageButton ibList = this.findViewById(R.id.ibList);
        ImageButton ibGrid = this.findViewById(R.id.ibGrid);

        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rvSongs.setLayoutManager(
                        new LinearLayoutManager(Main4Activity.this)
                );

                rvSongs.setAdapter(adapter);

            }
        });

        ibGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rvSongs.setLayoutManager(
                        new GridLayoutManager(Main4Activity.this, 3)
                );

                rvSongs.setAdapter(adapter);

            }
        });

    }

    private List<Song> generateDummyList(int count) {

        List<Song> canciones = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            Song song = new Song("Title " + i, "Artist " + i);
            song.setDisquera("Disquera: " + i * i);

            canciones.add(song);

        }

        return canciones;
    }
}
