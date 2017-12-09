package mx.ipn.cic.fragmentarguments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.ipn.cic.fragmentarguments.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if(savedInstanceState == null){

            LoginFragment fragment = LoginFragment.newInstance();

            FragmentManager manager = this.getSupportFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.add(R.id.container, fragment);

            transaction.commit();

        }

    }
}
