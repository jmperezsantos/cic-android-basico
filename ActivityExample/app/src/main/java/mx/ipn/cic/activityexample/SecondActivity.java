package mx.ipn.cic.activityexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    public static final String MI_EXTRA = "MI_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = this.getIntent();

        String extra = intent.getStringExtra(MI_EXTRA);

        Log.i(TAG, "El valor extra es: " + extra);

    }
}
