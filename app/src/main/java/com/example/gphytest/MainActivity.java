package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnExit;

    MediaPlayer media1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnExit = findViewById(R.id.btnExit);

        Song song = new Song();
        song.execute();
    }

    public void onClickStart(View view){
        Intent intent = new Intent(this, Page1.class);
        startActivity(intent);
    }

    public void onClickExit(View view) {
        finish();
    }

    class Song extends AsyncTask<Void, Integer, Void> {

        public void Media() {
        }

        @Override
        protected Void doInBackground(Void... voids) { // Se fait en background du thread UI
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) { // S'exécute sur le ThreadUI après doInBackground
            super.onPostExecute(aVoid);
            media1 = MediaPlayer.create(getBaseContext(), R.raw.song);
            media1.start();
        }

    }
}