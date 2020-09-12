package com.example.fraudzsecurity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyMobileFragment extends Fragment {



    Button btnverify;
    Spinner spinner;
    ProgressBar progressBar;
    private EditText phoneNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_verify_mobile, container, false);

        btnverify = (Button) view.findViewById(R.id.btn_verify_mobile);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(view.getContext(),R.layout.support_simple_spinner_dropdown_item,CountryCode.countryCodes));
        phoneNumber = view.findViewById(R.id.Mob);
        progressBar = view.findViewById(R.id.progressBar3);


        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String code = CountryCode.countryCodes[spinner.getSelectedItemPosition()];
                final String number = phoneNumber.getText().toString();

                final String complete_number = "+" + code + number;

                if (number.isEmpty() || number.length() < 10) {
                    phoneNumber.setError("Valid number is required!");
                    phoneNumber.requestFocus();
                    return;
                }
                else {

                        progressBar.setVisibility(view.VISIBLE);

                    Fragment EnterOtpFragment = new EnterOtpFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, EnterOtpFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();



                }



            }
        });



        return view;

    }


}

