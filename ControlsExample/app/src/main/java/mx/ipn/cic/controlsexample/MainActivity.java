package mx.ipn.cic.controlsexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pbProgress = this.findViewById(R.id.pbProgress);
        final SeekBar sbSeekBar = this.findViewById(R.id.sbProgress);

        final CheckBox checkBox = this.findViewById(R.id.cbCheck);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    sbSeekBar.setProgress(0);
                } else {
                    sbSeekBar.setProgress(100);
                }

            }
        });

        sbSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    pbProgress.setProgress(progress);
                }

                if (seekBar.getProgress() < 300) {
                    seekBar.setProgress(300);
                }

                if (seekBar.getProgress() > 900) {
                    seekBar.setProgress(900);
                }

                Log.i("TAG", "Se movió el Slider Progress: " + seekBar.getProgress());
                Log.i("TAG", "Se movió el Slider fromUser: " + fromUser);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Log.i("TAG", "Empezó a mover el Slider Progress: " + seekBar.getProgress());

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Log.i("TAG", "Terminó de mover el Slider Progress: " + seekBar.getProgress());

            }
        });

        RadioGroup radioGroup = this.findViewById(R.id.rgGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.r1) {
                    Log.i("TAG", "Presionó R1");
                } else if (checkedId == R.id.r2) {
                    Log.i("TAG", "Presionó R2");
                } else {
                    Log.i("TAG", "Presionó R3");
                }

            }
        });

        Switch sSwitch = this.findViewById(R.id.sSwitch);
        sSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                checkBox.setChecked(isChecked);

            }
        });
    }
}
