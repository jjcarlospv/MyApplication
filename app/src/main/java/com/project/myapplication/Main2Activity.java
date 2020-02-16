package com.project.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView tvMsg;
    private Button btnImp1;
    private Button btnImp2;
    private Button btnExp2;

    private String LOG_DEBUG = "DEBUG";
    private String LOG_ERROR = "ERROR";

    /**
     * Activity's LifeCycle Android
     */

    /**
     *This method executes just once
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvMsg = findViewById(R.id.tvMsg);
        btnImp1 = findViewById(R.id.btnImp1);
        btnImp2 = findViewById(R.id.btnImp2);
        btnExp2 = findViewById(R.id.btnExp2);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_NAME);
        tvMsg.setText(msg);

        // Definition of button's click event

        //Implicit intent
        btnImp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(iCamera.resolveActivity(getPackageManager()) != null){
                    startActivity(iCamera);
                }
            }
        });

        //Implicit intent
        btnImp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iYouTube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"));
                startActivity(iYouTube);
            }
        });

        //Explicit intent
        btnExp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri mapsUri = Uri.parse("https://www.google.com/maps/@-12.0853659,-76.9788883,15z");
                Intent iGoogleMaps= new Intent(Intent.ACTION_VIEW, mapsUri);
                iGoogleMaps.setPackage("com.google.android.apps.maps");
                startActivity(iGoogleMaps);
            }
        });
    }

    /**
     *This method makes visible the screen but it is not prepare
     * for user's interaction
     */
    @Override
    protected void onStart() {
        super.onStart();

        // This line is used to show red messages in Logcat.
        // See taps in the bottom os the project and you will see this option
        // "LogCat" then Select the device connected and the current running app (packageName)

        Toast.makeText(this, "App is visible", Toast.LENGTH_SHORT).show();
        Log.e(LOG_ERROR, "onStart");
    }

    /**
     *This method makes possible user can interact with the screen (UI)
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG_ERROR, "onResume");
    }

    /**
     *This method happens when user loses the focus of the screen. For example,
     * when tap the cellphone's square button to choose another app
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG_ERROR, "onPause");
    }

    /**
     * This method tells the system that the current activity is in background status
     * or when another app is being used by the user
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG_ERROR, "onStop");
    }

    /**
     * This method finishes the activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG_ERROR, "onDestroy");
    }


    /**
     * Method to handle the back event
     */
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.txtMessage));
        builder.setPositiveButton(getString(R.string.txtOk), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Method to finish the activity
                finish();
                //Method to dismiss the message dialog
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton(getString(R.string.txtCancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}