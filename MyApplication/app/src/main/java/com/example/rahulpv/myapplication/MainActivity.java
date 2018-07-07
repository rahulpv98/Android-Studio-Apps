package com.example.rahulpv.myapplication;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final static String TAG="statechange";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG , "oncreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG,"onPause()");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.v(TAG,"onPostResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop()");
    }
}
