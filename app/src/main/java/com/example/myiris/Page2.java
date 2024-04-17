package com.example.myiris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class Page2 extends AppCompatActivity implements View.OnClickListener{
    private RatingBar rtAvis;
    private EditText comment;
    private Button btResultats;
    private String choix, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        this.btResultats = (Button) findViewById(R.id.idResultats);
        this.rtAvis = (RatingBar) findViewById(R.id.idAvis);
        this.comment = (EditText) findViewById(R.id.idComment);

        this.btResultats.setOnClickListener(this);
        this.choix= this.getIntent().getStringExtra("choix").toString();
        this.email = this.getIntent().getStringExtra("email").toString();
    }

    @Override
    public void onClick(View v) {
        String comment="";
        int score=0;
        if(v.getId() == R.id.idResultats) {
            comment = this.comment.getText().toString();
            IRIS.getEnquete(this.choix).getEtudiant(this.email).setComment(comment);

            score = (int)this.rtAvis.getProgress()*4;
            IRIS.getEnquete(this.choix).getEtudiant(this.email).ajouterReponse("general", score);

            Intent unIntent = new Intent (this, Fin.class);
            unIntent.putExtra("choix", this.choix);
            unIntent.putExtra("email", this.email);
            this.startActivity(unIntent);
        }
    }
}