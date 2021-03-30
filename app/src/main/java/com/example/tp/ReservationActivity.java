package com.example.tp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReservationActivity extends AppCompatActivity {

    private Button  b_reserver,
                    b_plusTarifNormal,b_plusTarifEtudiant,b_plusTarifJeune,
                    b_moinsTarifNormal,b_moinsTarifEtudiant, b_moinsTarifJeune;

    private TextView    tv_heure, tv_titreFilm,
                        Tv_nombreTarifNormal,Tv_nombreTarifEtudiant,Tv_nombreTarifJeune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        // A chaque changement de film (entre deux réservations), on réinitiliase les compteurs du nombre de places à 0
        Modele.nbPlaceNormal = 0;
        Modele.nbPlaceEtudiant = 0;
        Modele.nbPlaceJeune = 0;

        // Au clic du bouton Reserver, emmener vers l'écran Récapitulatif
        b_reserver = findViewById(R.id.b_reserver);
        b_reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent ouvertureActivity = new Intent(ReservationActivity.this,RecapitulatifActivity.class);
                startActivity(ouvertureActivity);
            }
        });

        tv_titreFilm = findViewById(R.id.Tv_titreFilm);
        tv_titreFilm.setText(Modele.filmCourant.getNomFilm());

        tv_heure = findViewById(R.id.Tv_heureSeance);
        tv_heure.setText("Séance de \n"+Modele.filmCourant.getHeure());

        Tv_nombreTarifNormal = findViewById(R.id.Tv_nombreTarifNormal);
        Tv_nombreTarifNormal.setText(String.valueOf(Modele.nbPlaceNormal));

        Tv_nombreTarifEtudiant = findViewById(R.id.Tv_nombreTarifEtudiant);
        Tv_nombreTarifEtudiant.setText(String.valueOf(Modele.nbPlaceEtudiant));

        Tv_nombreTarifJeune = findViewById(R.id.Tv_nombreTarifJeune);
        Tv_nombreTarifJeune.setText(String.valueOf(Modele.nbPlaceJeune));

        // Evénements sur les clics des boutons PLUS : la condition sur le clic empêche de réserver plus de 99 places -> Simulation de contrainte réelle
        b_plusTarifNormal = findViewById(R.id.b_plusTarifNormal);
        b_plusTarifNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Modele.nbPlaceNormal < 100 ){ Modele.nbPlaceNormal++; Tv_nombreTarifNormal.setText(String.valueOf(Modele.nbPlaceNormal));  }
            }
        });
        b_plusTarifEtudiant = findViewById(R.id.b_plusTarifEtudiant);
        b_plusTarifEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Modele.nbPlaceEtudiant < 100 ){ Modele.nbPlaceEtudiant++; Tv_nombreTarifEtudiant.setText(String.valueOf(Modele.nbPlaceEtudiant));  }
            }
        });
        b_plusTarifJeune = findViewById(R.id.b_plusTarifJeune);
        b_plusTarifJeune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Modele.nbPlaceJeune < 100 ){ Modele.nbPlaceJeune++; Tv_nombreTarifJeune.setText(String.valueOf(Modele.nbPlaceJeune));  }
            }
        });

        // Evénements sur les clics des boutons MOINS : la condition sur le clic empêche de réserver moins de 0 places -> Eviter les nombres négatifs
        b_moinsTarifNormal = findViewById(R.id.b_moinsTarifNormal);
        b_moinsTarifNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Modele.nbPlaceNormal > 0 ){ Modele.nbPlaceNormal--; Tv_nombreTarifNormal.setText(String.valueOf(Modele.nbPlaceNormal));  }
            }
        });
        b_moinsTarifEtudiant = findViewById(R.id.b_moinsTarifEtudiant);
        b_moinsTarifEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Modele.nbPlaceEtudiant > 0 ){ Modele.nbPlaceEtudiant--; Tv_nombreTarifEtudiant.setText(String.valueOf(Modele.nbPlaceEtudiant));  }
            }
        });
        b_moinsTarifJeune = findViewById(R.id.b_moinsTarifJeune);
        b_moinsTarifJeune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Modele.nbPlaceJeune > 0 ){ Modele.nbPlaceJeune--; Tv_nombreTarifJeune.setText(String.valueOf(Modele.nbPlaceJeune));  }
            }
        });
    }

}

