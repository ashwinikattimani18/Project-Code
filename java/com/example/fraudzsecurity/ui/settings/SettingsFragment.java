package com.example.fraudzsecurity.ui.settings;

import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
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

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;

    SwitchCompat switch_1,switch_2,switch_3,switch_4;
    boolean stateSwitch1,stateSwitch2,stateSwitch3,stateSwitch4;

    SharedPreferences preferences;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.settings_fragment, container, false);

        preferences = getActivity().getSharedPreferences("PREFS",0);

        stateSwitch1 = preferences.getBoolean("Switch 1",false);
        stateSwitch2 = preferences.getBoolean("Switch 2",false);
        stateSwitch3 = preferences.getBoolean("Switch 3",false);
        stateSwitch4 = preferences.getBoolean("Switch 4",false);


        switch_1 = (SwitchCompat) root.findViewById(R.id.switch_1);
        switch_2 = (SwitchCompat) root.findViewById(R.id.switch_2);
        switch_3 = (SwitchCompat) root.findViewById(R.id.switch_3);
        switch_4 = (SwitchCompat) root.findViewById(R.id.switch_4);

        switch_1.setChecked(stateSwitch1);
        switch_2.setChecked(stateSwitch2);
        switch_3.setChecked(stateSwitch3);
        switch_4.setChecked(stateSwitch4);

        switch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch1 = !stateSwitch1;
                switch_1.setChecked(stateSwitch1);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("Switch1",stateSwitch1);
                editor.apply();
            }
        });

        switch_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch2 = !stateSwitch2;
                switch_2.setChecked(stateSwitch2);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("Switch2",stateSwitch2);
                editor.apply();
            }
        });

        switch_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch3 = !stateSwitch3;
                switch_3.setChecked(stateSwitch3);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("Switch3",stateSwitch3);
                editor.apply();
            }
        });

        switch_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch4 = !stateSwitch4;
                switch_4.setChecked(stateSwitch4);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("Switch4",stateSwitch4);
                editor.apply();
            }
        });



        return root;
    }

}
