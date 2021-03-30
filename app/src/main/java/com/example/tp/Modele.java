package com.example.tp;

import java.util.ArrayList;


public class Modele {
    // Ensemble des séances à paraître
    static ArrayList<Seance> listeSeances = new ArrayList<Seance>();

    // Séance actuellement sélectionnée par l'utilisateur
    static Seance filmCourant;

    static int nbPlaceNormal = 0;
    static final double TARIF_NORMAL = 9.60;

    static int nbPlaceEtudiant = 0;
    static final double TARIF_ETUDIANT = 7;

    static int nbPlaceJeune = 0;
    static final double TARIF_JEUNE = 5;

}
