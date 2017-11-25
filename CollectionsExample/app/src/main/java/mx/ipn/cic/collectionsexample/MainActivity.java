package mx.ipn.cic.collectionsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.collectionsexample.adapter.ListViewAdapterUpdateListener;
import mx.ipn.cic.collectionsexample.adapter.ListViewSongAdapter;
import mx.ipn.cic.collectionsexample.model.Song;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        List<Song> songs = this.generateDummyList(20);

        ListViewSongAdapter adapter =
                new ListViewSongAdapter(songs);

        adapter.setUpdateListener(new ListViewAdapterUpdateListener() {
            @Override
            public void onUpdateCall(ListViewSongAdapter adapter, int maxCount) {

                List<Song> moreSongs = MainActivity.this.generateMoreSongs(maxCount);

                adapter.addSongs(moreSongs);

            }
        });

        ListView lvCanciones =
                this.findViewById(R.id.lvCanciones);

        lvCanciones.setAdapter(adapter);

        lvCanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Adapter adapter1 = parent.getAdapter();

                Song song = (Song)adapter1.getItem(position);

                String mensaje = getString(R.string.my_super_string) + ": " + song.getDisquera();

                Toast.makeText(MainActivity.this,
                        mensaje,
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    private List<Song> generateMoreSongs(int maxCount) {

        List<Song> canciones = new ArrayList<>();

        int limit = maxCount + 10;

        for (int i = maxCount + 1; i <= limit; i++) {

            Song song = new Song("Title " + i, "Artist " + i);

            song.setDisquera("Disquera " + i*i);

            canciones.add(song);

        }

        return canciones;

    }

    private List<Song> generateDummyList(int count) {

        List<Song> canciones = new ArrayList<>();

        for (int i = 1; i <= count; i++) {

            Song song = new Song("Title " + i, "Artist " + i);

            song.setDisquera("Disquera " + i*i);

            canciones.add(song);

        }

        return canciones;
    }
}
