package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.project.myapplication.fragments.ClientsFragment;
import com.project.myapplication.fragments.HomeFragment;
import com.project.myapplication.fragments.ReportFragment;
import com.project.myapplication.fragments.SettingsFragment;

public class MenuActivity extends AppCompatActivity {

    private ImageButton btnHome;
    private Button btnReport;
    private Button btnClients;
    private Button btnSettings;

    private HomeFragment homeFragment;
    private ReportFragment reportFragment;
    private ClientsFragment clientsFragment;
    private SettingsFragment settingsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnHome = findViewById(R.id.btnHome);
        btnReport = findViewById(R.id.btnReport);
        btnClients = findViewById(R.id.btnClients);
        btnSettings = findViewById(R.id.btnSettings);

        homeFragment = new HomeFragment();
        reportFragment = new ReportFragment();
        clientsFragment = new ClientsFragment();
        settingsFragment = new SettingsFragment();


        homeFragment.setHomeInterface(new HomeFragment.homeInterface() {
            @Override
            public void getData() {
               Toast.makeText(MenuActivity.this, "Hola HomeFragment", Toast.LENGTH_SHORT).show();
            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.llContainer, homeFragment).commit();


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.llContainer, homeFragment).commit();
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.llContainer, reportFragment).commit();
            }
        });

        btnClients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.llContainer, clientsFragment).commit();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.llContainer, settingsFragment).commit();
            }
        });

    }
}
