package com.example.practiceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainServiceActivity.class.getSimpleName();
    private AppCompatButton btnStartThread;
    private AppCompatButton btnStopThread;
    private TextView textViewThreadCount;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
        Log.i(TAG, "MainActivity thread id= " + Thread.currentThread().getId());

        //Mapping
        textViewThreadCount = findViewById(R.id.textViewThreadCount);
        btnStartThread = findViewById(R.id.btnStartThread);
        btnStopThread = findViewById(R.id.btnStopThread);

        btnStartThread.setOnClickListener(this);
        btnStopThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

}