package com.example.fraudzsecurity.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.fraudzsecurity.AccountsFragment;
import com.example.fraudzsecurity.AddAccountFragment;
import com.example.fraudzsecurity.CheckTransactionFragment;
import com.example.fraudzsecurity.FundTransferFragment;
import com.example.fraudzsecurity.R;
import com.example.fraudzsecurity.databinding.FragmentAccountsBinding;
import com.example.fraudzsecurity.databinding.FragmentCheckTransactionBinding;
import com.example.fraudzsecurity.databinding.FragmentFundTransferBinding;
import com.example.fraudzsecurity.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
     //TextView textView,tvAddAccount,tvCheckTransaction,tvFundTransfer,tvAccounts;
     FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       /** homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);**/
       // View root = inflater.inflate(R.layout.fragment_home, container, false);
        // textView = root.findViewById(R.id.text_home);
         //tvAddAccount = root.findViewById(R.id.tvaddnewaccount);
        // tvCheckTransaction = root.findViewById(R.id.tvchecktrans);
        // tvFundTransfer = root.findViewById(R.id.tvfundtransfer);
         //tvAccounts= root.findViewById(R.id.tvaccounts);



        /**homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });**/
       // return root;


        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvaddnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment AddAccountFragment = new AddAccountFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,AddAccountFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.tvchecktrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment CheckTransactionFragment = new CheckTransactionFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,CheckTransactionFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.tvfundtransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment FundTransferFragment = new FundTransferFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,FundTransferFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.tvaccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment AccountsFragment = new AccountsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,AccountsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
