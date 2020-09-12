package com.example.fraudzsecurity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;

public class AddAccountFragment extends Fragment {

     String [] banks = { "Axis Bank","Bank of Baroda","Bank of India","Canara Bank","HDFC Bank","Karnataka Bank","State Bank of India","Indian Overseas Bank","Yes Bank" };
     int [] images = {R.drawable.axis,R.drawable.bob,R.drawable.boi,R.drawable.canara,R.drawable.hdfc,R.drawable.karnataka,R.drawable.sbi,R.drawable.iob,R.drawable.yesbank};

     ListView listView;

     public  AddAccountFragment newInstance(){

         AddAccountFragment addAccountFragment = new AddAccountFragment();
         return addAccountFragment;
     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_account, container, false);

        listView = (ListView) view.findViewById(R.id.bank_list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Fragment VerifyMobileFragment = new VerifyMobileFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.nav_host_fragment,VerifyMobileFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
               // startActivity(new Intent(getActivity().getApplicationContext(),VerifyMobileActivity.class));
            }
        });

        return view;
    }

    class CustomAdapter extends BaseAdapter{

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

