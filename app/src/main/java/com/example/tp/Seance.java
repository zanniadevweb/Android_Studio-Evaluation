package com.example.tp;

public class Seance {
    private String nomFilm;
    private String realisateur;
    private int duree; // en minutes
    private String langue;
    private String heure;

    public Seance(String nom, String real, int duree, String langue, String heure){
        setNomFilm(nom);
        setRealisateur(real);
        setDuree(duree);
        setLangue(langue);
        setHeure(heure);
    }

    public String getNomFilm() {
        return nomFilm;
    }

    public void setNomFilm(String nomFilm) {
        this.nomFilm = nomFilm;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
