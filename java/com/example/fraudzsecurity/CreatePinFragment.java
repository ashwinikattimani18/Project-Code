package com.example.fraudzsecurity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


public class CreatePinFragment extends Fragment {

    Button btncreatepin;
    ProgressBar progressBar;

    public CreatePinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_create_pin, container, false);

        btncreatepin = view.findViewById(R.id.btn_create_pin);
        progressBar = view.findViewById(R.id.progressBar5);

        btncreatepin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment EnterPinFragment = new EnterPinFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,EnterPinFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                progressBar.setVisibility(view.VISIBLE);
            }
        });



        return view;
    }
}