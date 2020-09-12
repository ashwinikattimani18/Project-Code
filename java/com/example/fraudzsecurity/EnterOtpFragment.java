package com.example.fraudzsecurity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static android.view.View.VISIBLE;


public class EnterOtpFragment extends Fragment {


    public EnterOtpFragment() {
        // Required empty public constructor
    }

    EditText editText;
    Button btnsubmitotp;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_enter_otp, container, false);
        btnsubmitotp = view.findViewById(R.id.btn_submit_otp);
        progressBar = view.findViewById(R.id.progressBar7);
        editText = view.findViewById(R.id.otp);



        btnsubmitotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = editText.getText().toString();
                if (code.isEmpty() || code.length()<6){
                    editText.setError("Enter code....");
                    editText.requestFocus();
                    return;
                }else{
                    progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(),"Verification Successful!",Toast.LENGTH_SHORT).show();
                    Fragment CardDetailsFragment = new CardDetailsFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment,CardDetailsFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }




            }
        });


        return  view;
    }


}