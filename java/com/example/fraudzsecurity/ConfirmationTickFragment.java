package com.example.fraudzsecurity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fraudzsecurity.ui.home.HomeFragment;


public class ConfirmationTickFragment extends Fragment {



    public ConfirmationTickFragment() {
        // Required empty public constructor
    }
    ImageView btntick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmation_tick, container, false);

        btntick = view.findViewById(R.id.btn_tick);
        btntick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment HomeFragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,HomeFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }



}