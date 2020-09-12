package com.example.fraudzsecurity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class AccountsFragment extends Fragment {

    String [] banks = { "Axis Bank","Bank of Baroda"};
    int [] images = {R.drawable.axis,R.drawable.bob};

    ListView listView;

    public AccountsFragment newInstance() {
        // Required empty public constructor
        AccountsFragment accountsFragment = new AccountsFragment();
        return accountsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);

        listView = (ListView) view.findViewById(R.id.selected_bank);
        AccountsFragment.CustomAdapter customAdapter = new AccountsFragment.CustomAdapter();
        listView.setAdapter(customAdapter);

       /** listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment VerifyMobileFragment = new VerifyMobileFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,VerifyMobileFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });**/


        return view;
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.bank_listview,null);
            ImageView mImageview = view.findViewById(R.id.bank_image);
            TextView mTextview = view.findViewById(R.id.bank_name);

            mImageview.setImageResource(images[position]);
            mTextview.setText(banks[position]);
            return view;
        }
    }
}
