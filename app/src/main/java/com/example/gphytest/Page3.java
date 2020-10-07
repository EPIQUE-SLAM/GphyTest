package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class Page3 extends AppCompatActivity {

    private Button btnNext3;
    private Button btnBack3;

    private RadioButton rbBtnJava;
    private RadioButton rbBtnAda;
    private RadioButton rbBtnCPP;
    private RadioButton rbBtnSQL;

    private RadioButton rbBtnHomme;
    private RadioButton rbBtnFemme;
    private RadioButton rbBtnAutre;

    private SeekBar seekBar;
    private int seekBarChangedValue;
    private ProgressBar progressBar3;
    private TextView txtViewProgrBar;

    private static int compteurPhysio3;
    private static int compteurImageur3;
    private static int compteurBiotech3;
    private static int compteurDroite3;
    private static int compteurGauche3;
    private static int compteurStupidite3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        btnNext3 = findViewById(R.id.btnNext3);
        btnBack3 = findViewById(R.id.btnBack3);

        rbBtnJava = findViewById(R.id.rbBtnJava);
        rbBtnCPP = findViewById(R.id.rbBtnCPP);
        rbBtnAda = findViewById(R.id.rbBtnAda);
        rbBtnSQL = findViewById(R.id.rbBtnSQL);

        rbBtnHomme = findViewById(R.id.rbBtnHomme);
        rbBtnFemme = findViewById(R.id.rbBtnFemme);
        rbBtnAutre = findViewById(R.id.rbBtnAutre);

        txtViewProgrBar = findViewById(R.id.txtViewProgrBar);

        progressBar3 = findViewById(R.id.progressBar3);
        progressBar3.setMax(100);
        progressBar3.setProgress(75);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setMin(0);
        seekBarChangedValue = 50;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarChangedValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                actualizeProgresseBar(seekBarChangedValue);
            }
        });

        txtViewProgrBar.setText("Vous êtes plutôt indecis\n ¯\\_(ツ)_/¯");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("###############################","onResume start");
        //Log.d("--------------",String.valueOf(compteurGauche3));
        compteurGauche3=0;
        compteurDroite3=0;
        compteurPhysio3=0;
        compteurBiotech3=0;
        compteurImageur3=0;
        compteurStupidite3=0;
        //Log.d("--------------",String.valueOf(compteurGauche3));
        Log.d("###############################","onResume finish");
    }

    public static int getCompteurGauche3() {
        return compteurGauche3;
    }

    public static int getCompteurPhysio3() {
        return compteurPhysio3;
    }

    public static int getCompteurImageur3() {
        return compteurImageur3;
    }

    public static int getCompteurStupidite3() {
        return compteurStupidite3;
    }

    public static int getCompteurBiotech3() {
        return compteurBiotech3;
    }

    public static int getCompteurDroite3() {
        return compteurDroite3;
    }

    public void onClickBack(View view) {
        finish();
    }

    public void actualizeProgresseBar(Integer progress) {
        String strTemp = "La barre est";
        if (seekBarChangedValue < 26) {
            strTemp = "Vive Faivre, la becane ma passion";
        } else if (seekBarChangedValue >= 26 && seekBarChangedValue < 46) {
            strTemp = strTemp + " pour Faivre";
        } else if (seekBarChangedValue >= 46 && seekBarChangedValue < 56) {
            strTemp = "Vous êtes plutôt indecis\n ¯\\_(ツ)_/¯";
        } else if (seekBarChangedValue >= 56 && seekBarChangedValue < 76) {
            strTemp = strTemp + " pour Domi";
        } else if (seekBarChangedValue >= 76) {
            strTemp = "Vive Domi, Geniet Power !!!";
        }
        txtViewProgrBar.setText(strTemp);
    }

    public void onClickNext(View view){
        if (seekBarChangedValue < 26){
            compteurGauche3=compteurGauche3+2;
        } else if (seekBarChangedValue >= 26 && seekBarChangedValue < 46){
            compteurGauche3=compteurGauche3+1;
        }else if (seekBarChangedValue >= 46 && seekBarChangedValue < 56){
            compteurStupidite3=compteurStupidite3+2;
        } else if (seekBarChangedValue >= 56 && seekBarChangedValue < 76){
            compteurDroite3=compteurDroite3+1;
        } else if (seekBarChangedValue >= 76){
            compteurDroite3=compteurDroite3+2;
        }

        if (rbBtnJava.isChecked()){
            compteurBiotech3=compteurBiotech3+1;
        } else if (rbBtnSQL.isChecked()){
            compteurStupidite3=compteurStupidite3+1;
        } else if (rbBtnCPP.isChecked()){
            compteurImageur3=compteurImageur3+2;
            compteurDroite3=compteurDroite3+1;
        } else if (rbBtnAda.isChecked()){
            compteurImageur3=compteurImageur3+1;
            compteurBiotech3=compteurBiotech3+1;
            compteurPhysio3=compteurPhysio3+1;
            compteurGauche3=compteurGauche3+2;
        }

        if (rbBtnHomme.isChecked()){
            compteurDroite3=compteurDroite3+2;
        } else if (rbBtnFemme.isChecked()){
            compteurGauche3=compteurGauche3+2;
        } else if (rbBtnAutre.isChecked()){
            compteurStupidite3=compteurStupidite3+3;
            compteurGauche3=compteurGauche3+3;
        }

        Log.d("---------------------------", "test");
        Intent intent = new Intent(this, Page4.class);
        startActivity(intent);
    }



//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        // Save UI state changes to the savedInstanceState
//        // This bundle will be passed to onCreate if the process is
//        // killed and restarted.
//        savedInstanceState.putInt("compteurGauche3", compteurGauche3);
//        savedInstanceState.putInt("compteurGauche", compteurGauche);
//
//        Log.d("save P3",String.valueOf(compteurGauche3));
//    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState){
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.d("###############################","");
//        Log.d("start restore P3","");
//
//        compteurGauche = savedInstanceState.getInt("compteurGauche");
//        compteurGauche=compteurGauche-compteurGauche3;
//        compteurGauche3=0;
//
//        Log.d("compteurGauche",String.valueOf(compteurGauche));
//        Log.d("compteurGauche3",String.valueOf(compteurGauche3));
//        Log.d("","finish restore P3");
//        Log.d("###############################","");
//    }
}