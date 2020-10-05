package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.media.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class Page4 extends AppCompatActivity {

    private static int compteurPhysio4;
    private static int compteurImageur4;
    private static int compteurBiotech4;
    private static int compteurDroite4;
    private static int compteurGauche4;
    private static int compteurStupidite4;

    private Button btnNext4;
    private Button btnBack4;
    private ProgressBar progressBar4;

    private CheckBox checkBoxPhysio;
    private CheckBox checkBoxBiotech;
    private CheckBox checkBoxImagerie;
    private CheckBox checkBoxAnglais;
    private CheckBox checkBoxBDD;
    private CheckBox checkBoxCOOPOO;
    private CheckBox checkBoxMITBS;
    private CheckBox checkBoxIHM;

    private RadioButton rbPLB;
    private RadioButton rbMaison;
    private RadioButton rbWallaby;
    private RadioButton rbRevision;

    private Switch switchElephRhino;

    private TextView txtViewSwitch;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        btnNext4 = findViewById(R.id.btnNext4);
        btnBack4 = findViewById(R.id.btnBack4);

        progressBar4 = findViewById(R.id.progressBar4);
        progressBar4.setMax(100);
        progressBar4.setProgress(100);

        checkBoxPhysio=findViewById(R.id.checkBoxPhysio);
        checkBoxBiotech=findViewById(R.id.checkBoxBiotech);
        checkBoxImagerie=findViewById(R.id.checkBoxImagerie);
        checkBoxAnglais=findViewById(R.id.checkBoxAnglais);
        checkBoxBDD=findViewById(R.id.checkBoxBDD);
        checkBoxCOOPOO=findViewById(R.id.checkBoxCOOPOO);
        checkBoxMITBS=findViewById(R.id.checkBoxMITBS);
        checkBoxIHM=findViewById(R.id.checkBoxIHM);

        rbMaison=findViewById(R.id.rbMaison);
        rbPLB=findViewById(R.id.rbPLB);
        rbRevision=findViewById(R.id.rbRevision);
        rbWallaby=findViewById(R.id.rbWallaby);

        switchElephRhino = findViewById(R.id.switchElephRhino);

        txtViewSwitch = findViewById(R.id.txtViewSwitch);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("###############################","onResume start");
        //Log.d("--------------",String.valueOf(compteurGauche3));
        compteurGauche4=0;
        compteurDroite4=0;
        compteurPhysio4=0;
        compteurBiotech4=0;
        compteurImageur4=0;
        compteurStupidite4=0;
        //Log.d("--------------",String.valueOf(compteurGauche3));
        Log.d("###############################","onResume finish");
    }

    public void onClickBack(View view) {
        finish();
    }

    public static int getCompteurGauche4() {
        return compteurGauche4;
    }

    public static int getCompteurPhysio4() {
        return compteurPhysio4;
    }

    public static int getCompteurImageur4() {
        return compteurImageur4;
    }

    public static int getCompteurStupidite4() {
        return compteurStupidite4;
    }

    public static int getCompteurBiotech4() {
        return compteurBiotech4;
    }

    public static int getCompteurDroite4() {
        return compteurDroite4;
    }

    public void onClickNext(View view){
        if (checkBoxPhysio.isChecked()){
            compteurPhysio4=compteurPhysio4+3;
            compteurGauche4=compteurGauche4+1;
        }
        if (checkBoxBiotech.isChecked()){
            compteurBiotech4=compteurBiotech4+3;
            compteurGauche4=compteurGauche4+1;
            compteurDroite4=compteurDroite4+1;
        }
        if (checkBoxImagerie.isChecked()){
            compteurImageur4=compteurImageur4+3;
            compteurDroite4=compteurDroite4+1;
        }
        if (checkBoxAnglais.isChecked()){
            compteurPhysio4=compteurPhysio4+1;
            compteurDroite4=compteurDroite4+2;
        }
        if (checkBoxBDD.isChecked()){
            compteurPhysio4=compteurPhysio4+2;
        }
        if (checkBoxCOOPOO.isChecked()){
            compteurBiotech4=compteurBiotech4+1;
            compteurImageur4=compteurImageur4+1;
        }
        if (checkBoxMITBS.isChecked()){
            compteurPhysio4=compteurPhysio4+3;
            compteurBiotech4=compteurBiotech4+1;
        }
        if (checkBoxIHM.isChecked()){
            compteurBiotech4=compteurBiotech4+2;
            compteurImageur4=compteurImageur4+2;
        }

        if (!switchElephRhino.isChecked()){
            compteurStupidite4=compteurStupidite4+2;
        }

        if (rbWallaby.isChecked()){
            compteurDroite4=compteurDroite4+2;
            compteurImageur4=compteurImageur4+1;
        } else if (rbRevision.isChecked()){
            compteurPhysio4=compteurPhysio4+2;
            compteurGauche4=compteurGauche4+1;
        } else if (rbPLB.isChecked()){
            compteurGauche4=compteurGauche4+2;
            compteurBiotech4=compteurBiotech4+2;
        } else if (rbMaison.isChecked()){
            compteurGauche4=compteurGauche4+1;
        }

        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
    }

    public void onClickElephant(View view){
        if (switchElephRhino.isChecked()){
            mediaPlayer = MediaPlayer.create(this,R.raw.elepahnt);
            //mediaPlayer.start();
            txtViewSwitch.setText(switchElephRhino.getTextOn().toString());
        } else if (!switchElephRhino.isChecked()){
            txtViewSwitch.setText(switchElephRhino.getTextOff().toString());
        }

    }

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//        // Save UI state changes to the savedInstanceState.
//        // This bundle will be passed to onCreate if the process is
//        // killed and restarted.
//        savedInstanceState.putAll(savedInstanceState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState){
//        super.onRestoreInstanceState(savedInstanceState);
//    }

}