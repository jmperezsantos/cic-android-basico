package mx.ipn.cic.fragmentarguments.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.ipn.cic.fragmentarguments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoggedFragment extends Fragment {

    private static final String USERNAME_ARG = "USERNAME_ARG";

    private String username;

    public static LoggedFragment newInstance(String username) {

        LoggedFragment fragment = new LoggedFragment();

        Bundle arguments = new Bundle();
        arguments.putString(USERNAME_ARG, username);

        fragment.setArguments(arguments);

        return fragment;
    }

    public LoggedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();
        if (arguments != null) {
            this.username = arguments.getString(USERNAME_ARG);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logged, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        TextView tvUsername = view.findViewById(R.id.tvUsername);

        tvUsername.setText(this.username);

    }
}
