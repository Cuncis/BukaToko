package com.boss.cuncis.bukatoko.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.boss.cuncis.bukatoko.R;
import com.boss.cuncis.bukatoko.utils.Converter;
import com.xwray.passwordview.PasswordView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SigninFragment extends Fragment {

    EditText etEmail;
    PasswordView etPassword;
    Button btnLogin;

    public SigninFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        etEmail = view.findViewById(R.id.et_email);
        etPassword = view.findViewById(R.id.et_password);
        btnLogin = view.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmail.length()>0 && etPassword.length()>0) {
                    if (Converter.isValidEmailId(etEmail.getText().toString())) {
                        auth();
                    } else {
                        Toast.makeText(getContext(), "Isi format email dengan benar!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Isi data dengan benar!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void auth() {
        Toast.makeText(getContext(), "Berhasil", Toast.LENGTH_SHORT).show();
    }

}















