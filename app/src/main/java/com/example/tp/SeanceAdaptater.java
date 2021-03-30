package com.example.tp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SeanceAdaptater extends ArrayAdapter<Seance> {
    private final Context context;
    private ArrayList<Seance> seances;

    public SeanceAdaptater(Context context, int resource, ArrayList<Seance> seances) {
        super(context, resource, seances);
        this.context = context;
        this.seances = seances;
    }

    // Pour chaque élément de la liste de séances, on crée une vue composée d'un linearlayout rempli avec une image générique et du texte
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_seance, parent, false);
        } else { convertView = (LinearLayout) convertView; }

        TextView viewTitre = (TextView) convertView.findViewById(R.id.tv_titreFilm);
        TextView viewReal = (TextView) convertView.findViewById(R.id.tv_realFilm);
        TextView viewDuree = (TextView) convertView.findViewById(R.id.tv_dureeFilm);
        TextView viewLangue = (TextView) convertView.findViewById(R.id.tv_langueFilm);

        viewTitre.setText(seances.get(position).getNomFilm());
        viewReal.setText(seances.get(position).getRealisateur());
        viewDuree.setText(formater(seances.get(position).getDuree()));
        viewLangue.setText(seances.get(position).getLangue());

        return convertView;
    }

    // Transforme la durée en minutes en durée heure+minutes au format h:mm, hh:mm, mm ou m
    private String formater(int duree) {
        int heures = 0,minutes = duree; String dureeFormatee="";
        if (minutes > 59) {
            while (minutes > 59) {minutes -= 60; heures++;}  // on compte 1h (-60min) à chaque tour de boucle, si le nombre de minute est < à 1h on s'arrête

            String minutesF = String.valueOf(minutes); if (minutes < 10) minutesF = '0' + minutesF; // afin d'avoir un format h:mm ou hh:mm dans tous les cas
            String heuresF = String.valueOf(heures);
            dureeFormatee = heuresF + 'h' + minutesF;

        }else{ // dans le cas où le film dure - d'une heure
            String minutesF = String.valueOf(minutes); if (minutes < 10) minutesF = '0' + minutesF;
            dureeFormatee = minutesF+"min";
        }

        return dureeFormatee;
    }
}