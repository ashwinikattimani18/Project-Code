package com.example.fraudzsecurity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


public class EnterPinFragment extends Fragment {



    public EnterPinFragment() {
        // Required empty public constructor
    }
    Button btnsubmit;
    EditText enterPin;
    ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_enter_pin, container, false);
        btnsubmit = view.findViewById(R.id.btn_submit);
        enterPin = view.findViewById(R.id.editTextPin);
        progressBar = view.findViewById(R.id.progressBar6);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pin = enterPin.getText().toString().trim();
                if(TextUtils.isEmpty(pin) || pin.length()<6){

                    enterPin.setError("Enter a 6 digit pin!");
                    return;

                }



                Fragment ConfirmPinFragment = new ConfirmPinFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,ConfirmPinFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                progressBar.setVisibility(view.VISIBLE);
            }
        });

        return view;
    }
}