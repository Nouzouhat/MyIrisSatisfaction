package com.example.myiris;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imgProfs, imgProg, imgServ ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imgProfs= (ImageButton) findViewById(R.id.idProfesseurs);
        this.imgProg= (ImageButton) findViewById(R.id.idPedagogie);
        this.imgServ= (ImageButton) findViewById(R.id.idServices);

        this.imgServ.setOnClickListener(this);
        this.imgProg.setOnClickListener(this);
        this.imgProfs.setOnClickListener(this);

        //initialisation des enquêtes de IRIS
        IRIS.initialiser();

    }

    @Override
    public void onClick(View v) {
        String choix = "";
        if (v.getId() == R.id.idPedagogie) {
            choix = "Pedagogie";
        }else if (v.getId() == R.id.idServices) {
            choix = "Services";
        }else if (v.getId() == R.id.idProfesseurs){
            choix = "Professeurs";
        }
        //Passage à la prochaine activity
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("choix", choix);
        this.startActivity(unIntent);
    }
}
