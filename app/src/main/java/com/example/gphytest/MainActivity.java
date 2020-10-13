package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Classe d'introduction
 * modele de la page d'introduction
 */
public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnExit;

    MediaPlayer media1;

    /**
     * @param savedInstanceState
     *
     * Classe utilisée lors de la creation de la page
     * On y instancie les différents widgets et variables
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnExit = findViewById(R.id.btnExit);

        Song song = new Song();
        song.execute();
    }

    /**
     * @param view
     *
     * Lance la prochaine page de question
     */
    public void onClickStart(View view){
        Intent intent = new Intent(this, Page1.class);
        startActivity(intent);
    }

    /**
     * @param view
     *
     * Quitte l'application et stop le son si besoin
     */
    public void onClickExit(View view) {
        finish();
        media1.stop();
    }

    /**
     * Classe imbriquée utilisée pour jouer du son
     */
    class Song extends AsyncTask<Void, Integer, Void> {

        /**
         * Constructeur vide
         */
        public void Media() {
        }

        /**
         * Methode de base pas utilisée
         */
        @Override
        protected Void doInBackground(Void... voids) { // Se fait en background du thread UI
            return null;
        }

        /**
         * Methode de base pas utilisée
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /**
         * @param aVoid
         *
         * Methode utilisée pour instancier et jouer le son
         */
        @Override
        protected void onPostExecute(Void aVoid) { // S'exécute sur le ThreadUI après doInBackground
            super.onPostExecute(aVoid);
            media1 = MediaPlayer.create(getBaseContext(), R.raw.song);
            media1.start();
        }

    }
}