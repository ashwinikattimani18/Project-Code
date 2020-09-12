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
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ConfirmPinFragment extends Fragment {


    public ConfirmPinFragment() {
        // Required empty public constructor
    }

    Button btnconfirmpin;
    EditText confirmPin;
    ProgressBar progressBar;

    DatabaseReference reference;
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_confirm_pin, container, false);

        btnconfirmpin = view.findViewById(R.id.btn_confirm_pin);
        confirmPin = view.findViewById(R.id.editTextConfPin);
        progressBar = view.findViewById(R.id.progressBar8);

        user = new User();
        reference = FirebaseDatabase.getInstance().getReference().child("User");



        btnconfirmpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pin = confirmPin.getText().toString().trim();

                if(TextUtils.isEmpty(pin) || pin.length()<6){

                    confirmPin.setError("Enter a 6 digit pin!");
                    return;

                }

                user.setUserPin(confirmPin.getText().toString().trim());
                reference.child("user1").setValue(user);
                Toast.makeText(getActivity(),"Pin created successfully",Toast.LENGTH_LONG).show();

                Fragment ConfirmationTickFragment = new ConfirmationTickFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,ConfirmationTickFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                progressBar.setVisibility(view.VISIBLE);


            }
        });




        return view;
    }
}