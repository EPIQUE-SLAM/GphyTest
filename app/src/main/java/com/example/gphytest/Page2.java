package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;

public class Page2 extends AppCompatActivity {

    private static int compteurPhysio2;
    private static int compteurBiotech2;
    private static int compteurImageur2;
    private static int compteurStupidite2;
    private static int compteurGauche2;
    private static int compteurDroite2;

    private Button btnNext2;

    private ProgressBar progressBar2;

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        ratingBar = findViewById(R.id.ratingBar);
        btnNext2 = findViewById(R.id.btnNext2);

        progressBar2 = findViewById(R.id.progressBar2);
        progressBar2.setMax(100);
        progressBar2.setProgress(50);

        ratingBar.setRating(2.5f);

    }


    public void onClick(View v) {

        //Incrémenter les scores de la page 1 au compteur de la page 2

        if (ratingBar.getRating() <= 2) {
            compteurPhysio2 = compteurPhysio2 + 3;
            compteurStupidite2 = compteurStupidite2 + 5;
        }
        if (ratingBar.getRating() <= 3 && ratingBar.getRating() > 2) {
            compteurBiotech2 = compteurBiotech2 + 3;
        }

        if (ratingBar.getRating() <=5 && ratingBar.getRating() >3) {
            compteurImageur2 = compteurImageur2 + 3;
        }


        Intent intentPage2 = new Intent(this, Page3.class);
        startActivity(intentPage2);
    }



    public void onClickPrevious (View v){
        finish();
    }

    protected void onResume() {

        super.onResume();
        compteurBiotech2 = 0;
        compteurPhysio2 = 0;
        compteurImageur2 =0;
        compteurGauche2 =0;
        compteurDroite2=0;
        compteurStupidite2=0;

    }

    public static int getCompteurPhysio2() {
        return compteurPhysio2;
    }

    public static int getCompteurBiotech2() {
        return compteurBiotech2;
    }

    public static int getCompteurImageur2() {
        return compteurImageur2;
    }

    public static int getCompteurStupidite2() {
        return compteurStupidite2;
    }

    public static int getCompteurGauche2() {
        return compteurGauche2;
    }

    public static int getCompteurDroite2() {
        return compteurDroite2;
    }

}