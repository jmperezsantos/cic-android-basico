package mx.ipn.cic.fragmentsexample.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.ipn.cic.fragmentsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener{


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btnAtras = view.findViewById(R.id.irAtras);

        btnAtras.setOnClickListener(this);

        Button btnAvanzar = view.findViewById(R.id.irAl3);

        btnAvanzar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        FragmentManager manager = this.getFragmentManager();

        if(v.getId() == R.id.irAtras) {

            manager.popBackStack();

        } else if(v.getId() == R.id.irAl3){

            Fragment fragment = ThirdFragment.newInstance();

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragment);

            transaction.commit();

        }

    }
}
