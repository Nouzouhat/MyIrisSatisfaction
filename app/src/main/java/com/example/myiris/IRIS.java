package com.example.myiris;

import java.util.HashMap;

public class IRIS {
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();

    public static void initialiser () {
        if ( ! lesEnquetes.containsKey("Professeurs")) {
            lesEnquetes.put("Professeurs", new Enquete());
        }

        if ( ! lesEnquetes.containsKey("Pedagogie")) {
            lesEnquetes.put("Pedagogie", new Enquete());
        }

        if ( ! lesEnquetes.containsKey("Services")) {
            lesEnquetes.put("Services", new Enquete());
        }
    }
    public static Enquete getEnquete (String nom) {
        return lesEnquetes.get(nom);
    }
}
