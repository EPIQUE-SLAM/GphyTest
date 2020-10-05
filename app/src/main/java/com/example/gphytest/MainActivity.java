package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*
LOL on test ça
 */
public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnExit = findViewById(R.id.btnExit);
    }

    public void onClickStart(View view){
        Intent intent = new Intent(this, Page1.class);
        startActivity(intent);
    }

    public void onClickExit(View view) {
        finish();
    }

}