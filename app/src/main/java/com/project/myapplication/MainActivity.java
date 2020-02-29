package com.project.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "ExtraName";
    private EditText etUserName;
    private EditText etPassword;

    public static final String SHARE_APP = "mySharedData";
    public String SHARE_USER_NAME = "userName";
    public String SHARE_PASSWORD = "password";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);

        //Shared preferences
        sharedPreferences = getSharedPreferences(SHARE_APP, MODE_PRIVATE);
        etUserName.setText(sharedPreferences.getString(SHARE_USER_NAME, ""));
        etPassword.setText(sharedPreferences.getString(SHARE_PASSWORD, ""));
        //////////

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickLogin(View view){

        sharedPreferences.edit().putString(SHARE_USER_NAME, etUserName.getText().toString()).apply();
        sharedPreferences.edit().putString(SHARE_PASSWORD, etPassword.getText().toString()).commit();

        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        intent.putExtra(EXTRA_NAME, etUserName.getText().toString());
        startActivity(intent);
    }
}
