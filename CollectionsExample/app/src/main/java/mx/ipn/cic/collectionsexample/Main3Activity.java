package mx.ipn.cic.collectionsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.collectionsexample.adapter.GridViewSongAdapter;
import mx.ipn.cic.collectionsexample.adapter.ListViewSongAdapter;
import mx.ipn.cic.collectionsexample.model.Song;

public class Main3Activity extends AppCompatActivity {

    private boolean isGrid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main3);

        GridViewSongAdapter gridViewAdapter =
                new GridViewSongAdapter(this.generateDummyList(30));

        ListViewSongAdapter listViewAdapter =
                new ListViewSongAdapter(this.generateDummyList(30));

        final ListView lista = this.findViewById(R.id.lvCanciones);

        final GridView cuadricula = this.findViewById(R.id.gvSongs);

        lista.setAdapter(listViewAdapter);

        cuadricula.setAdapter(gridViewAdapter);

        ImageButton ibList = this.findViewById(R.id.ibList);

        ImageButton ibGrid = this.findViewById(R.id.ibGrid);

        ibGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lista.setVisibility(View.INVISIBLE);
                cuadricula.setVisibility(View.VISIBLE);

            }
        });

        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lista.setVisibility(View.VISIBLE);
                cuadricula.setVisibility(View.INVISIBLE);

            }
        });

        ImageButton ibDynamic = this.findViewById(R.id.ibDynamic);
        ibDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageButton boton = (ImageButton) v;

                if (isGrid) {

                    boton.setBackgroundResource(R.drawable.list);
                    lista.setVisibility(View.VISIBLE);
                    cuadricula.setVisibility(View.INVISIBLE);

                } else {

                    boton.setBackgroundResource(R.drawable.grid);
                    lista.setVisibility(View.INVISIBLE);
                    cuadricula.setVisibility(View.VISIBLE);

                }

                isGrid = !isGrid;

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
