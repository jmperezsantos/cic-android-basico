package mx.ipn.cic.fragmentsexample.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.ipn.cic.fragmentsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    public static ThirdFragment newInstance() {

        ThirdFragment fragment = new ThirdFragment();

        return fragment;
    }

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        Button btnAtras = view.findViewById(R.id.irAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().popBackStack();

            }
        });

    }
}
