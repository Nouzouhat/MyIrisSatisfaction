package com.example.myiris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNom, txtPrenom, txtEmail;
    private Spinner spPromotion;
    private RadioGroup rdEtudes;
    private Button btParticiper;

    private String choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.btParticiper=(Button) findViewById(R.id.idParticiper);
        this.txtNom= (EditText) findViewById(R.id.idNom);
        this.txtPrenom= (EditText) findViewById(R.id.idPrenom);
        this.txtEmail= (EditText) findViewById(R.id.idEmail);
        this.spPromotion = (Spinner) findViewById(R.id.idPromotion);
        this.rdEtudes = (RadioGroup) findViewById(R.id.idEtude);

        this.btParticiper.setOnClickListener(this);

        //remplir le spinner Promotion : BTS, Bachelor, Master.
        ArrayList<String> lesDiplomes = new ArrayList<>();
        lesDiplomes.add("BTS");
        lesDiplomes.add("Bachelor");
        lesDiplomes.add("Master");
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lesDiplomes);
        this.spPromotion.setAdapter(unAdapter);

        //on recupere le choix de l'enquete
        this.choix = this.getIntent().getStringExtra("choix").toString();
    }

    @Override
    public void onClick(View v) {
        String nom, prenom, email, promotion, statut;
        if (v.getId() == R.id.idParticiper) {
            nom = this.txtNom.getText().toString();
            prenom = this.txtPrenom.getText().toString();
            email = this.txtEmail.getText().toString();
            promotion = this.spPromotion.getSelectedItem().toString();
            if(this.rdEtudes.getCheckedRadioButtonId() == R.id.idAlternant) {
                statut = "Alternant";
            }else {
                statut = "Initial";
            }
            //Instanciation d'un étudiant
            Etudiant unEtudiant = new Etudiant(nom, prenom, email, promotion, statut);
            //ajouter l'étudiant dans l'enquête choisie
            IRIS.getEnquete(this.choix).ajouterEtudiant(unEtudiant);

            Toast.makeText(this, "Bienvenue dans l'enqête : "+this.choix, Toast.LENGTH_LONG).show();

            Intent unIntent = new Intent(this, Page1.class);
            //passage du chox de l'enquête et de l'email de l'etudiant comme $_SESSION
            unIntent.putExtra("choix", this.choix);
            unIntent.putExtra("email", email);

            this.startActivity(unIntent);
        }

    }
}
