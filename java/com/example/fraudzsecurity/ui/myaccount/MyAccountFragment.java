package com.example.fraudzsecurity.ui.myaccount;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fraudzsecurity.R;
import com.example.fraudzsecurity.ui.home.HomeViewModel;

public class MyAccountFragment extends Fragment {

    private MyAccountViewModel MyAccountViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MyAccountViewModel =
                ViewModelProviders.of(this).get(MyAccountViewModel.class);
        View root = inflater.inflate(R.layout.my_account_fragment, container, false);
       // final TextView textView = root.findViewById(R.id.text_my_account);
       // MyAccountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          //  @Override
          //  public void onChanged(@Nullable String s) {
          //      textView.setText(s);
         //   }
       // });







        return root;
    }


}
