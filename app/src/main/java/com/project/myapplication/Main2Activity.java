package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvMsg = findViewById(R.id.tvMsg);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_NAME);
        tvMsg.setText(msg);
    }
}
