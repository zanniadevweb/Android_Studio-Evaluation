package com.example.tp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SeancesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seances);

        // Initialisation des séances de films
        Modele.listeSeances.add(new Seance("Joker","Peter Jackson",72,"VF","12h00"));
        Modele.listeSeances.add(new Seance("Joker","Scorcese",72,"VF","12h00"));
        Modele.listeSeances.add(new Seance("Batman","Georges Lucas",12,"VO","18h00"));
        Modele.listeSeances.add(new Seance("Robin","David Lynch",180,"VF","2h00"));
        Modele.listeSeances.add(new Seance("Mr.Penguin","Hitchcok",160,"VOSTFR","13h00"));
        Modele.listeSeances.add(new Seance("Catwoman","David Fincher",59,"VF","11h00"));

        ListView ls_seances = findViewById(R.id.ls_seances);

        // Ajout / Affichage des films à l'écran
        SeanceAdaptater adapter = new SeanceAdaptater(getApplicationContext(), R.layout.activity_seance, Modele.listeSeances);
        ls_seances.setAdapter(adapter);

        // Le clic sur un film emmène vers l'écran de réservation
        ls_seances.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // naviguer vers l'autre activité
                Modele.filmCourant = Modele.listeSeances.get(position);
                startActivity(new Intent(SeancesActivity.this,ReservationActivity.class));
            }
        });
    }
}
