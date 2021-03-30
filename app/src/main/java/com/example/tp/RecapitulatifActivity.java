package com.example.tp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RecapitulatifActivity extends AppCompatActivity {

    private TextView tv_titreFilm, tv_heure, tv_coutTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitulatif);

        tv_titreFilm = findViewById(R.id.Tv_titreFilm2);
        tv_titreFilm.setText(Modele.filmCourant.getNomFilm());

        tv_heure = findViewById(R.id.Tv_heureSeance2);
        tv_heure.setText("Séance de "+Modele.filmCourant.getHeure());

        // Calcul du cout total à partir du nombre de places réservées pour chaque tarif sur l'écran de Réservation
        double coutTot = Modele.nbPlaceNormal*Modele.TARIF_NORMAL + Modele.nbPlaceEtudiant*Modele.TARIF_ETUDIANT + Modele.nbPlaceJeune*Modele.TARIF_JEUNE;
        tv_coutTotal = findViewById(R.id.Tv_coutTotal);
        tv_coutTotal.setText("cout total: "+coutTot+"€");

    }
}
