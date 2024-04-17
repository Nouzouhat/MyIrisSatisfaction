package com.example.myiris;

import java.util.HashMap;

public class Etudiant {
    private String nom, prenom, email;
    private String promotion, statut;

    private String comment;
    private HashMap<String , Integer> lesReponses ;

    public Etudiant(String nom, String prenom, String email, String promotion, String statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.promotion = promotion;
        this.statut = statut;
        this.comment = "";
        this.lesReponses = new HashMap<>();
    }
    public void ajouterReponse (String question, int score) {
        //add pour ArrayList, put pour HashMap
        this.lesReponses.put(question, score);
    }
        public float moyenne (){
            float m = 0;
            for (Integer score : this.lesReponses.values()) {
                m = m + score;
            }

            m = m / this.lesReponses.size() ;
            return m;
        }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}

