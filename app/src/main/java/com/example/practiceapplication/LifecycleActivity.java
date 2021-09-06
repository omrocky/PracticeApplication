package com.example.practiceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifecycleActivity extends AppCompatActivity {
    public static final String TAG = LifecycleActivity.class.getSimpleName();

    // onCreate() and onDestroy() executed once throughout the lifecycle.
    // First method to be called in Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.i(TAG, "in method onCreate");
    }

    // Second method to be called in Activity
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "in method onStart");
    }

    // Third method to be called in Activity
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in method onResume");
    }

     /*If the activity is in background then if we called app from background
     then this method will be called first at the place of onCreate() */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in method onRestart");
    }

    // After back-pressing, this is first method to be called
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in method onPause");
    }

    // After back-pressing, this is second method to be called
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in method onStop");
    }

    // After back-pressing, this is last method to be called
    // This method will call only on back-press button
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in method onDestroy");
    }

}