package mx.ipn.cic.fragmentarguments.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.ipn.cic.fragmentarguments.R;


public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {

        LoginFragment fragment = new LoginFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        final EditText etUsername = view.findViewById(R.id.etUsername);
        final EditText etPassword = view.findViewById(R.id.etPassword);
        Button btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.length() == 0 || password.length() == 0) {

                    Toast.makeText(getContext(),
                            "Debes ingresar todos los datos",
                            Toast.LENGTH_LONG).show();

                } else if (username.equals("manuel") && password.equals("pass")) {

                    performLogin(username);

                } else {

                    Toast.makeText(getContext(),
                            "Nombre de usuario o contraseña inválidos",
                            Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    private void performLogin(String username) {

        Fragment fragment = LoggedFragment.newInstance(username);

        FragmentManager fragmentManager = this.getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.addToBackStack(null);

        transaction.replace(R.id.container, fragment);

        transaction.commit();

    }
}
