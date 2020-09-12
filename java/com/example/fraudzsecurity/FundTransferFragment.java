package com.example.fraudzsecurity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.fraudzsecurity.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnSuccessListener;



/**
 * A simple {@link Fragment} subclass.
 */
public class FundTransferFragment extends Fragment {

    public FundTransferFragment() {
        // Required empty public constructor
    }

    Button btncontinue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fund_transfer, container, false);

        btncontinue = view.findViewById(R.id.btn_continue);

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Fund Transfer successful!", Toast.LENGTH_SHORT).show();

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
