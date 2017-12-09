package mx.ipn.cic.fragmentarguments.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.ipn.cic.fragmentarguments.R;
import mx.ipn.cic.fragmentarguments.model.UserModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private static final String USER_ARG = "USER_ARG";
    private UserModel user;

    public static DetailFragment newInstance(UserModel user) {

        Bundle args = new Bundle();
        args.putSerializable(USER_ARG, user);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();

        if (arguments != null) {

            this.user = (UserModel) arguments.getSerializable(USER_ARG);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        TextView tvContent = view.findViewById(R.id.tvContent);

        tvContent.setText(this.user.toString());

    }
}
