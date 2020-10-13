package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;

/**
 * Classe de la page 1 qui contient des questions
 */
public class Page1 extends AppCompatActivity {

    static private int compteurBiotech1;
    static private int compteurPhysio1;
    static private int compteurImageur1;
    static private int compteurGauche1;
    static private int compteurDroite1;
    static private int compteurStupidite1;

    RadioButton gaucheButton;
    RadioButton droiteButton;
    RadioButton noneButton;

    RadioButton painButton;
    RadioButton pateButton;
    RadioButton racletteButton;

    RadioButton allanButton;
    RadioButton annieButton;
    RadioButton pgButton;
    RadioButton domiButton;

    Button btnNext1;

    private ProgressBar progressBar1;

    /**
     * @param savedInstanceState
     *
     * Classe utilisée lors de la creation de la page
     * On y instancie les différents widgets et variables
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        gaucheButton = findViewById(R.id.gaucheButton);
        droiteButton = findViewById(R.id.droiteButton);
        noneButton = findViewById(R.id.noneButton);

        painButton = findViewById(R.id.painButton);
        pateButton = findViewById(R.id.pateButton);
        racletteButton = findViewById(R.id.racletteButton);

        allanButton = findViewById(R.id.allanButton);
        annieButton = findViewById(R.id.annieButton);
        pgButton = findViewById(R.id.pgButton);
        domiButton = findViewById(R.id.domiButton);

        btnNext1 = findViewById(R.id.btnNext1);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar1.setMax(100);
        progressBar1.setProgress(25);
    }

    /**
     * @param v
     *
     * Methode appelé lors du changement de page
     * On y incremente tout les compteurs en fonctions des reponses
     */
    public void onClick(View v) {

        if (gaucheButton.isChecked()) {
            compteurGauche1 = compteurGauche1+2;
        }

        if (droiteButton.isChecked()){
            compteurDroite1 = compteurDroite1 + 2;
        }

        if (noneButton.isChecked()){
            compteurStupidite1 = compteurStupidite1 + 2;
        }

        if (painButton.isChecked()){
            compteurImageur1 = compteurImageur1 + 3;
        }

        if (pateButton.isChecked()){
            compteurBiotech1 = compteurBiotech1 + 3;
        }

        if (racletteButton.isChecked()){
            compteurPhysio1 = compteurPhysio1 + 3;
        }

        if (allanButton.isChecked()){
            compteurImageur1 = compteurImageur1 + 2;
        }

        if (annieButton.isChecked()){
            compteurBiotech1 = compteurBiotech1 + 2;
        }

        if (pgButton.isChecked()){
            compteurStupidite1 = compteurStupidite1 + 2;
        }

        if (domiButton.isChecked()){
            compteurPhysio1 = compteurPhysio1 + 2;
        }


        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
        Log.d("---------------------------", String.valueOf(compteurBiotech1));
    }

    /**
     * Methode pour rendre responsive les images
     */
    public void onClickAllan(View view){
        allanButton.setChecked(true);
    }

    /**
     * Methode pour rendre responsive les images
     */
    public void onClickAnnie(View view){
        annieButton.setChecked(true);
    }

    /**
     * Methode pour rendre responsive les images
     */
    public void onClickDomi(View view){
        domiButton.setChecked(true);
    }

    /**
     * Methode pour rendre responsive les images
     */
    public void onClickPG(View view){
        pgButton.setChecked(true);
    }

    /**
     * @return int
     *
     * Retourne le compteur static qui sera recuperé sue la dernier page
     */
    static public int getCompteurBiotech1() {
        return compteurBiotech1;
    }

    /**
     * @return int
     *
     * Retourne le compteur static qui sera recuperé sue la dernier page
     */
    public static int getCompteurPhysio1() {
        return compteurPhysio1;
    }

    /**
     * @return int
     *
     * Retourne le compteur static qui sera recuperé sue la dernier page
     */
    public static int getCompteurImageur1() {
        return compteurImageur1;
    }

    /**
     * @return int
     *
     * Retourne le compteur static qui sera recuperé sue la dernier page
     */
    public static int getCompteurGauche1() {
        return compteurGauche1;
    }

    /**
     * @return int
     *
     * Retourne le compteur static qui sera recuperé sue la dernier page
     */
    public static int getCompteurDroite1() {
        return compteurDroite1;
    }

    /**
     * @return int
     *
     * Retourne le compteur static qui sera recuperé sue la dernier page
     */
    public static int getCompteurStupidite1() {
        return compteurStupidite1;
    }

    /**
     * Methode appelée après une pause (lors d'un retour par exemple avec finish())
     * Permet de remettre les compteurs static à zero lors d'un retour
     */
    @Override
    protected void onResume() {

        super.onResume();
        Log.d("---------------------------", "start resume");
        Log.d("---------------------------", String.valueOf(compteurBiotech1));
        compteurBiotech1 = 0;
        compteurPhysio1 = 0;
        compteurImageur1 =0;
        compteurGauche1 =0;
        compteurDroite1=0;
        compteurStupidite1=0;

        Log.d("---------------------------", String.valueOf(compteurBiotech1));

        Log.d("---------------------------", "finish resume");
    }
}