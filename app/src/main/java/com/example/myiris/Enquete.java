package com.example.myiris;

import java.util.HashMap;

public class Enquete {
    private HashMap<String, Etudiant> lesEtudiants;

    public Enquete() {
        this.lesEtudiants = new HashMap<>();
    }
    public void ajouterEtudiant(Etudiant unEtudiant) {
        this.lesEtudiants.put(unEtudiant.getEmail(), unEtudiant);
    }
    public Etudiant getEtudiant (String email) {
        return this.lesEtudiants.get(email);
    }

    public HashMap<String, Etudiant> getLesEtudiants() {
        return lesEtudiants;
    }

    public void setLesEtudiants(HashMap<String, Etudiant> lesEtudiants) {
        this.lesEtudiants = lesEtudiants;
    }
}
