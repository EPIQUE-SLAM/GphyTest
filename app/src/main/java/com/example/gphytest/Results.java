package com.example.gphytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

/**
 * Classe qui permet d'fficher les reusltats finals
 */
public class Results extends AppCompatActivity {

    private static final String APP_TAG = "GphyTest";
    private int scorePhysio;
    private int scoreImageur;
    private int scoreBiotech;
    private int scoreDroite;
    private int scoreGauche;
    private int scoreStupide;
    private boolean isPhysio = false;
    private boolean isBiotech = false;
    private boolean isImageur = false;
    private boolean isStupide = false;
    private ImageView imageScore;




    private TextView viewScorePhysio2;
    private TextView viewScoreImageur2;
    private TextView viewScoreBiotech2;
    private TextView viewScoreDroite2;
    private TextView viewScoreGauche2;
    private TextView viewScoreStupide2;
    private EditText inputMail;
    private String mail;
    private TextView viewResultat;

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
        setContentView(R.layout.activity_results);

        viewScorePhysio2 = findViewById(R.id.viewScorePhysio2);
        viewScoreBiotech2 = findViewById(R.id.viewScoreBiotech2);
        viewScoreImageur2 = findViewById(R.id.viewScoreImageur2);
        viewScoreDroite2 = findViewById(R.id.viewScoreDroite2);
        viewScoreGauche2 = findViewById(R.id.viewScoreGauche2);
        viewScoreStupide2 = findViewById(R.id.viewScoreStupide2);
        viewResultat = findViewById(R.id.viewResultat);
        imageScore = findViewById(R.id.imageScore);
        inputMail = findViewById(R.id.inputMail);



        scorePhysio = Page1.getCompteurPhysio1() + Page2.getCompteurPhysio2() + Page3.getCompteurPhysio3() + Page4.getCompteurPhysio4();
        scoreBiotech = Page1.getCompteurBiotech1() + Page2.getCompteurBiotech2() + Page3.getCompteurBiotech3() + Page4.getCompteurBiotech4();
        scoreImageur = Page1.getCompteurImageur1() + Page2.getCompteurImageur2() + Page3.getCompteurImageur3() + Page4.getCompteurImageur4();
        scoreStupide = Page1.getCompteurStupidite1() + Page2.getCompteurStupidite2() + Page3.getCompteurStupidite3() + Page4.getCompteurStupidite4();
        scoreGauche = Page1.getCompteurGauche1() + Page2.getCompteurGauche2() + Page3.getCompteurGauche3() + Page4.getCompteurGauche4();
        scoreDroite = Page1.getCompteurDroite1() + Page2.getCompteurDroite2() + Page3.getCompteurDroite3() + Page4.getCompteurDroite4();

        Log.d("score physio", String.valueOf(scorePhysio));

        generalResult();
        equalResults();

        viewScorePhysio2.setText(String.valueOf(scorePhysio) + " points");
        viewScoreBiotech2.setText(String.valueOf(scoreBiotech)+" points");
        viewScoreImageur2.setText(String.valueOf(scoreImageur)+" points");
        viewScoreGauche2.setText(String.valueOf(scoreGauche)+ " points");
        viewScoreDroite2.setText(String.valueOf(scoreDroite)+" points");
        viewScoreStupide2.setText(String.valueOf(scoreStupide)+" points");

        verifyStoragePermissions(this);
    }

    /**
     * @param v
     *
     * Permet d'envoyer les resultats par mail
     */
    public void sendResult(View v){

        mail = inputMail.getText().toString();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{mail});
        i.putExtra(Intent.EXTRA_SUBJECT, "Results");
        i.putExtra(Intent.EXTRA_TEXT   , "Voici les résultats de votre GPHY test :\n\n" +viewResultat.getText() + "\n\n" + "Score Physio: " +scorePhysio + " points"+ "\n\n" + "Score Biotech: " +scoreBiotech + " points" + "\n\n" + "Score Imageur: " +scoreImageur + " points" + "\n\n" + "Score droite: " +scoreDroite + " points" + "\n\n" + "Score Gauche: " +scoreGauche + " points");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Results.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Classe qui va comparer les différents resultats et afficher une description personalisée pour chacun d'entre eux
     */
    public void generalResult (){

        if ((scorePhysio > scoreBiotech) && (scorePhysio > scoreImageur)  && (scorePhysio > scoreStupide)) {
            isPhysio = true;
            Log.d("--------------------","toto1");
            if (scoreGauche > scoreDroite) {
                Log.d("--------------------","toto2");
                viewResultat.setText("Vous êtes un physio de gauche ! Trop nul pour réussir la PACES et trop nul pour développer une appli. Mais au moins vous travaillerez à SANOFI et ça c'est la classe !  ");

                imageScore.setImageResource (R.drawable.raoult);

            }

            else {
                viewResultat.setText("Vous êtes un physio de droite ! Vous vous reposez sur meilleur que vous pour faire vos projets mais par contre il est HORS DE QUESTION de partager les cours ou les annales des années précédentes avec vos camarades! SALE GROS RADIN !!!! ");
                imageScore.setImageResource (R.drawable.billgates);
            }
        }

        if ((scoreBiotech > scorePhysio) && (scoreBiotech > scoreImageur)  && (scoreBiotech > scoreStupide)) {
            isBiotech = true;
            Log.d("--------------------","toto1");
            if (scoreGauche > scoreDroite) {
                Log.d("--------------------","toto2");
                viewResultat.setText("Vous êtes un biotech de gauche ! Alors, ça fait quoi de savoir que les GCell feront plus de biotech que vous à la sortie de la fac ??? bisous les rageux ! ");
                imageScore.setImageResource (R.drawable.melenchon);
            }

            else {
                viewResultat.setText("Vous êtes un biotech de droite !  Je trouve rien à dire sur vous tellement vous êtes insignifiant dans la société. ");
                imageScore.setImageResource (R.drawable.caca);
            }
        }


        if ((scoreImageur > scorePhysio) && (scoreImageur > scoreBiotech)  && (scoreImageur > scoreStupide)) {
            isImageur = true;
            Log.d("--------------------","toto1");
            if (scoreGauche > scoreDroite) {
                Log.d("--------------------","toto2");
                viewResultat.setText("Vous êtes un imageur de gauche ! Au fond de vous, vous savez que vous êtes le meilleur mais vous essayez de rester humble devant les minorités (coucou les physios et les stupides) ");
                imageScore.setImageResource (R.drawable.einstein);
            }

            else {
                viewResultat.setText("Vous êtes un imageur de droite ! Euh ça va le melon ??? Si vous vous la pétiez un peu moins peut-être que vous arriviez mieux à pécho sur Tinder à l'heure d'aujourd'hui ! ;) ");
                imageScore.setImageResource (R.drawable.lepen);
            }
        }

        if ((scoreStupide > scorePhysio) && (scoreStupide> scoreBiotech)  && (scoreStupide > scoreImageur)) {
            isStupide = true;
            Log.d("--------------------","toto1");
            if (scoreGauche > scoreDroite) {
                Log.d("--------------------","toto2");
                viewResultat.setText("Pas de chance, vous êtes un stupide de gauche! A défaut de n'avoir aucun avenir, vous pourrez toujours monter une cagnotte pour demander l'intégration de l'écriture inclusive dans les livres scolaires ! ");
                imageScore.setImageResource (R.drawable.lassalle);
            }

            else {
                viewResultat.setText("Vous êtes un stupide de droite ! Si vous ne trouvez pas de boulot, non ce n'est pas la faute des immigrés mais juste parce que vous êtes con ");
                imageScore.setImageResource (R.drawable.zemmour);
            }
        }

    }

    /**
     * Comme la méthode genralresult() sauf que celle-ci intervient en cas d'égalité des deux plus grands resultats
     */
    public void equalResults(){
        if(     scorePhysio == scoreImageur && scorePhysio !=0 && scoreImageur !=0 && !isBiotech && !isStupide ||
                scorePhysio==scoreBiotech && scorePhysio !=0 && scoreBiotech !=0 && !isImageur && !isStupide ||
                scorePhysio == scoreStupide && scorePhysio !=0 && scoreStupide !=0 && !isImageur && !isBiotech ||
                scoreImageur == scoreBiotech && scoreImageur !=0 && scoreBiotech !=0 && !isStupide && !isPhysio ||
                scoreImageur == scoreStupide && scoreImageur !=0 && scoreStupide !=0 && !isBiotech && !isPhysio ||
                scoreBiotech == scoreStupide && scoreBiotech !=0 && scoreStupide !=0 && !isImageur && !isPhysio ) {
            if (scoreDroite > scoreGauche){
                viewResultat.setText("Vous êtes un indécis de droite ! Vous avez le cul entre deux chaises en ce qui concerne les études par contre pour cracher sur les féministes y a du monde !! ");
                imageScore.setImageResource (R.drawable.travolta);
            }

            else if (scoreDroite < scoreGauche){
                viewResultat.setText("Vous êtes un indécis de gauche ! Vous vous êtes réorienté 4 fois avant de réussir votre L1 mais c'est à cause de la société et du système universitaire patriarcale ! #MENARETRASH ");
                imageScore.setImageResource (R.drawable.hollande);
            }

            else if (scoreDroite==scoreGauche) {
                viewResultat.setText("Vous êtes un indécis du centre! Remettez vous en question et apprenez à faire des choix ! Et SURTOUT, achetez vous une personnalité !  ");
                imageScore.setImageResource (R.drawable.macron);
            }
        }

    }

    // Listes des permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * @param activity
     *
     * Permet d'obtenir la permission de l'utilisateur (et du telephone surtout) pour pouvoir sauvegarder les resultats en local
     */
    public static void verifyStoragePermissions(Activity activity) {
// Vérifie si nous avons les droits d'écriture
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
// Aie, il faut les demander àl'utilisateur
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    /**
     * Permet de generer un fichier texte en local qui contient les resultats
     */
    public void write_historic_in_file() {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        File fileout = new File(folder, "GphyTest.txt");
        try (FileOutputStream fos = new FileOutputStream(fileout)) {
            PrintStream ps = new PrintStream(fos);
            ps.println("\nVoici l'historique de votre Quizz\n\n");
            String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
            ps.println("Fait le : "+currentDateTimeString);
            ps.println(viewResultat.getText().toString()+"\n\n");
            ps.println("Resumé de vos résultats :\n\n");
            ps.println("Score Physio : "+viewScorePhysio2.getText().toString()+"\n");
            ps.println("Score Biotech : "+viewScoreBiotech2.getText().toString()+"\n");
            ps.println("Score Imageur : "+viewScoreImageur2.getText().toString()+"\n");
            ps.println("Score Gauche : "+viewScoreGauche2.getText().toString()+"\n");
            ps.println("Score Droite : "+viewScoreDroite2.getText().toString()+"\n");
            ps.println("Score Stupide : "+viewScoreStupide2.getText().toString()+"\n");
            ps.close();
        } catch (FileNotFoundException e) {
            Log.e(APP_TAG,"File not found",e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(APP_TAG,"Error I/O",e);
        }

    }

    /**
     * @param view
     * @throws InterruptedException
     *
     * Permet lors du clique, de sauvegarder les données en local
     */
    public void onClickSave(View view) throws InterruptedException {
        write_historic_in_file();
        Toast.makeText(this, "Sauvegarde en cours", Toast.LENGTH_SHORT).show();
        vibrate(150);
        Thread.sleep(600);
        vibrate(150);
        Thread.sleep(600);
        vibrate(150);
        Thread.sleep(250);
        vibrate(150);
        Thread.sleep(250);
        vibrate(150);
        Thread.sleep(520);
        vibrate(150);
        Thread.sleep(250);
        vibrate(150);
        Thread.sleep(250);
        vibrate(150);
        Thread.sleep(250);
        vibrate(150);
        Thread.sleep(400);
        vibrate(150);
        Thread.sleep(350);
        vibrate(150);
        Thread.sleep(250);
        Toast.makeText(this, "Sauvegarde terminé dans votre dossier DCIM", Toast.LENGTH_SHORT).show();
    }

    /**
     * @param duration_ms
     *
     * Permet de generer une vibration
     */
    public void vibrate(long duration_ms) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(duration_ms < 1)
            duration_ms = 1;
        if(v != null && v.hasVibrator()) {
            // Attention changement comportement avec API >= 26 (cf doc)
            if(Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                v.vibrate(duration_ms);
            }
        }
        // sinon il n'y a pas de mécanisme de vibration
    }
}