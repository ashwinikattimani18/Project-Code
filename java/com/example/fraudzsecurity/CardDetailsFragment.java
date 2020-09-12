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


/**
 * A simple {@link Fragment} subclass.
 */
public class CardDetailsFragment extends Fragment {

    Button btnokay;
    ProgressBar progressBar;

    public CardDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_card_details, container, false);

        btnokay = view.findViewById(R.id.btn_card_details);
        progressBar = view.findViewById(R.id.progressBar4);
        btnokay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment CreatePinFragment = new CreatePinFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,CreatePinFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                progressBar.setVisibility(view.VISIBLE);
            }
        });

        return  view;
    }
}
