package mx.ipn.cic.collectionsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.collectionsexample.adapter.GridViewSongAdapter;
import mx.ipn.cic.collectionsexample.model.Song;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main2);

        List<Song> songs = this.generateDummyList(20);

        GridViewSongAdapter adapter = new GridViewSongAdapter(songs);

        GridView gridView = this.findViewById(R.id.gvSongs);

        gridView.setNumColumns(2);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Main2Activity.this,
                        "Hola mundo desde OnItemClickListener: " + position,
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    private List<Song> generateDummyList(int count) {

        List<Song> canciones = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            Song song = new Song("Title " + i, "Artist " + i);

            canciones.add(song);

        }

        return canciones;
    }
}
