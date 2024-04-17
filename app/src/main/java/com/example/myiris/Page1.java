package com.example.myiris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page1 extends AppCompatActivity implements View.OnClickListener {

    private Button btSuivant;
    private RadioGroup rdQ1, rdQ2;
    private String choix, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.btSuivant = (Button) findViewById(R.id.idSuivant);
        this.rdQ1 = (RadioGroup) findViewById(R.id.idQ1);
        this.rdQ2 = (RadioGroup) findViewById(R.id.idQ2);

        this.btSuivant.setOnClickListener(this);
        this.choix= this.getIntent().getStringExtra("choix").toString();
        this.email = this.getIntent().getStringExtra("email").toString();
    }

    @Override
    public void onClick(View v) {
        int score = 0;
        if(v.getId() == R.id.idSuivant) {
            if(this.rdQ1.getCheckedRadioButtonId()==R.id.idQ11) {
                score = 16;
            }else if (this.rdQ1.getCheckedRadioButtonId()==R.id.idQ12){
                score = 14;
            }else {
                score = 8;
            }
            //on enregistre ce score avis general
            IRIS.getEnquete(this.choix).getEtudiant(this.email).ajouterReponse("avis", score);


            if(this.rdQ2.getCheckedRadioButtonId()==R.id.idQ21) {
                score = 16;
            }else if (this.rdQ2.getCheckedRadioButtonId()==R.id.idQ22){
                score = 14;
            }else {
                score = 8;
            }
            //on enregistre ce score avis general
            IRIS.getEnquete(this.choix).getEtudiant(this.email).ajouterReponse("efforts", score);


            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("choix", this.choix);
            unIntent.putExtra("email", this.email);
            this.startActivity(unIntent);
        }

    }
}
