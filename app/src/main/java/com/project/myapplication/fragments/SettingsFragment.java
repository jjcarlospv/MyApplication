package com.project.myapplication.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.myapplication.MainActivity;
import com.project.myapplication.R;

public class SettingsFragment extends Fragment {


    private final String SHARE_DNI = "shareDni";
    private final String SHARE_ADDRESS = "shareAddress";
    private final String SHARE_COUNTRY = "shareCountry";

    private EditText etDni;
    private EditText etAddress;
    private EditText etCountry;
    private Button btnSave;
    private View view;

    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences(MainActivity.SHARE_APP, Context.MODE_PRIVATE);

        etDni = view.findViewById(R.id.etDni);
        etAddress = view.findViewById(R.id.etAddress);
        etCountry = view.findViewById(R.id.etCountry);
        btnSave = view.findViewById(R.id.btnSave);

        etDni.setText(String.valueOf(sharedPreferences.getInt(SHARE_DNI, 0)));
        etAddress.setText(sharedPreferences.getString(SHARE_ADDRESS, ""));
        etCountry.setText(sharedPreferences.getString(SHARE_COUNTRY, "Peru"));


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putInt(SHARE_DNI, Integer.valueOf(etDni.getText().toString())).commit();
                sharedPreferences.edit().putString(SHARE_ADDRESS, etAddress.getText().toString()).commit();
                sharedPreferences.edit().putString(SHARE_COUNTRY, etCountry.getText().toString()).commit();
            }
        });
    }
}
