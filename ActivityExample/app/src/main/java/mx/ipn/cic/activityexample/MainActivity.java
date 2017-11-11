package mx.ipn.cic.activityexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_main);

        //Cargar las referencias de los objetos en la interfaz
        final TextView tvTitle = (TextView) this.findViewById(R.id.tvTitle);

        final EditText editText = (EditText) this.findViewById(R.id.etInput);
        Button button = (Button) this.findViewById(R.id.btnPress);

        Button btnNavegar = (Button) this.findViewById(R.id.btnNavega);

        btnNavegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra(SecondActivity.MI_EXTRA, editText.getText().toString());

                startActivity(intent);

                finish();

            }
        });

        //Agregar comportamientos
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Hola Mundo!!!");

                tvTitle.setText(editText.getText());
                editText.setText("");

            }
        });

        tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                tvTitle.setText("");
                editText.setText("");

                return false;
            }
        });

        //Modificar propiedades de los objetos
        tvTitle.setText("Hola Mundo!");
        editText.setHint("Buenos días");
        button.setText("Tap!");

    }
}
